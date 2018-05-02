package com.example.zy.myapplication.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author wwq
 */
public class FragAdapter extends FragmentPagerAdapter{
    private List<Fragment> mfragments=null;

    public FragAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        mfragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mfragments.get(position);
    }

    @Override
    public int getCount() {
        return mfragments.size();
    }
}
