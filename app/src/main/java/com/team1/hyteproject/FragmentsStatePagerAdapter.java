package com.team1.hyteproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentsStatePagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentNameList = new ArrayList<>();

    public FragmentsStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    private void addFragment (Fragment fragment, String name){
        mFragmentList.add(fragment);
        mFragmentNameList.add(name);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
