package com.cyberlabs.mycyberlabs.Notif;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by HadianR on 31/10/2016.
 */

public class NotifAdapter extends RecyclerView.Adapter<NotifAdapter.ViewHolder> {
    private int listNotifLayout;
    private ArrayList<Notif> notifArrayList;
    String [] sender={
      "Admin"
    };
    String [] text={
      "ini adalah notif","Notification"
    };

    public NotifAdapter(int layoutId, ArrayList<Notif> notifArrayList){
        listNotifLayout = layoutId;
        this.notifArrayList = notifArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listNotifLayout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
