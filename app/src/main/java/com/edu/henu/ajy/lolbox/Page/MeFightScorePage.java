package com.edu.henu.ajy.lolbox.Page;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.edu.henu.ajy.lolbox.Activity.MainActivity;
import com.edu.henu.ajy.lolbox.Models.MeScoreItem;
import com.edu.henu.ajy.lolbox.Adapter.MeScoreListAdapter;
import com.edu.henu.ajy.lolbox.R;
import com.edu.henu.ajy.lolbox.Utils.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFightScorePage extends Fragment {

    private View view;
    private ListView scorelist;
    private List<MeScoreItem> scores = new ArrayList<>();
    private MeScoreListAdapter listAdapter;
    public MeFightScorePage() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = LayoutInflater.from(getContext()).inflate(R.layout.myinfo_fight_score_page,container,false);
        scorelist = view.findViewById(R.id.scorelist);

        Intent intent = getActivity().getIntent();
        String account = intent.getStringExtra("loginAccount");


        HttpUtil.setScoreList(this, MainActivity.GETSCORELIST,account);
        return view;
    }

    public void initList(String jsonData){
        Gson gson = new Gson();
        scores = gson.fromJson(jsonData,new TypeToken<List<MeScoreItem>>(){}.getType());
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                listAdapter = new MeScoreListAdapter(getActivity(),getContext(),scores);
                scorelist.setAdapter(listAdapter);
            }
        });

    }

    @Override
    public void onStop() {
        super.onStop();
        view = null;
    }

}
