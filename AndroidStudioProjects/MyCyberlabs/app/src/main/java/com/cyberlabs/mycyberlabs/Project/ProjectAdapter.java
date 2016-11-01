package com.cyberlabs.mycyberlabs.Project;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cyberlabs.mycyberlabs.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by HadianR on 27/10/2016.
 */

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ViewHolder> {

    private int listProjectLayout;
    private ArrayList<Project> projectArrayList;
    String [] assigned={
            "Hadian","Dede","Ivan"
    };
    String [] project={
            "Android","Web","Desktop"
    };
    String [] deadline={
            "2016-11-6","2016-11-18","2016-11-30"
    };

    public ProjectAdapter(int layoutId, ArrayList<Project> projectArrayList){
        listProjectLayout = layoutId;
        this.projectArrayList = projectArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listProjectLayout, parent,false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.project.setText(project[position]);
        holder.deadline.setText(deadline[position]);
        holder.assigned.setText(assigned[position]);

        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());
        System.out.println("Current Position => " + position);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateNow = df.format(c.getTime());

        String dateline = deadline[position];

        Date d1 = null;
        Date d2 = null;



        try{
            d1 = df.parse(dateNow);
            d2 = df.parse(dateline);

            System.out.println("Time 2 : " + d2.getTime());
            System.out.println("Time 1 : " + d1.getTime());

            long selisih = d2.getTime()-d1.getTime();
            long left = selisih / (24 * 60 * 60 * 1000);

            System.out.println("Selisih " + selisih);

            String sesa = String.valueOf(left);


            if (left < 0 ){
                holder.progress.setBackgroundColor(Color.parseColor("#222"));
            } else if(left <= 7){
                holder.progress.setBackgroundColor(Color.parseColor("#D50000"));
            } else if (left <= 21){
                holder.progress.setBackgroundColor(Color.parseColor("#FFFF00"));
            } else {
                holder.progress.setBackgroundColor(Color.parseColor("#64DD17"));
            }
//
//            holder.progress.setText("Left : "+sesa);
        } catch (Exception e){

        }



    }



    @Override
    public int getItemCount() {
        return assigned.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView project,deadline,assigned,progress;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            project = (TextView) itemView.findViewById(R.id.rowProject);
            deadline = (TextView) itemView.findViewById(R.id.rowDeadline);
            assigned = (TextView) itemView.findViewById(R.id.rowAssigned);
            progress = (TextView) itemView.findViewById(R.id.rowProgress);

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Posisi : "+getLayoutPosition(), Toast.LENGTH_SHORT).show();
        }
    }
}
