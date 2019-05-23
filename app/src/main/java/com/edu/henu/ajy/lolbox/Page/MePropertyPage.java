package com.edu.henu.ajy.lolbox.Page;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edu.henu.ajy.lolbox.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MePropertyPage extends Fragment {

    private View view;

    public MePropertyPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.myinfo_property_page,container,false);
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        view = null;
    }
}
