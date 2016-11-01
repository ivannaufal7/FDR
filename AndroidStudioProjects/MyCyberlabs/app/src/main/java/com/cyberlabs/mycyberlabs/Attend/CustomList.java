package com.cyberlabs.mycyberlabs.Attend;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cyberlabs.mycyberlabs.R;


public class CustomList extends ArrayAdapter<String> {
    private String[] name;
    private String[] status;
    private String[] masuk;
    private String[] pulang;
    private Activity context;

    public CustomList(Activity context, String[] name, String[] status, String[] masuk, String[] pulang){
        super(context, R.layout.list_attend,name);
        this.context = context;
        this.name = name;
        this.status = status;
        this.masuk = masuk;
        this.pulang = pulang;

    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_attend,null,true);
        TextView tv_name = (TextView)listViewItem.findViewById(R.id.tv_name);
        TextView tv_status = (TextView)listViewItem.findViewById(R.id.tv_status);
        TextView tv_masuk = (TextView)listViewItem.findViewById(R.id.tv_masuk);
        TextView tv_pulang = (TextView)listViewItem.findViewById(R.id.tv_pulang);


        tv_name.setText(name[position]);
        String dataStatus = status[position];
        String dataBanding = "Available";
        if(dataStatus.equals(dataBanding)){
            tv_status.setText(dataStatus);
            tv_status.setTextColor(Color.rgb(76, 175, 80));
        }else{
            tv_status.setText(dataStatus);
            tv_status.setTextColor(Color.rgb(97, 97, 97));
        }

        String dataMasuk = masuk[position];
        String dataBanding2 = "00:00:00";

        if(dataMasuk.equals(dataBanding2)) {
            tv_masuk.setText("Masuk : - ");
        }else{
            tv_masuk.setText("Masuk : "+dataMasuk);
        }

        String dataPulang = pulang[position];
        String dataBanding3 = "00:00:00";

        if(dataPulang.equals(dataBanding3)) {
            tv_pulang.setText("Pulang : - ");
        }else{
            tv_pulang.setText("Pulang : "+dataPulang);
        }
        return listViewItem;
    }
}