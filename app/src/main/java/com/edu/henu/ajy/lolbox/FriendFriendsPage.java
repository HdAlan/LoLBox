package com.edu.henu.ajy.lolbox;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.transition.Transition;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendFriendsPage extends Fragment {

    private BottomNavigationView bottomNavigationView;

    public FriendFriendsPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.friend_friends_page,container,false);

        bottomNavigationView = view.findViewById(R.id.topNaviFriends);
        FrameLayout frameLayout = view.findViewById(R.id.friendsFrame);

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.friendsFrame,new FriendFriendsMyFriendsPage()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transition = getActivity().getSupportFragmentManager().beginTransaction();
                switch (menuItem.getItemId()){
                    case R.id.my_friends:
                        transition.replace(R.id.friendsFrame,new FriendFriendsMyFriendsPage()).commit();
                        break;
                    case R.id.my_focus:
                        transition.replace(R.id.friendsFrame,new FriendFriendsFocusPage()).commit();
                        break;
                    case R.id.my_fans:
                        transition.replace(R.id.friendsFrame,new FriendFriendsFansPage()).commit();
                        break;
                }
                return true;
            }
        });
        return view;
    }

}
