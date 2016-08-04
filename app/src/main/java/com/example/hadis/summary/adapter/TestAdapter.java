package com.example.hadis.summary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.hadis.summary.R;

/**
 * @author hadis on 16.3.31.
 */
public class TestAdapter extends BaseAdapter {
    private Context context;

    public TestAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_welcome, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }


    public static class ViewHolder {
        public View rootView;
        public Button start_Button;
        public LinearLayout indicator;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.start_Button = (Button) rootView.findViewById(R.id.start_Button);
            this.indicator = (LinearLayout) rootView.findViewById(R.id.indicator);
        }
    }
}
