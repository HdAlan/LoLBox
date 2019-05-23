package com.edu.henu.ajy.lolbox.Page;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.edu.henu.ajy.lolbox.Models.MeScoreItem;
import com.edu.henu.ajy.lolbox.Adapter.MeScoreListAdapter;
import com.edu.henu.ajy.lolbox.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFightScorePage extends Fragment {

    private View view;
    private ListView scorelist;
    private List<MeScoreItem> scores = new ArrayList<>();

    public MeFightScorePage() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = LayoutInflater.from(getContext()).inflate(R.layout.myinfo_fight_score_page,container,false);
        scorelist = view.findViewById(R.id.scorelist);

        scores.add(new MeScoreItem(R.drawable.akali_square_0,"胜利 4/2/2","经典匹配","03-23 20:02"));
        scores.add(new MeScoreItem(R.drawable.annie_square_0,"胜利 4/2/2","经典匹配","03-23 20:02"));
        scores.add(new MeScoreItem(R.drawable.ezreal_square_0,"胜利 4/2/2","经典匹配","03-23 20:02"));
        scores.add(new MeScoreItem(R.drawable.fiddlesticks_square_0,"胜利 4/2/2","经典匹配","03-23 20:02"));
        scores.add(new MeScoreItem(R.drawable.fizz_square_0,"胜利 4/2/2","经典匹配","03-23 20:02"));
        scores.add(new MeScoreItem(R.drawable.fiora_square_0,"胜利 4/2/2","经典匹配","03-23 20:02"));
        scores.add(new MeScoreItem(R.drawable.irelia_square_0,"胜利 4/2/2","经典匹配","03-23 20:02"));
        scores.add(new MeScoreItem(R.drawable.akali_square_0,"胜利 4/2/2","经典匹配","03-23 20:02"));
        scores.add(new MeScoreItem(R.drawable.karma_square_0,"胜利 4/2/2","经典匹配","03-23 20:02"));
        scores.add(new MeScoreItem(R.drawable.jax_square_0,"胜利 4/2/2","经典匹配","03-23 20:02"));

        MeScoreListAdapter listAdapter = new MeScoreListAdapter(this.getContext(),scores);
        scorelist.setAdapter(listAdapter);

        return view;
    }


    @Override
    public void onStop() {
        super.onStop();
        view = null;
    }

}
