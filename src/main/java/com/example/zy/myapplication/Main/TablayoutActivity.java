package com.example.zy.myapplication.Main;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TableLayout;

import com.example.zy.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TablayoutActivity extends AppCompatActivity {



    @BindView(R.id.home_container)
    FrameLayout homeContainer;
    @BindView(R.id.host_tab_layout)
    TabLayout hostTabLayout;
    private Unbinder unbinder;
    private Fragment[] mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        initView();
    }

    /**
     * 用ButterKnife快速绑定View控件
     */
    private void initView() {

        unbinder=ButterKnife.bind(this);
        hostTabLayout.addTab(hostTabLayout.newTab().setText("TDab1"));
        hostTabLayout.addTab(hostTabLayout.newTab().setText("TDab2"));
        hostTabLayout.addTab(hostTabLayout.newTab().setText("TDab3"));

        hostTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

//                选中了标签的逻辑
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

//                未选中tab的逻辑
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

//                再次选中tab的逻辑
            }
        });
    }



    /**
     * 需要对binder解除绑定
     */
    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
