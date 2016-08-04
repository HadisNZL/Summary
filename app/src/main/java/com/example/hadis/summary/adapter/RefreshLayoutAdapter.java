package com.example.hadis.summary.adapter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hadis.summary.R;
import com.example.hadis.summary.bean.VideoDeatils;
import com.example.hadis.summary.utils.GlideUtil;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;


public class RefreshLayoutAdapter extends BaseAdapter {
    private List<VideoDeatils> list;
    private Context context;
    private LayoutInflater inflater;

    public RefreshLayoutAdapter(List<VideoDeatils> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder vHolder;// 视频
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.item_gridview_search, parent, false);
            vHolder = new ViewHolder(convertView);
            convertView.setTag(vHolder);
        } else {
            vHolder = (ViewHolder) convertView.getTag();
        }
        if (list.size() != 0) {
            String vprice = list.get(position).getVprice();
            vHolder.v_price.setText(Html.fromHtml("<font color=\'#ffffff\'>￥</font><font color=\'#F3FF7B\'>" + vprice
                    + "</font></font><font color=\'#999999\'>"));
            GlideUtil.loadImgCenterCrop(context, list.get(position).getImg_url(), R.color.white, vHolder.thumb_first_01);
        }
        return convertView;
    }

    public static class ViewHolder {
        @ViewInject(R.id.thumb_first_01)
        ImageView thumb_first_01;
        @ViewInject(R.id.shouy_relative)
        RelativeLayout shouy_relative;
        @ViewInject(R.id.v_price)
        TextView v_price;

        public ViewHolder(View convertView) {
            x.view().inject(this, convertView);
        }
    }
}
