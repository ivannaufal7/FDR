package fdr.cyberlabs.fdr.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fdr.cyberlabs.fdr.R;
import fdr.cyberlabs.fdr.Tirelogy.Knowledge.Simbol;

/**
 * Created by Gizmo on 24/11/2016.
 */
public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Simbol> SimbolItems;

    String[] name,status,masuk,pulang;

    public CustomListAdapter(Activity activity, List<Simbol> SimbolItems) {
        this.activity = activity;
        this.SimbolItems = SimbolItems;
    }
    @Override
    public int getCount() {
        return SimbolItems.size();
    }

    @Override
    public Object getItem(int location) {
        return SimbolItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(inflater == null){
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_simbol,null);
        }
        TextView judul = (TextView) convertView.findViewById(R.id.tvJudul);

        Simbol data =  SimbolItems.get(position);
        judul.setText(data.getJudul());

        return convertView;
    }
}
