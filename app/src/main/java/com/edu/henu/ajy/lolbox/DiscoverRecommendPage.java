package com.edu.henu.ajy.lolbox;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverRecommendPage extends Fragment {
    private static String DEFCODE = "1";
    private List<DiscoverRecommendItem> list = new ArrayList<>();
    DiscoverListAdapter adapter;
    ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.discover_recommend_page,container,false);
        listView = view.findViewById(R.id.recommendList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DiscoverRecommendItem discoverRecommendItem = list.get(position);
                ShowContentActivity.startThisActivity(getActivity(),
                        discoverRecommendItem.getTitle(),
                        discoverRecommendItem.getAuthor(),
                        discoverRecommendItem.getContent(),
                        discoverRecommendItem.getPicturePath());
            }
        });
        IniList();
        return view;
    }


    private void IniList(){
        String address = "http://henuajy.zicp.vip/LoLBoxServer_war_exploded/GetDiscoverRecommentListServlet";
        HttuUtil.getJsonArray(address,DEFCODE, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(),"连接服务器失败",Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jsonData = response.body().string();
                Gson gson = new Gson();
                list = gson.fromJson(jsonData,new TypeToken<List<DiscoverRecommendItem>>(){}.getType());
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter = new DiscoverListAdapter(list,getActivity());
                        listView.setAdapter(adapter);
                        Log.d("DiscoverRecommendPage","请求成功");
                    }
                });
            }
        });
    }

//    @Override
//    public void onStop() {
//        super.onStop();
//        list.clear();
//    }
}