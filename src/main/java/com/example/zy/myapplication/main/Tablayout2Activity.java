package com.example.zy.myapplication.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.example.zy.myapplication.fragment.BlankFragment;
import com.example.zy.myapplication.fragment.BlankFragment2;
import com.example.zy.myapplication.fragment.BlankFragment3;
import com.example.zy.myapplication.R;
import com.example.zy.myapplication.Utils.FragAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Tablayout2Activity extends AppCompatActivity {

    @BindView(R.id.vp_context2)
    ViewPager vpContext2;
    @BindView(R.id.home_container)
    FrameLayout homeContainer;
    @BindView(R.id.host_tab_layout)
    TabLayout hostTabLayout;

    private FragAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout2);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
//        设置FragmentList
        List<Fragment> fragmentList=new ArrayList<Fragment>();
        fragmentList.add(new BlankFragment());
        fragmentList.add(new BlankFragment2());
        fragmentList.add(new BlankFragment3());

//        设置适配器并装载
        adapter=new FragAdapter(getSupportFragmentManager(),fragmentList);
        vpContext2.setAdapter(adapter);

    }
}
