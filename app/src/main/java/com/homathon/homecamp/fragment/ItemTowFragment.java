package com.homathon.homecamp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.darwindeveloper.horizontalscrollmenulibrary.custom_views.HorizontalScrollMenuView;
import com.darwindeveloper.horizontalscrollmenulibrary.extras.MenuItem;
import com.homathon.homecamp.Model.ScheduleData;
import com.homathon.homecamp.R;
import com.homathon.homecamp.adapter.ScheduleAdapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class ItemTowFragment extends Fragment {
    ScheduleData[] myListData;
    ScheduleAdapter reportAdapter;
    public static ItemTowFragment newInstance() {
        ItemTowFragment fragment = new ItemTowFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);




        return view;

    }





}
