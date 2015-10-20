package com.vara.learningapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Vara.Pakalapati on 16/10/2015.
 */
public class RiverFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int position = getArguments().getInt("position");
        String[] menuItems = getResources().getStringArray(R.array.navigation_items);
        View v = inflater.inflate(R.layout.fragment_layout, container, false);
        TextView tv = (TextView) v.findViewById(R.id.tv_content);
        tv.setText(menuItems[position]);
        getActivity().getActionBar().setTitle(menuItems[position]);
        return v;
    }
}
