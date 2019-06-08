package com.edu.henu.ajy.lolbox.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.henu.ajy.lolbox.Models.CommunicateItem;
import com.edu.henu.ajy.lolbox.Utils.HttpUtil;
import com.edu.henu.ajy.lolbox.Activity.MainActivity;
import com.edu.henu.ajy.lolbox.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CommuListAdapter extends BaseAdapter {
    private Context mContext;
    private List<CommunicateItem> list;
    private Activity activity;
    private boolean isMaxLine;
    public CommuListAdapter(Activity activity,List<CommunicateItem> list,boolean isMaxLine){
        this.activity = activity;
        this.list = list;
        this.isMaxLine = isMaxLine;
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
            view = LayoutInflater.from(activity).inflate(R.layout.commu_all_page_item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.headImage = view.findViewById(R.id.head_pic);
            viewHolder.usernameText = view.findViewById(R.id.uname);
            viewHolder.levelText = view.findViewById(R.id.ulevel);
            viewHolder.titleText = view.findViewById(R.id.content);
            viewHolder.summaryText = view.findViewById(R.id.summary);
            viewHolder.articalImage = view.findViewById(R.id.image);
            viewHolder.articalCateText = view.findViewById(R.id.cate);
            viewHolder.articalTimeText = view.findViewById(R.id.time);
            viewHolder.articalCommentCountText = view.findViewById(R.id.commentCounts);
            viewHolder.articalLikeCountText = view.findViewById(R.id.thumbupCounts);
            if (isMaxLine){
                viewHolder.summaryText.setMaxLines(2);
            }
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        String headImgPath = commuAllItem.getHead_icoPath();
        setImg(viewHolder.headImage,headImgPath);
        viewHolder.usernameText.setText(commuAllItem.getUserName());
        viewHolder.levelText.setText("lv."+commuAllItem.getLevel());
        int level = commuAllItem.getLevel();
        viewHolder.levelText.setBackgroundResource(setLevelLabBg(level));
        viewHolder.titleText.setText(commuAllItem.getTitle());
        viewHolder.summaryText.setText(commuAllItem.getSummary());
        String articalImgPath = commuAllItem.getArticalImgPath();
        setImg(viewHolder.articalImage,articalImgPath);
        viewHolder.articalCateText.setText(commuAllItem.getArticalCate());
        viewHolder.articalTimeText.setText(commuAllItem.getArticalTime());
        viewHolder.articalCommentCountText.setText(commuAllItem.getArticalCommCounts()+"");
        viewHolder.articalLikeCountText.setText(commuAllItem.getArticalLikeCounts()+"");

        return view;
    }

    public int setLevelLabBg(int level){
        if (level==1){
            return R.color.colorGreen;
        }else if(level==2){
            return R.color.colorLightBlue;
        }else if(level==3){
            return R.color.colorIndigo;
        }else if(level==4){
            return R.color.colorPink;
        }else if(level==5){
            return R.color.colorRed;
        }else if(level==6){
            return R.color.colorOrange;
        }else if(level==7){
            return R.color.colorGray;
        }else if(level==8){
            return R.color.colorBlack;
        }else if(level==9){
            return R.color.colorAccent;
        }else if(level==10){
            return R.color.colorPrimary;
        }
        return R.color.colorPrimaryDark;
    }


    public void setImg(final ImageView view, String imgPath){
        HttpUtil.getJsonArray(MainActivity.PICTUREPATHPRE + imgPath, "", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(activity,"网络错误",Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream in = response.body().byteStream();
                final Bitmap bitmap = BitmapFactory.decodeStream(in);
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        view.setImageBitmap(bitmap);
                    }
                });
            }
        });
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
