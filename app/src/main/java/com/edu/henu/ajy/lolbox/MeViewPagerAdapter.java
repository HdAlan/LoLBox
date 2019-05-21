package com.edu.henu.ajy.lolbox;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MeViewPagerAdapter extends FragmentPagerAdapter {
    private List<String> Titles;
    private int PAGE_COUNT = 2;

    public MeViewPagerAdapter(FragmentManager fm, List<String> titles) {
        super(fm);
        this.Titles = titles;
    }

    @Override
    public Fragment getItem(int i) {
        if(i == 0){
            return new MeFightScorePage();
        }else{
            return new MePropertyPage();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return Titles.get(position);
    }
}
