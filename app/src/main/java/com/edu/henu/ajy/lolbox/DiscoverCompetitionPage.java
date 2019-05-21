package com.edu.henu.ajy.lolbox;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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
    private List<DiscoverRecommendItem> list = new ArrayList<>();
    DiscoverListAdapter adapter;
    ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.discover_competition_page,container,false);
        listView = view.findViewById(R.id.competitionList);
        IniList();
        return view;
    }


    private void IniList(){
        String address = "http://henuajy.zicp.vip/LoLBoxServer_war_exploded/GetDiscoverRecommentListServlet";
        HttuUtil.getJsonArray(address,DEFCODE, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

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

}
