package fdr.cyberlabs.fdr.Tirelogy.Techno;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

import fdr.cyberlabs.fdr.R;

/**
 * Created by HadianR on 23/11/2016.
 */

public class GridViewAdapter extends BaseAdapter {

    private ImageLoader imageLoader;

    //Context
    private Context ctx;
    private ArrayList<String> nama;
    private ArrayList<String> images;

    public GridViewAdapter(Context ctx, ArrayList<String> images, ArrayList<String> nama){
        this.ctx = ctx;
        this.images = images;
        this.nama = nama;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LinearLayout linearLayout = new LinearLayout(ctx);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        //NETWORK IMAGEVIEW
        NetworkImageView networkImageView = new NetworkImageView(ctx);

        //Inisial
        imageLoader = CustomVolleyRequest.getInstance(ctx).getImageLoader();
        imageLoader.get(images.get(position), ImageLoader.getImageListener(networkImageView, R.mipmap.ic_launcher, android.R.drawable.ic_dialog_alert));

        //Setting Image load
        networkImageView.setImageUrl(images.get(position),imageLoader);

//        TextView textView = new TextView(ctx);
        String n = nama.get(position);

//        System.out.println("nama saya : " + n);

        //Scaling the imageview
        networkImageView.setScaleType(ImageView.ScaleType.CENTER);
        networkImageView.setLayoutParams(new GridView.LayoutParams(125,125));
        networkImageView.setAdjustViewBounds(true);
        networkImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),TechnoDetail.class);
                intent.putExtra("nama",nama.get(position));
                view.getContext().startActivity(intent);
            }
        });

        // adding views to layout
        linearLayout.addView(networkImageView);
//        linearLayout.addView(textView);

        return linearLayout;
    }
}
