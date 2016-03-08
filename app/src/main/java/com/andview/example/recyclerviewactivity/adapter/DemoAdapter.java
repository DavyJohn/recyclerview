package com.andview.example.recyclerviewactivity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.andview.example.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zzh on 16-3-7.
 */
public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Map<String,Object>> list=new ArrayList<>();
    public DemoAdapter(Context context,List list){
         this.list=list;
        layoutInflater=LayoutInflater.from(context);
    }
    
    @Override
    public DemoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.demo,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.imageView= (ImageView) view.findViewById(R.id.image);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return list.size() ;
    }

    @Override
    public void onBindViewHolder(final DemoAdapter.ViewHolder holder, final int position) {
                holder.imageView.setImageResource(Integer.parseInt(String.valueOf(list.get(position).get("image"))));
        //如果设置回调则设置点击事件
        if (onItemClickLitener!=null){
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickLitener.OnItemClick(holder.itemView,position);
                    }
                });
                }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        ImageView imageView;
    }

    //写一个ItemClick回调接口
    public interface  OnItemClickLitener{
        void OnItemClick(View view,int position);
    }

    public OnItemClickLitener onItemClickLitener;

    public void  setOnItemClickLitener(OnItemClickLitener onItemClickLitener){
        this.onItemClickLitener=onItemClickLitener;
    }
}
