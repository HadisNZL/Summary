package com.example.hadis.summary.activity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.example.hadis.summary.R;
import com.example.hadis.summary.base.BaseActivity;
import com.example.hadis.summary.utils.SDCardManager;
import com.example.hadis.summary.view.CircleImageView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * 描述：上传头像/图片
 *
 * @author hadis on 16.5.23.
 */
public class UpImageActivity extends BaseActivity {
    private File tempFile;
    private final int PHOTO_REQUEST_CAREMA = 100;//相机响应码
    private final int PHOTO_REQUEST_GALLERY = 101;//相册响应码
    private final int REQUESTCODE_CUTTING = 102;//剪切响应码
    private final String PHOTO_FILE_NAME = "temp_photo.jpg";
    private String imgFilePath;//剪切后pic保存路径

    private PopupWindow window;
    @ViewInject(R.id.img_touxiang)
    private CircleImageView avatarImg;
    private Uri imgCropUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upimage);
        x.view().inject(this);
    }

    @Event(value = {R.id.img_touxiang, R.id.btn_gallery, R.id.btn_camera, R.id.btn_cancel}, type = View.OnClickListener.class)
    private void onBtnClick(View v) {
        switch (v.getId()) {
            case R.id.img_touxiang:
                showPopwindow();
                break;
            case R.id.btn_gallery:
                window.dismiss();
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, PHOTO_REQUEST_GALLERY);
                break;
            case R.id.btn_camera:
                window.dismiss();
                Intent intent_camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                tempFile = new File(Environment.getExternalStorageDirectory(), PHOTO_FILE_NAME);
                intent_camera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
                startActivityForResult(intent_camera, PHOTO_REQUEST_CAREMA);
                break;
            case R.id.btn_cancel:
                window.dismiss();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {

            case PHOTO_REQUEST_GALLERY://相册
                if (data != null) {
                    imgCropUri = data.getData();
                    startPhotoCrop(imgCropUri);
                }
                break;
            case PHOTO_REQUEST_CAREMA://相机
                //  if (data != null) {
                File temp = new File(Environment.getExternalStorageDirectory() + "/" + PHOTO_FILE_NAME);
                imgCropUri = Uri.fromFile(temp);
                startPhotoCrop(imgCropUri);//裁剪
//                }
                break;
            case REQUESTCODE_CUTTING://图片裁剪
                setPicToView();
                break;

        }
    }

    /**
     * 保存裁剪之后的图片数据
     */
    private void setPicToView() {
        try {
            Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imgCropUri));
            Bitmap smallBitmap = SDCardManager.setScaleBitmap(bitmap, 2);//缩小1/2
            avatarImg.setImageBitmap(smallBitmap);
            imgFilePath = SDCardManager.saveTempBitmap(smallBitmap, System.currentTimeMillis() + ".jpg");
            showToast(imgFilePath);
            // 上传图片到服务器
            if (imgFilePath != null && imgFilePath.length() > 0) {
                // handler.sendEmptyMessage(TO_UPLOAD_FILE);
                UpImgLoad(imgFilePath);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void UpImgLoad(String imgFilePath) {
        String url = "http://www.ubetween.com.cn/api/mobile/avatar";
        RequestParams params = new RequestParams(url);
        params.addBodyParameter("token", "");
        params.addBodyParameter("Content-Type", "multipart/form-data; boundary=");
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                showToast("上传成功");
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    /**
     * 裁剪图片
     */
    private void startPhotoCrop(Uri imgUri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(imgUri, "image/*");
        intent.putExtra("crop", true);//裁剪信号
        intent.putExtra("aspectX", 1);//宽高的比例
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 1000);//裁剪图片宽高
        intent.putExtra("outputY", 1000);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
        intent.putExtra("return-data", false);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imgUri);//通过uri传递  防止裁剪后奔溃
        startActivityForResult(intent, REQUESTCODE_CUTTING);
    }

    /**
     * 头像选择器
     */
    private void showPopwindow() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.avatar_selector_layout, null);
        x.view().inject(this, view);
        window = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setAnimationStyle(R.style.mypopwindow_anim_style);
        window.setFocusable(true); // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        // 实例化一个ColorDrawable颜色为半透明
        // ColorDrawable dw = new ColorDrawable(0xb0000000);
        window.setBackgroundDrawable(new BitmapDrawable());
        window.showAtLocation(view, Gravity.BOTTOM, 0, 0); // 在底部显示
    }
}

