package fdr.cyberlabs.fdr.TireType.TireTube;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import fdr.cyberlabs.fdr.Detail.DetailTire;
import fdr.cyberlabs.fdr.R;
import fdr.cyberlabs.fdr.Tirelogy.Techno.Techno;

/**
 * Created by HadianR on 25/11/2016.
 */

public class CustomPagerAdapter extends PagerAdapter {
    Context mContext;
    LayoutInflater mLayoutInflater;
    private int[] mResources = {
            R.drawable.ss_cub,
            R.drawable.ss_cub2,
            R.drawable.ss_cub3,
            R.drawable.ss_cub4,
            R.drawable.ss_cub5
    };


    public CustomPagerAdapter(Context mContext){
        this.mContext = mContext;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mResources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.img_pager_item);
        imageView.setImageResource(mResources[position]);

        container.addView(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailTire.class);

                view.getContext().startActivity(intent);
            }
        });

        return itemView;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
