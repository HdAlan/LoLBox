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

    private List<FriendNewsItem> list;
    private Context mContext;
    public FriendNewsListAdapter(Context mContext,List<FriendNewsItem> list){
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
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FriendNewsItem item = (FriendNewsItem)getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getmContext()).inflate(R.layout.friend_news_item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.head = view.findViewById(R.id.user_head_pic);
            viewHolder.username = view.findViewById(R.id.user_name_text);
            viewHolder.message = view.findViewById(R.id.message);
            viewHolder.focusState = view.findViewById(R.id.focusState);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.head.setImageResource(item.getHeadImageId());
        viewHolder.username.setText(item.getUsername());

        if(item.getMessage()==null){
            viewHolder.message.setVisibility(View.GONE);
        }else{
            viewHolder.message.setText(item.getMessage());
            viewHolder.focusState.setVisibility(View.GONE);
        }


        if(item.getFocusState()==0){
            viewHolder.focusState.setImageResource(R.drawable.follow_state_3);
        }else if(item.getFocusState() == 1){
            viewHolder.focusState.setImageResource(R.drawable.follow_state_0);
        }else if(item.getFocusState() == 2){
            viewHolder.focusState.setImageResource(R.drawable.follow_state_1);
        }else{
            viewHolder.focusState.setVisibility(View.GONE);
        }




        return view;
    }
    class ViewHolder{
        ImageView head;
        TextView username;
        TextView message;
        ImageView focusState;
    }
}
