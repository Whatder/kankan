package com.hexx95.kankan.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hexx95.kankan.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Hexx on 2018/7/3 15:49
 * 功能：fragment基类
 */
public abstract class BaseFragment extends Fragment {
    protected Activity mActivity;
    protected View mContentView;
    Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContentView = inflater.inflate(getLayoutID(), container, false);
        unbinder = ButterKnife.bind(this, mContentView);
        return mContentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initStatusBar();
        initView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    protected abstract int getLayoutID();

    protected void initView() {
    }


    private void initStatusBar() {
        View fit_view = mContentView.findViewById(R.id.fit_view);
        Toolbar tool_bar = mContentView.findViewById(R.id.toolbar);
        if (fit_view != null && tool_bar != null) {
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) fit_view.getLayoutParams();
            lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
            lp.height = getStatusBarHeight();
            fit_view.setLayoutParams(lp);
        }
    }

    protected int getStatusBarHeight() {
        /**
         * 获取状态栏高度
         * */
        int statusBarHeight1 = -1;
        //获取status_bar_height资源的ID
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusBarHeight1 = getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight1;
    }


}
