package com.example.zy.myapplication.Main;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;

import com.example.zy.myapplication.Fragment.BlankFragment;
import com.example.zy.myapplication.Fragment.BlankFragment2;
import com.example.zy.myapplication.Fragment.BlankFragment3;
import com.example.zy.myapplication.R;
import com.example.zy.myapplication.Utils.FragAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TablayoutActivity extends AppCompatActivity {


    @BindView(R.id.home_container)
    FrameLayout homeContainer;
    @BindView(R.id.host_tab_layout)
    TabLayout hostTabLayout;
    @BindView(R.id.vp_context)
    ViewPager vpContext;
    private Unbinder unbinder;
    private Fragment[] mFragment;
    private  FragAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        unbinder = ButterKnife.bind(this);
        initView();
    }

    /**
     * 用ButterKnife快速绑定View控件
     */
    private void initView() {
//        给TablLayout添加标签
        hostTabLayout.addTab(hostTabLayout.newTab().setText("TDab1").setIcon(getResources().getDrawable(R.drawable.ic_insmall)));
        hostTabLayout.addTab(hostTabLayout.newTab().setText("TDab2").setIcon(getResources().getDrawable(R.drawable.ic_location)));
        hostTabLayout.addTab(hostTabLayout.newTab().setText("TDab3").setIcon(getResources().getDrawable(R.drawable.ic_inbigger)));


//        设置FragmentList
        List<Fragment> fragmentList=new ArrayList<Fragment>();
        fragmentList.add(BlankFragment.newInstance());
        fragmentList.add(BlankFragment2.newInstance());
        fragmentList.add(BlankFragment3.newInstance());

//        设置适配器并装载
       adapter=new FragAdapter(getSupportFragmentManager(),fragmentList);
        vpContext.setAdapter(adapter);

        hostTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpContext.setCurrentItem(tab.getPosition());
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

        vpContext.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                hostTabLayout.getTabAt(position).select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

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
