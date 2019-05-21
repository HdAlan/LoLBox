package com.edu.henu.ajy.lolbox;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment implements View.OnClickListener {


    private View view;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<String> TitleList = new ArrayList<>();
    private ImageButton btn_set,btn_headpic;
    private TextView username,userFocus,userFocused;
    public MeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //将mepage转换为一个视图
        view = LayoutInflater.from(getContext()).inflate(R.layout.myinfo_me_frag,container,false);
        //添加顶部导航标题
        TitleList.add("战绩");
        TitleList.add("资产");
        //获取viewPager实例
        viewPager = view.findViewById(R.id.viewpager_grad);
        //获取viewPager的适配器实例
        MeViewPagerAdapter mPageAdapter = new MeViewPagerAdapter(getChildFragmentManager(),TitleList);
        viewPager.setAdapter(mPageAdapter);
        //获取顶部导航视图的实例并与viewpager建立联系
        tabLayout = view.findViewById(R.id.topNavi);
        tabLayout.setupWithViewPager(viewPager);
        //获取按钮的实例
        btn_set = view.findViewById(R.id.app_bar_setting);
        btn_headpic = view.findViewById(R.id.head_pic);
        username = view.findViewById(R.id.card_username);
        userFocus = view.findViewById(R.id.userFocus);
        userFocused = view.findViewById(R.id.userFocused);
        //为按钮设置监听
        btn_set.setOnClickListener(this);
        btn_headpic.setOnClickListener(this);
        username.setOnClickListener(this);
        userFocus.setOnClickListener(this);
        userFocused.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.app_bar_setting:
                SettingActivity.startThisActivity(getActivity());
                break;
            case R.id.head_pic:
                Toast.makeText(getContext(),"headpic",Toast.LENGTH_SHORT).show();
                break;
            case R.id.card_username:
                Toast.makeText(getContext(),"username",Toast.LENGTH_SHORT).show();
                break;
            case R.id.userFocus:
                Toast.makeText(getContext(),"userFocus",Toast.LENGTH_SHORT).show();
                break;
            case R.id.userFocused:
                Toast.makeText(getContext(),"userFocused",Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
