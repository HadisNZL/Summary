package com.example.hadis.summary.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hadis.summary.R;
import com.example.hadis.summary.bean.RecycBean;
import com.example.hadis.summary.bean.Subject;
import com.example.hadis.summary.utils.GlideUtil;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 类描述：RecyclerViewAdapter
 *
 * @author hadis on 16.4.13.
 */
public class CardViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Subject> list;

    public CardViewAdapter(Context context, List<Subject> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cardview_item_layout, parent, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RecyclerViewHolder) {
            String imgg = list.get(position).getImages().getLarge();
            GlideUtil.loadImgCenterCrop(context,imgg,R.color.white,((RecyclerViewHolder) holder).imavPic);
            //Glide.with(context).load(imgg).into(((RecyclerViewHolder) holder).imavPic);
            ((RecyclerViewHolder) holder).tvUrl.setText(list.get(position).getTitle());
        }
    }


    @Override
    public int getItemCount() {
        // 返回数据有多少条
        return list.size() == 0 ? 0 : list.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        @ViewInject(R.id.pic)
        public ImageView imavPic;
        @ViewInject(R.id.name)
        public TextView tvUrl;

        public RecyclerViewHolder(View rootView) {
            super(rootView);
            x.view().inject(this, rootView);
        }

    }
}
