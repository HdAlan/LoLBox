package com.edu.henu.ajy.lolbox.Fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edu.henu.ajy.lolbox.Adapter.CommuViewPagerAdapter;
import com.edu.henu.ajy.lolbox.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommunicateFragment extends Fragment {

    private View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> titles = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.communicate_frag,container,false);
        viewPager = view.findViewById(R.id.viewpager_commu);
        tabLayout = view.findViewById(R.id.topNavi);

        titles.add("全部");
        titles.add("视频");
        titles.add("精华");
        CommuViewPagerAdapter adapter = new CommuViewPagerAdapter(getChildFragmentManager(),titles);
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        return view;
    }
}
