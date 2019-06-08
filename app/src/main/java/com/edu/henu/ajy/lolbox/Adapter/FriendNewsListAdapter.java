package com.edu.henu.ajy.lolbox.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.edu.henu.ajy.lolbox.Models.FriendNewsItem;
import com.edu.henu.ajy.lolbox.R;

import java.util.List;

public class FriendNewsListAdapter extends BaseAdapter {

    private List<?> list;
    private Context mContext;
    public FriendNewsListAdapter(Context mContext,List<?> list){
        this.mContext = mContext;
        this.list = list;
    }

    public Context getmContext() {
        return mContext;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FriendNewsItem item = (FriendNewsItem) list.get(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getmContext()).inflate(R.layout.friend_news_item,parent,false);
        }

        ImageView head = convertView.findViewById(R.id.user_head_pic);
        TextView username = convertView.findViewById(R.id.user_name_text);
        TextView message = convertView.findViewById(R.id.message);
        ImageView focusState = convertView.findViewById(R.id.focusState);

        head.setImageResource(item.getHeadImageId());
        username.setText(item.getUsername());

        if(item.getMessage()==null){
            message.setVisibility(View.GONE);
        }else{
            message.setText(item.getMessage());
            focusState.setVisibility(View.GONE);
        }


        if(item.getFocusState()==0){
            focusState.setImageResource(R.drawable.follow_state_3);
        }else if(item.getFocusState() == 1){
            focusState.setImageResource(R.drawable.follow_state_0);
        }else if(item.getFocusState() == 2){
            focusState.setImageResource(R.drawable.follow_state_1);
        }else{
            focusState.setVisibility(View.GONE);
        }




        return convertView;
    }
}
