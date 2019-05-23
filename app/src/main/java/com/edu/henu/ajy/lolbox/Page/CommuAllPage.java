package com.edu.henu.ajy.lolbox.Page;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.edu.henu.ajy.lolbox.Adapter.CommuListAdapter;
import com.edu.henu.ajy.lolbox.Models.CommunicateItem;
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
public class CommuAllPage extends Fragment {

    private List<CommunicateItem> commuAllItems = new ArrayList<>();
    private CommuListAdapter adapter;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.communicate_all_page,container,false);
        listView = view.findViewById(R.id.commu_list_all);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CommunicateItem item = commuAllItems.get(position);
                ShowContentActivity.startThisActivity(getActivity(),item.getTitle(),item.getUserName(),item.getSummary(),item.getArticalImgPath());
            }
        });
        getData();
        return view;
    }

    private void getData(){
        HttpUtil.getJsonArray(MainActivity.GETCOMMUNITYLIST, "1", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(),"网络错误",Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jsonData = response.body().string();
                Gson gson = new Gson();
                commuAllItems = gson.fromJson(jsonData,new TypeToken<List<CommunicateItem>>(){}.getType());
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter = new CommuListAdapter(getActivity(),commuAllItems);
                        listView.setAdapter(adapter);
                    }
                });
            }
        });
    }
}
