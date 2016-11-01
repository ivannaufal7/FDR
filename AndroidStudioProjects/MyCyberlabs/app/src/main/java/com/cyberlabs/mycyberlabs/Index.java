package com.cyberlabs.mycyberlabs;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cyberlabs.mycyberlabs.Attend.FragmentAttend;
import com.cyberlabs.mycyberlabs.Notif.FragmentNotif;
import com.cyberlabs.mycyberlabs.Project.FragmentProject;
import com.cyberlabs.mycyberlabs.Settings.FragmentSettings;

public class Index extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView imgProject,imgAttend,imgNotif,imgSettings;
    TextView tvProject,tvAttend,tvNotif,tvSettings, tvToolbar;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvToolbar = (TextView) findViewById(R.id.tvToolbar);

        tvProject = (TextView) findViewById(R.id.tvProject);
        tvAttend = (TextView) findViewById(R.id.tvAttend);
        tvNotif = (TextView) findViewById(R.id.tvNotif);
        tvSettings = (TextView) findViewById(R.id.tvSettings);

        FragmentProject fp = new FragmentProject();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frReplace,fp);
        fragmentTransaction.commit();


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new  FragmentProject();
                if (v == imgProject){
                    tvToolbar.setText("Project");

                    fragment = new FragmentProject();
                    String ini = "Ini project";
                    Log.i("kaluar :",ini);
                    imgProject.setImageResource(R.drawable.clipboardfocus);
                    tvProject.setTextColor(Color.parseColor("#ffffff"));

                    imgAttend.setImageResource(R.drawable.avatar);
                    tvAttend.setTextColor(Color.parseColor("#bbdefb"));

                    imgNotif.setImageResource(R.drawable.bell);
                    tvNotif.setTextColor(Color.parseColor("#bbdefb"));

                    imgSettings.setImageResource(R.drawable.settings);
                    tvSettings.setTextColor(Color.parseColor("#bbdefb"));
                } else if(v == imgAttend){
                    tvToolbar.setText("Attendance");

                    fragment = new FragmentAttend();
                    String ini = "Ini Attend";
                    Log.i("kaluar :",ini);
                    imgAttend.setImageResource(R.drawable.avafocus);
                    tvAttend.setTextColor(Color.parseColor("#ffffff"));

                    imgProject.setImageResource(R.drawable.clipboard);
                    tvProject.setTextColor(Color.parseColor("#bbdefb"));

                    imgNotif.setImageResource(R.drawable.bell);
                    tvNotif.setTextColor(Color.parseColor("#bbdefb"));

                    imgSettings.setImageResource(R.drawable.settings);
                    tvSettings.setTextColor(Color.parseColor("#bbdefb"));
                } else if(v == imgNotif){
                    tvToolbar.setText("Notification");

                    fragment = new FragmentNotif();
                    imgNotif.setImageResource(R.drawable.bellfocus);
                    tvNotif.setTextColor(Color.parseColor("#ffffff"));

                    imgProject.setImageResource(R.drawable.clipboard);
                    tvProject.setTextColor(Color.parseColor("#bbdefb"));

                    imgAttend.setImageResource(R.drawable.avatar);
                    tvAttend.setTextColor(Color.parseColor("#bbdefb"));

                    imgSettings.setImageResource(R.drawable.settings);
                    tvSettings.setTextColor(Color.parseColor("#bbdefb"));
                } else if(v == imgSettings){
                    tvToolbar.setText("Settings");
                    fragment = new FragmentSettings();
                    imgSettings.setImageResource(R.drawable.settingsfocus);
                    tvSettings.setTextColor(Color.parseColor("#ffffff"));

                    imgProject.setImageResource(R.drawable.clipboard);
                    tvProject.setTextColor(Color.parseColor("#bbdefb"));

                    imgAttend.setImageResource(R.drawable.avatar);
                    tvAttend.setTextColor(Color.parseColor("#bbdefb"));

                    imgNotif.setImageResource(R.drawable.bell);
                    tvNotif.setTextColor(Color.parseColor("#bbdefb"));
                }
                // Load Fragment
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frReplace,fragment);
                fragmentTransaction.commit();
            }
        };

        imgProject = (ImageView) findViewById(R.id.imgProject);
        imgProject.setOnClickListener(listener);
        imgAttend = (ImageView) findViewById(R.id.imgAttend);
        imgAttend.setOnClickListener(listener);

        imgNotif = (ImageView) findViewById(R.id.imgNotif);
        imgNotif.setOnClickListener(listener);
        imgSettings = (ImageView) findViewById(R.id.imgSettings);
        imgSettings.setOnClickListener(listener);



//        ArrayList<Project> projectArrayList = new ArrayList<Project>();
//        final LinearLayoutManager llm = new LinearLayoutManager(this);
//        ProjectAdapter projectAdapter = new ProjectAdapter(R.layout.list_project,projectArrayList);
//
//        recyclerView = (RecyclerView) findViewById(R.id.rvProject);
//        recyclerView.setLayoutManager(llm);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(projectAdapter);


    }


}
