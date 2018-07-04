package com.hexx95.kankan;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.hexx95.KanKanFragment;
import com.hexx95.MineFragment;
import com.hexx95.TopFragment;
import com.hexx95.kankan.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    FragmentStatePagerAdapter fragmentPagerAdapter;
    List<Fragment> fragments = new ArrayList<>();
    @BindView(R.id.viewPagerMain)
    ViewPager viewPagerMain;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public StatusStyle setStatusStyle() {
        return StatusStyle.FULL;
    }

    @Override
    protected void initView() {
        fragments.add(new KanKanFragment());
        fragments.add(new TopFragment());
        fragments.add(new MineFragment());

        fragmentPagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };

        viewPagerMain.setAdapter(fragmentPagerAdapter);
        viewPagerMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                //改变状态栏字体
                if (i != 2)
                    setWhiteFontInStatus();
                else
                    setBlackFontInStatus();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
