package com.homathon.homecamp;

import android.os.Bundle;
import android.widget.Toast;

import com.darwindeveloper.horizontalscrollmenulibrary.custom_views.HorizontalScrollMenuView;
import com.darwindeveloper.horizontalscrollmenulibrary.extras.MenuItem;
import com.homathon.homecamp.Model.ScheduleData;
import com.homathon.homecamp.adapter.ScheduleAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

public class SechduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sechdule);

        HorizontalScrollMenuView horizontal_menu = (HorizontalScrollMenuView) findViewById(R.id.horizontal_menu);
        //viewPager = (ViewPager) findViewById(R.id.pager);


        //agregamos los items al menu
        horizontal_menu.addItem("Home", R.drawable.empty, true);//este elemento se marcara como seleccionado
        horizontal_menu.addItem("Account", R.drawable.empty);
        horizontal_menu.addItem("Message", R.drawable.empty);
        horizontal_menu.addItem("Downloads", R.drawable.empty);
        horizontal_menu.addItem("Calendar", R.drawable.empty);
        horizontal_menu.addItem("Events", R.drawable.empty,2);

        horizontal_menu.showItems();//hacemos visible los items del menu

        //implementamos la interface para caputar los clic en el menu
        horizontal_menu.setOnHSMenuClickListener(new HorizontalScrollMenuView.OnHSMenuClickListener() {
            @Override
            public void onHSMClick(MenuItem menuItem, int position) {
                Toast.makeText(SechduleActivity.this, "item " + position, Toast.LENGTH_SHORT).show();
            }
        });


        ScheduleData[] myListData = new ScheduleData[] {
                new ScheduleData("9 - 11", "Drawing",2),
                new ScheduleData("12 - 14", "Quraan",1),
                new ScheduleData("15 - 16", "Crafting",0)
        };

        RecyclerView recyclerView = findViewById(R.id.ScheduleRecycleView);
        ScheduleAdapter reportAdapter = new ScheduleAdapter(myListData,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(reportAdapter);
    }
}

