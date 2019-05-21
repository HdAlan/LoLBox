package com.edu.henu.ajy.lolbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CommuListAdapter extends BaseAdapter {
    private Context mContext;
    private List<CommunicateItem> list;
    public CommuListAdapter(Context mContext,List<CommunicateItem> list){
        this.mContext = mContext;
        this.list = list;
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CommunicateItem commuAllItem = (CommunicateItem)getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getmContext()).inflate(R.layout.commu_all_page_item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.headImage = view.findViewById(R.id.user_head_pic);
            viewHolder.usernameText = view.findViewById(R.id.user_name_text);
            viewHolder.levelText = view.findViewById(R.id.user_level);
            viewHolder.titleText = view.findViewById(R.id.artical_title);
            viewHolder.summaryText = view.findViewById(R.id.artical_summary);
            viewHolder.articalImage = view.findViewById(R.id.artical_img);
            viewHolder.articalCateText = view.findViewById(R.id.artical_cate);
            viewHolder.articalTimeText = view.findViewById(R.id.artical_time);
            viewHolder.articalCommentCountText = view.findViewById(R.id.comment_count);
            viewHolder.articalLikeCountText = view.findViewById(R.id.like_count);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.headImage.setImageResource(commuAllItem.getHead_ico());
        viewHolder.usernameText.setText(commuAllItem.getUserName());
        viewHolder.levelText.setText(commuAllItem.getLevel());
        viewHolder.levelText.setBackgroundResource(commuAllItem.getLevelBoardBg());
        viewHolder.titleText.setText(commuAllItem.getTitle());
        viewHolder.summaryText.setText(commuAllItem.getSummary());
        viewHolder.articalImage.setImageResource(commuAllItem.getArticalImg());
        viewHolder.articalCateText.setText(commuAllItem.getArticalCate());
        viewHolder.articalTimeText.setText(commuAllItem.getArticalTime());
        viewHolder.articalCommentCountText.setText(commuAllItem.getArticalCommCounts());
        viewHolder.articalLikeCountText.setText(commuAllItem.getArticalLikeCounts());

        return view;
    }

    public Context getmContext() {
        return mContext;
    }

    class ViewHolder{
        ImageView headImage;
        TextView usernameText;
        TextView levelText;
        TextView titleText;
        TextView summaryText;
        ImageView articalImage;
        TextView articalCateText;
        TextView articalTimeText;
        TextView articalCommentCountText;
        TextView articalLikeCountText;
    }
}
