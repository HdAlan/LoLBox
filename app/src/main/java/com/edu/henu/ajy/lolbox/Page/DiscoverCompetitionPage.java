package com.edu.henu.ajy.lolbox.Page;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.edu.henu.ajy.lolbox.Adapter.DiscoverListAdapter;
import com.edu.henu.ajy.lolbox.Models.DiscoverListItem;
import com.edu.henu.ajy.lolbox.Utils.HttpUtil;
import com.edu.henu.ajy.lolbox.Activity.MainActivity;
import com.edu.henu.ajy.lolbox.R;
import com.edu.henu.ajy.lolbox.Activity.ShowContentActivity;
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
public class DiscoverCompetitionPage extends Fragment {
    private static String DEFCODE = "0";
    private List<DiscoverListItem> list = new ArrayList<>();
    DiscoverListAdapter adapter;
    ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.discover_competition_page,container,false);
        listView = view.findViewById(R.id.competitionList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DiscoverListItem item = list.get(position);
                ShowContentActivity.startThisActivity(getActivity(),item.getTitle(),item.getAuthor(),item.getContent(),item.getPicturePath());
            }
        });
        IniList();
        return view;
    }


    private void IniList(){
        HttpUtil.getJsonArray(MainActivity.GETDISCOVERLIST,DEFCODE, new Callback() {
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
                list = gson.fromJson(jsonData,new TypeToken<List<DiscoverListItem>>(){}.getType());
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

}
