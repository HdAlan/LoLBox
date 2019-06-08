package com.edu.henu.ajy.lolbox.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.henu.ajy.lolbox.Activity.MainActivity;
import com.edu.henu.ajy.lolbox.Activity.SettingActivity;
import com.edu.henu.ajy.lolbox.Adapter.MeViewPagerAdapter;
import com.edu.henu.ajy.lolbox.Models.User;
import com.edu.henu.ajy.lolbox.R;
import com.edu.henu.ajy.lolbox.Utils.HttpUtil;

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
    private ImageButton btn_set;
    private ImageView headImage;
    private TextView username,userFocus,userFocused,userId,userLevel,userFocusCount,userFanCount,thumbs;
    private User user;
    public MeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //获取用户名
        Intent intent = getActivity().getIntent();
        user = (User) intent.getSerializableExtra("user");
        String account = intent.getStringExtra("loginAccount");
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
        headImage = view.findViewById(R.id.head_pic);
        username = view.findViewById(R.id.card_username);
        userFocus = view.findViewById(R.id.userFocus);
        userFocused = view.findViewById(R.id.userFocused);
        userId=view.findViewById(R.id.user_ID);
        userLevel=view.findViewById(R.id.user_lv);
        userFocusCount = view.findViewById(R.id.FocusCount);
        userFanCount = view.findViewById(R.id.FocusedCount);
        thumbs = view.findViewById(R.id.GetPraiseCount);
        //为按钮设置监听
        btn_set.setOnClickListener(this);
        headImage.setOnClickListener(this);
        username.setOnClickListener(this);
        userFocus.setOnClickListener(this);
        userFocused.setOnClickListener(this);

        setUserInfo(account);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.app_bar_setting:
                SettingActivity.startThisActivity(getActivity(),user);
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

    public void setUserInfo(final String account){
        username.setText(user.getUname());
        userId.setText(user.getAccount());
        userLevel.setText("Lv."+user.getLevel());
        userFocusCount.setText(""+user.getFocus());
        userFanCount.setText(""+user.getFans());
        thumbs.setText(""+user.getThumbs());
        HttpUtil.setImg(getActivity(),headImage,MainActivity.PICTUREPATHPRE,user.getHeadImgPath());
    }
}
