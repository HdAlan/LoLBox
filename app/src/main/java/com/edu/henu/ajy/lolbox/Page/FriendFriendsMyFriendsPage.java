package com.edu.henu.ajy.lolbox.Page;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.edu.henu.ajy.lolbox.Models.FriendNewsItem;
import com.edu.henu.ajy.lolbox.Adapter.FriendNewsListAdapter;
import com.edu.henu.ajy.lolbox.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendFriendsMyFriendsPage extends Fragment {

    List<FriendNewsItem> newsItems = new ArrayList<>();

    public FriendFriendsMyFriendsPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.friend_friends_myfriends_page,container,false);

        IniList();
        ListView listView = view.findViewById(R.id.friendslist);
        FriendNewsListAdapter adapter = new FriendNewsListAdapter(this.getContext(),newsItems);
        listView.setAdapter(adapter);

        return view;
    }
    private void IniList(){
        newsItems.add(new FriendNewsItem(R.drawable.varus_square_0,"维鲁斯","在线"));
        newsItems.add(new FriendNewsItem(R.drawable.veigar_square_0,"维迦","在线"));
        newsItems.add(new FriendNewsItem(R.drawable.leesin_square_0,"瞎神","正在游戏"));
        newsItems.add(new FriendNewsItem(R.drawable.leblanc_square_0,"乐芙兰","离线"));
        newsItems.add(new FriendNewsItem(R.drawable.monkeyking_square_0,"猴子","离线"));
    }
}




