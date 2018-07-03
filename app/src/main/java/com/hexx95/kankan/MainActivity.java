package com.hexx95.kankan;

import com.hexx95.kankan.base.BaseActivity;

public class MainActivity extends BaseActivity {


    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public StatusStyle setStatusStyle() {
        return StatusStyle.DARK;
    }
}
