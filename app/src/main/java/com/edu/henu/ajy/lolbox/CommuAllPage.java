package com.edu.henu.ajy.lolbox;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommuAllPage extends Fragment {

    private List<CommunicateItem> commuAllItems = new ArrayList<>();

    public CommuAllPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.communicate_all_page,container,false);

        IniList();
        CommuListAdapter adapter = new CommuListAdapter(this.getContext(),commuAllItems);
        ListView listView = view.findViewById(R.id.commu_list_all);
        //adapter = new CommuListAdapter(this.getContext(),commuAllItems);
        listView.setAdapter(adapter);
        return view;
    }

    private void IniList(){
        commuAllItems.add(new CommunicateItem(R.drawable.akali_square_0,"困困","Lv.3",R.color.colorAccent,"死亡率太高也要被检测吗？",
                "TMD，现在的拳头这么恶心吗，之前自己的号被盗了，我申诉了好几遍都不行也就不说了，现在买了两个号一个满级通行证红信的号，一个小号，本来。。。",
                R.drawable.pubg_info_person,"综合频道","5","12","2"));
        commuAllItems.add(new CommunicateItem(R.drawable.anivia_square_0,"HuYa_阿涛","Lv.5",R.color.colorOrange,"【趣英语】give one's ears",
                "补全标题【趣英语】\"give one's ears\"不是\"给某人的耳朵\"了解give one's ears的含义【例句】He would give his ears to her.【误解】他愿把双耳给她。【正确】为了。。。。",
                R.drawable.bbs_good_circle,"综合频道","10","123","23"));
        commuAllItems.add(new CommunicateItem(R.drawable.brand_square_0,"杜家花生","Lv.1",R.color.colorGreen,"吃完这个鸡蛋，我就要去唱山歌了",
                "今年我们村有我在，绝对会赢的",
                R.drawable.bind_pubg_card_bg_x,"综合频道","13","4","12"));
        commuAllItems.add(new CommunicateItem(R.drawable.corki_square_0,"真不叫LOL客服","Lv.3",R.color.colorPink,"走过路过不要错过",
                "各位撸友门，让我上到10000赞吧，我也算是满足了，不水贴了，事成送个小key吧",
                R.drawable.game_data_card_role_pubg,"综合频道","25","16","100"));
    }

    @Override
    public void onStop() {
        super.onStop();
        //adapter = null;
        commuAllItems.clear();
    }
}
