package fdr.cyberlabs.fdr.Tirelogy.UsageSafety;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import fdr.cyberlabs.fdr.R;

/**
 * Created by HadianR on 24/11/2016.
 */

public class UsageAdapter extends BaseAdapter {

    Activity activity;
    private LayoutInflater inflater;
    private List<DataUsage> dataUsages;
    Context context;

    public UsageAdapter(Activity activity, List<DataUsage> dataUsages, Context context){
        this.activity = activity;
        this.dataUsages = dataUsages;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataUsages.size();
    }

    @Override
    public Object getItem(int position) {
        return dataUsages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        final TextView ask;
        LinearLayout llAsk;
        if (inflater == null ){
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null){
            convertView = inflater.inflate(R.layout.t_us_list_menu, null);
        }

        ask = (TextView) convertView.findViewById(R.id.listAsk);
        llAsk = (LinearLayout) convertView.findViewById(R.id.llAsk);

        final DataUsage data = dataUsages.get(position);

        ask.setText(data.getPertanyaan());
        llAsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),UsageDetail.class);
                intent.putExtra("ask",ask.getText().toString());

                view.getContext().startActivity(intent);
            }
        });


        return convertView;
    }



    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
