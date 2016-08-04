package com.example.hadis.summary.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author hadis on 16.5.24.
 */
public class SDCardManager {

    private static final String TAG = "SDCardManager";
    public static final String SAVE_NAME = "/ubetweenpublicwelfare/";

    /**
     * 保存bitmap到sd卡
     *
     * @param bitmap
     * @param fileName
     * @return
     */
    public static String saveTempBitmap(Bitmap bitmap, String fileName) {
        if (bitmap == null || fileName == null || fileName.length() == 0) {
            return "";
        }

        createWholePermissionFolder(Environment.getExternalStorageDirectory() + SAVE_NAME);
        File bitmapFile = new File(Environment.getExternalStorageDirectory() + SAVE_NAME, fileName);
        FileOutputStream bitmapWriter;
        String retPath = "";
        try {
            bitmapWriter = new FileOutputStream(bitmapFile);
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 75, bitmapWriter)) {
                bitmapWriter.flush();
                bitmapWriter.close();
                retPath = Environment.getExternalStorageDirectory() + SAVE_NAME + fileName;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retPath;
    }

    public static boolean createWholePermissionFolder(String path) {
        Log.d(TAG, "+ createWholePermissionFolder()");

        Process p;
        int status = -1;
        boolean isSuccess = false;

        try {
            File destDir = new File(path);
            if (!destDir.exists()) {
                destDir.mkdirs();
            }

            p = Runtime.getRuntime().exec("chmod 777 " + destDir);
            status = p.waitFor();
            if (status == 0) {
                Log.d(TAG, "Modify folder permission success!");
                isSuccess = true;
            } else {
                Log.e(TAG, "Modify folder permission fail!");
            }
        } catch (Exception e) {
            Log.e(TAG, "Modify folder permission exception!: " + e.toString());
        }

        Log.d(TAG, "- createWholePermissionFolder()");
        return isSuccess;
    }

    /**
     * 缩小显示
     *
     * @param photo
     * @param SCALE
     * @return
     */
    public static Bitmap setScaleBitmap(Bitmap photo, int SCALE) {
        if (photo != null) {
            //为防止原始图片过大导致内存溢出，这里先缩小原图显示，然后释放原始Bitmap占用的内存
            //这里缩小了1/2,但图片过大时仍然会出现加载不了,但系统中一个BITMAP最大是在10M左右,我们可以根据BITMAP的大小
            //根据当前的比例缩小,即如果当前是15M,那如果定缩小后是6M,那么SCALE= 15/6
            Bitmap smallBitmap = zoomBitmap(photo, photo.getWidth() / SCALE, photo.getHeight() / SCALE);
            //释放原始图片占用的内存，防止out of memory异常发生
            photo.recycle();
            return smallBitmap;
        }
        return null;
    }

    public static Bitmap zoomBitmap(Bitmap bitmap, int width, int height) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        Matrix matrix = new Matrix();
        float scaleWidth = ((float) width / w);
        float scaleHeight = ((float) height / h);
        matrix.postScale(scaleWidth, scaleHeight);// 利用矩阵进行缩放不会造成内存溢出
        Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);
        return newbmp;
    }

}
