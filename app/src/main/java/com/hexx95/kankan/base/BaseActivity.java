package com.hexx95.kankan.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;

import com.hexx95.kankan.R;

import butterknife.ButterKnife;

/**
 * Created by Hexx on 2018/7/3 14:45
 * 功能：Activity基类
 */
public abstract class BaseActivity extends AppCompatActivity {
    private Window window;
    private View decorView;

    /**
     * 状态栏颜色
     */
    public enum StatusStyle {
        FULL, DARK, LIGHT

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        window = getWindow();
        decorView = window.getDecorView();
        setContentView(getLayoutID());
        ButterKnife.bind(this);
        getStatusStyle();
    }

    protected abstract int getLayoutID();


    public StatusStyle setStatusStyle() {
        return StatusStyle.FULL;
    }

    private void getStatusStyle() {
        StatusStyle style = setStatusStyle();
        switch (style) {
            case FULL:
                applyFullStyle();
                break;
            case DARK:
                applyDarkStyle();
                break;
            case LIGHT:
                applyLightStyle();
                break;
        }
    }

    /**
     * 全屏状态栏
     */
    private void applyFullStyle() {
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        window.setStatusBarColor(Color.TRANSPARENT);
    }

    /**
     * 深色状态栏
     */
    private void applyDarkStyle() {
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        window.setStatusBarColor(Color.TRANSPARENT);
        Toolbar toolbar = decorView.findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setBackgroundColor(Color.parseColor("#313131"));
            toolbar.setTitleTextColor(Color.WHITE);
            toolbar.setFitsSystemWindows(true);
        }
    }

    /**
     * 亮色状态栏-黑色字体
     */
    private void applyLightStyle() {
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        window.setStatusBarColor(Color.TRANSPARENT);
        Toolbar toolbar = decorView.findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setFitsSystemWindows(true);
        }
    }
}
