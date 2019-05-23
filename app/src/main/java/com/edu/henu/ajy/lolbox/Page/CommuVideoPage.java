package com.edu.henu.ajy.lolbox.Page;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edu.henu.ajy.lolbox.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommuVideoPage extends Fragment {


    public CommuVideoPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.communicate_video_page,container,false);
        return view;
    }

}
