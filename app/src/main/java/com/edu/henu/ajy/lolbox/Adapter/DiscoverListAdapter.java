package com.edu.henu.ajy.lolbox.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.edu.henu.ajy.lolbox.Models.DiscoverListItem;
import com.edu.henu.ajy.lolbox.Utils.HttpUtil;
import com.edu.henu.ajy.lolbox.R;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DiscoverListAdapter extends BaseAdapter {
    private List<DiscoverListItem> itemList;
    private Context mContext;
    private Activity activity;

    public DiscoverListAdapter(List<DiscoverListItem> itemList, Activity activity){
        this.itemList = itemList;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DiscoverListItem item = (DiscoverListItem) getItem(position);
        ViewHolder viewHolder;
        View view;
        if (convertView==null){
            view = LayoutInflater.from(activity).inflate(R.layout.discover_page_list_item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.title = view.findViewById(R.id.recommendTitle);
            viewHolder.author = view.findViewById(R.id.recommendAuthor);
            viewHolder.iamge = view.findViewById(R.id.recommendImage);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.title.setText(item.getTitle());
        viewHolder.author.setText(item.getAuthor());
        setImage(item.getPicturePath(),viewHolder);
        return view;
    }

    public void setImage(String path, final ViewHolder holder){
        HttpUtil.getJsonArray("http://henuajy.zicp.vip/LolboxImages/"+path,"", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        holder.iamge.setImageResource(R.mipmap.ic_launcher);
                    }
                });
                Log.d("ShowPic","访问服务器失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream inputStream = response.body().byteStream();
                final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        holder.iamge.setImageBitmap(bitmap);
                    }
                });
                Log.d("ShowPic","访问服务器成功");
            }
        });
    }

    class ViewHolder{
        TextView title;
        TextView author;
        ImageView iamge;
    }
}
