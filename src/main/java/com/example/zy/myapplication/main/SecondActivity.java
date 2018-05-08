package com.example.zy.myapplication.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.zy.myapplication.R;
import com.example.zy.myapplication.Utils.RecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    String TAG="test";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        RecyclerView rvPictures=(RecyclerView)findViewById(R.id.rv_pictures);
        Log.d(TAG, "onCreate: 1");
        List<Integer> datas=new ArrayList<>();
        datas.add(R.drawable.ic_back_2);
        datas.add(R.drawable.ic_back_1);
        datas.add(R.drawable.ic_back_3);
        datas.add(R.drawable.ic_back_4);
        datas.add(R.drawable.ic_back_5);
        Log.d(TAG, "onCreate: "+datas.toString());


        LinearLayoutManager linear = new LinearLayoutManager(this);
        linear.setOrientation(LinearLayoutManager.VERTICAL);
        rvPictures.setLayoutManager(linear);
        rvPictures.setAdapter(new RecycleViewAdapter(this,datas));
    }
}
