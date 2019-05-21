package com.edu.henu.ajy.lolbox;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class CommuViewPagerAdapter extends FragmentPagerAdapter {

    private List<String> titles;
    private final int PAGE_COUNT = 3;
    public CommuViewPagerAdapter(FragmentManager fm, List<String> titles) {
        super(fm);
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int i) {
        if (i==0){
            return new CommuAllPage();
        }else if(i==1){
            return new CommuVideoPage();
        }else{
            return new CommuEssensePage();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
