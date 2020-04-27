package com.homathon.homecamp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.homathon.homecamp.Model.ScheduleData;
import com.homathon.homecamp.R;
import com.homathon.homecamp.WatchActivity;
import com.homathon.homecamp.fragment.RealTimeVideoFragment;

import androidx.recyclerview.widget.RecyclerView;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder>{
    private ScheduleData[] listdata;
    private Context context;

    // RecyclerView recyclerView;
    public ScheduleAdapter(ScheduleData[] listdata , Context context) {
        this.listdata = listdata;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.cardview_schedule, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ScheduleData myListData = listdata[position];
        holder.textView.setText(listdata[position].getTime());
        holder.name.setText(listdata[position].getName());

        if(listdata[position].getStatus()==0){
            holder.button.setText("Join");
            holder.button.setBackground(context.getResources().getDrawable(R.drawable.unjoinbutton));
        }else if(listdata[position].getStatus()==1){
            holder.button.setText("Join");
            holder.button.setBackground(context.getResources().getDrawable(R.drawable.joinbuttonbg));
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(context, RealTimeVideoFragment.class);
                    context.startActivity(myIntent);
                }
            });
        }
        else{
            holder.button.setText("Watch");
            holder.button.setBackground(context.getResources().getDrawable(R.drawable.watchbuttonbg));
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(context, WatchActivity.class);
                    context.startActivity(myIntent);
                }
            });
        }

    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public TextView name;
        public Button button;

        public ViewHolder(View itemView) {
            super(itemView);

            this.textView = (TextView) itemView.findViewById(R.id.time);
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.button = (Button) itemView.findViewById(R.id.watchButton);

        }
    }
}