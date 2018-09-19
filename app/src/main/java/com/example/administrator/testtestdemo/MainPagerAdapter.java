package com.example.administrator.testtestdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/5.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    List<BaseFragment> mBaseFragments = new ArrayList<>();

    public MainPagerAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        mBaseFragments.clear();
        mBaseFragments.addAll(fragments);
    }

    @Override
    public Fragment getItem(int position) {
        return mBaseFragments.get(position);
    }

    @Override
    public int getCount() {
        return mBaseFragments != null ? mBaseFragments.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mBaseFragments.get(position).getTitle();
    }
}
