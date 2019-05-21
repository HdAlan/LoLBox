package com.edu.henu.ajy.lolbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MeScoreListAdapter extends BaseAdapter {

    private List<MeScoreItem> scoreList;
    private Context mContext;

    public MeScoreListAdapter(Context context, List<MeScoreItem> objects) {
        this.scoreList = objects;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return scoreList.size();
    }

    @Override
    public Object getItem(int position) {
        return scoreList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public Context getContext(){
        return this.mContext;
    }

    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        MeScoreItem score = scoreList.get(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.myinfo_fightscore_item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.hero_pic);
            viewHolder.textView = view.findViewById(R.id.vic_los_lab);
            viewHolder.textView1 = view.findViewById(R.id.category);
            viewHolder.textView2 = view.findViewById(R.id.time);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.imageView.setImageResource(score.getHero_pic());
        viewHolder.textView.setText(score.getScore());
        viewHolder.textView1.setText(score.getCategory());
        viewHolder.textView2.setText(score.getTime());
        return view;
    }

    class ViewHolder{
        ImageView imageView;
        TextView textView;
        TextView textView1;
        TextView textView2;

    }

}
