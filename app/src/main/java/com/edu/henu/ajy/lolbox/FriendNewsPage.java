package com.edu.henu.ajy.lolbox;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendNewsPage extends Fragment {

    List<FriendNewsItem> newsItems = new ArrayList<>();

    public FriendNewsPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.friend_news_page,container,false);

        IniList();
        ListView listView = view.findViewById(R.id.newslist);
        FriendNewsListAdapter adapter = new FriendNewsListAdapter(this.getContext(),newsItems);
        listView.setAdapter(adapter);
        return view;
    }

    private void IniList(){
        newsItems.add(new FriendNewsItem(R.drawable.tristana_square_0,"催丝塔娜","吃饭了吗?"));
        newsItems.add(new FriendNewsItem(R.drawable.vayne_square_0,"薇恩","在吗?"));
        newsItems.add(new FriendNewsItem(R.drawable.teemo_square_0,"提莫","周末一起出去玩吧!"));
        newsItems.add(new FriendNewsItem(R.drawable.urgot_square_0,"厄加特","来,一起打游戏!"));
    }

}
