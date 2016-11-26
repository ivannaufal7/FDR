package fdr.cyberlabs.fdr.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import fdr.cyberlabs.fdr.R;
import fdr.cyberlabs.fdr.Tirelogy.Knowledge.Tire;

/**
 * Created by Gizmo on 24/11/2016.
 */
public class CustomListTireAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Tire> TireItems;

    public CustomListTireAdapter(Activity activity, List<Tire> TireItems) {
        this.activity = activity;
        this.TireItems = TireItems;
    }
    @Override
    public int getCount() {
        return TireItems.size();
    }

    @Override
    public Object getItem(int location) {
        return TireItems.get(location);
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
            convertView = inflater.inflate(R.layout.list_tire,null);
        }
        TextView tire = (TextView) convertView.findViewById(R.id.tvTire);

        Tire data =  TireItems.get(position);
        tire.setText(data.getTire());

        return convertView;
    }
}
