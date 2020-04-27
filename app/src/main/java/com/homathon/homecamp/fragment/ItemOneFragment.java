package com.homathon.homecamp.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.darwindeveloper.horizontalscrollmenulibrary.custom_views.HorizontalScrollMenuView;
import com.darwindeveloper.horizontalscrollmenulibrary.extras.MenuItem;
import com.homathon.homecamp.Model.ScheduleData;
import com.homathon.homecamp.R;
import com.homathon.homecamp.SechduleActivity;
import com.homathon.homecamp.adapter.ScheduleAdapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class ItemOneFragment extends Fragment {
    ScheduleData[] myListData;
    ScheduleAdapter reportAdapter;
    public static ItemOneFragment newInstance() {
        ItemOneFragment fragment = new ItemOneFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_sechdule, container, false);
        HorizontalScrollMenuView horizontal_menu = (HorizontalScrollMenuView) view.findViewById(R.id.horizontal_menu);
        //viewPager = (ViewPager) findViewById(R.id.pager);

         myListData = new ScheduleData[] {
                        new ScheduleData("12 - 13 ", "Drawing",2),
                        new ScheduleData("15 - 16", "Quraan",1),
                        new ScheduleData("17 - 18", "Crafting",0)
        };
        //agregamos los items al menu
        horizontal_menu.addItem("Today", R.drawable.empty, true);//este elemento se marcara como seleccionado
        horizontal_menu.addItem("Monday", R.drawable.empty);
        horizontal_menu.addItem("TuesDay", R.drawable.empty);
        horizontal_menu.addItem("Wednesday", R.drawable.empty);
        horizontal_menu.addItem("Thursday", R.drawable.empty);
        horizontal_menu.addItem("Sunday", R.drawable.empty);

        horizontal_menu.showItems();//hacemos visible los items del menu


        RecyclerView recyclerView = view.findViewById(R.id.ScheduleRecycleView);
        reportAdapter = new ScheduleAdapter(myListData,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(reportAdapter);


        //implementamos la interface para caputar los clic en el menu
        horizontal_menu.setOnHSMenuClickListener(new HorizontalScrollMenuView.OnHSMenuClickListener() {
            @Override
            public void onHSMClick(MenuItem menuItem, int position) {
                Toast.makeText(getContext(), "item " + position, Toast.LENGTH_SHORT).show();
                if(position == 1){
                    myListData = new ScheduleData[] {
                            new ScheduleData("9 - 11 ", "Drawing",2),
                    };

                    reportAdapter.notifyDataSetChanged();
                }
            }
        });









        return view;

    }





}
