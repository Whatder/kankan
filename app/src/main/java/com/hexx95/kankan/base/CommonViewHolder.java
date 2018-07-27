package com.hexx95.kankan.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Hexx on 2018/7/27 16:05
 * 功能：
 */

public class CommonViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> views;

    public CommonViewHolder(@NonNull View itemView) {
        super(itemView);
        views = new SparseArray<>();
        ButterKnife.bind(itemView);
    }


    public <T extends View> T getView(int id) {
        View view = views.get(id);
        if (view == null) {
            view = itemView.findViewById(id);
            views.put(id, view);
        }
        return (T) view;
    }
}
