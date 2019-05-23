package com.edu.henu.ajy.lolbox.Fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edu.henu.ajy.lolbox.Adapter.DiscoverViewPagerAdapter;
import com.edu.henu.ajy.lolbox.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverFragment extends Fragment {


    private View view;

    public DiscoverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.discover_frag,container,false);

        ViewPager viewPager = view.findViewById(R.id.discover_viewPager);

        DiscoverViewPagerAdapter adapter = new DiscoverViewPagerAdapter(getChildFragmentManager());

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = view.findViewById(R.id.discover_top_Navi);
        tabLayout.setupWithViewPager(viewPager);



        return view;
    }
}
