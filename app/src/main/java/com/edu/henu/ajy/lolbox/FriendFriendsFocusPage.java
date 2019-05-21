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
public class FriendFriendsFocusPage extends Fragment {

    List<FriendNewsItem> newsItems = new ArrayList<>();

    public FriendFriendsFocusPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.friend_friends_focus_page,container,false);
        IniList();
        ListView listView = view.findViewById(R.id.focuslist);
        FriendNewsListAdapter adapter = new FriendNewsListAdapter(this.getContext(),newsItems);
        listView.setAdapter(adapter);
        return view;
    }
    private void IniList(){

        newsItems.add(new FriendNewsItem(R.drawable.leblanc_square_0,"乐芙兰",0));
        newsItems.add(new FriendNewsItem(R.drawable.monkeyking_square_0,"猴子",0));
        newsItems.add(new FriendNewsItem(R.drawable.varus_square_0,"维鲁斯",2));
        newsItems.add(new FriendNewsItem(R.drawable.veigar_square_0,"维迦",2));
        newsItems.add(new FriendNewsItem(R.drawable.leesin_square_0,"瞎神",2));
    }
}



