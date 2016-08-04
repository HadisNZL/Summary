package com.example.hadis.summary.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.example.hadis.summary.R;
import com.example.hadis.summary.base.BaseActivity;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BiaoqianActivity extends BaseActivity {
    @ViewInject(R.id.gview)
    private GridView gridView;

    private String[] iconName = {"敬老", "扶贫", "捐助", "公益", "关爱", "无私"};
    private List<Map<String, Object>> data_list = new ArrayList<Map<String, Object>>();
    private SimpleAdapter sim_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biaoqian);
        x.view().inject(this);

        initView();

    }

    private void initView() {
        //获取数据
        getData();
        //新建适配器
        String[] from = {"text"};
        int[] to = {R.id.text};
        sim_adapter = new SimpleAdapter(this, data_list, R.layout.item_biaoqain, from, to);
        gridView.setAdapter(sim_adapter);
        sim_adapter.notifyDataSetChanged();
    }

    public List<Map<String, Object>> getData() {
        for (int i = 0; i < iconName.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("text", iconName[i]);
            data_list.add(map);
        }
        return data_list;
    }
}
