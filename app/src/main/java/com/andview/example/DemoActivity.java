package com.andview.example;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.andview.example.recyclerviewactivity.adapter.DemoAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zzh on 16-3-7.
 */
public class DemoActivity extends Activity {
    RecyclerView recyclerView;
    private DemoAdapter adapter;
    private List<Map<String ,Object>> list=new ArrayList<>();
    private int []  image={R.mipmap.test01,R.mipmap.test02,R.mipmap.test03};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_main);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        for (int i=0;i<image.length;i++){
            Map<String ,Object> map=new HashMap<>();
            map.put("image",image[i]);
            list.add(map);
        }
        adapter=new DemoAdapter(this,list);

        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickLitener(new DemoAdapter.OnItemClickLitener() {
            @Override
            public void OnItemClick(View view, int position) {
                Toast.makeText(DemoActivity.this,"点击"+position,Toast.LENGTH_SHORT).show();
            }
        });

    }


}
