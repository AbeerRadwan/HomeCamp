package com.homathon.homecamp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.homathon.homecamp.Model.ScheduleData;
import com.homathon.homecamp.R;
import com.homathon.homecamp.adapter.ScheduleAdapter;

import androidx.fragment.app.Fragment;


public class ItemFourFragment extends Fragment {
    ScheduleData[] myListData;
    ScheduleAdapter reportAdapter;
    public static ItemFourFragment newInstance() {
        ItemFourFragment fragment = new ItemFourFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cardview_chat, container, false);




        return view;

    }





}
