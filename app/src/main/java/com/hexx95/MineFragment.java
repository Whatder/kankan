package com.hexx95;

import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hexx95.kankan.R;
import com.hexx95.kankan.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Hexx on 2018/7/3 15:59
 * 功能：
 */
public class MineFragment extends BaseFragment {
    @BindView(R.id.iv_user_banner)
    ImageView ivUserBanner;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        initBanner();
    }

    private void initBanner() {
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) ivUserBanner.getLayoutParams();
        lp.height += getStatusBarHeight();
        lp.width = LinearLayout.LayoutParams.MATCH_PARENT;
        ivUserBanner.setLayoutParams(lp);
    }
}
