package com.example.zy.myapplication.Main;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

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

public class Tablayout3Activity extends AppCompatActivity {


    @BindView(R.id.home_container)
    FrameLayout homeContainer;
    @BindView(R.id.host_tab_layout)
    TabLayout hostTabLayout;
    @BindView(R.id.vp_context)
    ViewPager vpContext;
    private Unbinder unbinder;
    int[] tabResPressed=new int[]{R.drawable.ic_left,R.drawable.ic_stop,R.drawable.ic_right};
    int[] tabRes=new int[]{R.drawable.ic_insmall,R.drawable.ic_location,R.drawable.ic_inbigger};
    String[] tabTitle=new String[]{"tab1","tab2","tab3"};
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
        for(int i=0;i<tabTitle.length;i++){
            hostTabLayout.addTab(hostTabLayout.newTab().setCustomView(getTabView(this,i)));
        }
//        设置默认选中第一个tab并改变图标
        hostTabLayout.getTabAt(0).select();
        setIconViewSelected(0);


//        设置FragmentList
        List<Fragment> fragmentList=new ArrayList<>();
        fragmentList.add(BlankFragment.newInstance());
        fragmentList.add(BlankFragment2.newInstance());
        fragmentList.add(BlankFragment3.newInstance());

//        设置适配器并装载
        FragAdapter adapter=new FragAdapter(getSupportFragmentManager(),fragmentList);
        vpContext.setAdapter(adapter);

        hostTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                ViewPaper联动
                vpContext.setCurrentItem(tab.getPosition());
//                图标变为选中状态
                for (int i=0;i<tabTitle.length;i++){
                    if (i==tab.getPosition()){
                        setIconViewSelected(i);
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
//                图标变回未选中状态
                for (int i=0;i<tabTitle.length;i++){
                    if (i==tab.getPosition()){
                        setIconView(tab,i);
                    }
                }
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

    private void setIconView(TabLayout.Tab tab,int position) {
        View mView=tab.getCustomView();
        ImageView mImageView=(ImageView) mView.findViewById(R.id.iv_icon);
        TextView mtextView=(TextView)mView.findViewById(R.id.tv_title);
        mImageView.setImageResource(tabRes[position]);
        mtextView.setTextColor(getResources().getColor(android.R.color.darker_gray));
    }

    private void setIconViewSelected(int position) {
        View mView=hostTabLayout.getTabAt(position).getCustomView();
        ImageView mImageView=(ImageView) mView.findViewById(R.id.iv_icon);
        TextView mtextView=(TextView)mView.findViewById(R.id.tv_title);
        mImageView.setImageResource(tabResPressed[position]);
        mtextView.setTextColor(getResources().getColor(android.R.color.black));
    }

    private View getTabView(Context context, int position) {
        View view= LayoutInflater.from(context).inflate(R.layout.icon_view,null);
        ImageView imageView=(ImageView) view.findViewById(R.id.iv_icon);
        TextView textView=(TextView)view.findViewById(R.id.tv_title);
        imageView.setImageResource(tabRes[position]);
        textView.setText(tabTitle[position]);
        return view;
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
