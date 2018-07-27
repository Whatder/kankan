package com.hexx95;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hexx95.kankan.R;
import com.hexx95.kankan.base.BaseFragment;
import com.hexx95.kankan.base.CommonAdapter;
import com.hexx95.kankan.base.CommonAdapterTypeSupport;
import com.hexx95.kankan.base.CommonViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Hexx on 2018/7/3 15:59
 * 功能：
 */
public class MineFragment extends BaseFragment {
    @BindView(R.id.iv_user_banner)
    ImageView ivUserBanner;
    @BindView(R.id.rv_kan_list)
    RecyclerView rvKanList;
    KanListAdapter adapter;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        initBanner();
        initList();
    }

    private void initBanner() {
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) ivUserBanner.getLayoutParams();
        lp.height += getStatusBarHeight();
        lp.width = LinearLayout.LayoutParams.MATCH_PARENT;
        ivUserBanner.setLayoutParams(lp);
    }

    private void initList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("item" + i);
        }
        adapter = new KanListAdapter(mActivity, list, new CommonAdapterTypeSupport() {
            @Override
            public int getViewLayout(Object item, int position) {
                return position == 0 || position == 1 ? R.layout.item_kan_list_copy : R.layout.item_kan_list;
            }
        });
        rvKanList.setLayoutManager(new LinearLayoutManager(mActivity));
        rvKanList.setAdapter(adapter);
    }

    class KanListAdapter extends CommonAdapter<String> {


        public KanListAdapter(Context context, List<String> datas, CommonAdapterTypeSupport support) {
            super(context, datas, support);
        }

        @Override
        public void bindData(CommonViewHolder holder, int position, final String data) {
            if (position == 0 || position == 1) {
                (holder.getView(R.id.iv_bg)).setBackgroundColor(Color.parseColor("#eeeeee"));
                holder.getView(R.id.item_view).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mActivity, "我是图", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                ((TextView) holder.getView(R.id.tv_content)).setText(data);
                holder.getView(R.id.item_view).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mActivity, "click" + data, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }
}
