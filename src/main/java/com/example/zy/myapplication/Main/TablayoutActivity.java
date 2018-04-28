package com.example.zy.myapplication.Main;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

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
