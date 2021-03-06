package com.edu.henu.ajy.lolbox.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.edu.henu.ajy.lolbox.Activity.MainActivity;
import com.edu.henu.ajy.lolbox.Models.MeScoreItem;
import com.edu.henu.ajy.lolbox.R;
import com.edu.henu.ajy.lolbox.Utils.HttpUtil;

import java.util.List;

public class MeScoreListAdapter extends BaseAdapter {

    private List<MeScoreItem> scoreList;
    private Context mContext;
    private Activity activity;
    public MeScoreListAdapter(Activity activity,Context context, List<MeScoreItem> objects) {
        this.scoreList = objects;
        this.mContext = context;
        this.activity = activity;
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
        //viewHolder.imageView.setImageResource(score.getHeroPicPath());
        HttpUtil.setImg(activity,viewHolder.imageView, MainActivity.PICTUREPATHPRE,score.getHeroPicPath());
        viewHolder.textView.setText(score.getFightRes());
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
