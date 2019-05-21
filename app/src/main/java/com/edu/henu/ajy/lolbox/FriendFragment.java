package com.edu.henu.ajy.lolbox;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendFragment extends Fragment {


    private View view;

    public FriendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.friend_frag,container,false);

        TabLayout tabLayout = view.findViewById(R.id.friend_tablay);

        ViewPager viewPager = view.findViewById(R.id.friend_viewpager);
        FriendViewPagerAdapter adapter = new FriendViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}
