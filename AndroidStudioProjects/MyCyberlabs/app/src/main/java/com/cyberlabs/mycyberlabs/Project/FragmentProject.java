package com.cyberlabs.mycyberlabs.Project;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cyberlabs.mycyberlabs.R;

import java.util.ArrayList;

/**
 * Created by HadianR on 28/10/2016.
 */

public class FragmentProject extends Fragment {
    RecyclerView recyclerView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_project, container, false);


        ArrayList<Project> projectArrayList = new ArrayList<Project>();
        ProjectAdapter projectAdapter = new ProjectAdapter(R.layout.list_project,projectArrayList);

        recyclerView = (RecyclerView) view.findViewById(R.id.rvProject);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(projectAdapter);

        return view;
    }
}
