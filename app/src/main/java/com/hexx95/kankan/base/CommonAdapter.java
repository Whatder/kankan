package com.hexx95.kankan.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Hexx on 2018/7/27 14:23
 * 功能：
 */
public abstract class CommonAdapter<T> extends RecyclerView.Adapter<CommonViewHolder> {
    private Context context;
    private List<T> datas;
    private LayoutInflater layoutInflater;
    CommonAdapterTypeSupport support;

    public CommonAdapter(Context context, List<T> datas, CommonAdapterTypeSupport support) {
        this.context = context;
        this.datas = datas;
        this.layoutInflater = LayoutInflater.from(this.context);
        this.support = support;

    }

    //   这里返回的是不同type的view ID而不是type
    @Override
    public int getItemViewType(int position) {
        return support.getViewLayout(datas.get(position), position);

    }

    @NonNull
    @Override
    public CommonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int layoutFromType) {
        return new CommonViewHolder(layoutInflater.inflate(layoutFromType, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CommonViewHolder holder, int i) {
        bindData(holder, i, datas.get(i));
    }

    public abstract void bindData(CommonViewHolder holder, int position, T data);


    @Override
    public int getItemCount() {
        return datas.size();
    }


}
