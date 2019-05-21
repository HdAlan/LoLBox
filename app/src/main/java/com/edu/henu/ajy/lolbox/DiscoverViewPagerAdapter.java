package com.edu.henu.ajy.lolbox;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class DiscoverViewPagerAdapter extends FragmentPagerAdapter {

    private String[] titles = {"推荐","赛事"};

    public DiscoverViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if(i==0){
            return new DiscoverRecommendPage();
        }else{
            return new DiscoverCompetitionPage();
        }
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
