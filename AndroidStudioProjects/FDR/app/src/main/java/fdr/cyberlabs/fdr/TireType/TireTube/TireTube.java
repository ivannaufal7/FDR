package fdr.cyberlabs.fdr.TireType.TireTube;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;

import fdr.cyberlabs.fdr.R;
import fdr.cyberlabs.fdr.Tirelogy.Techno.Techno;
import me.relex.circleindicator.CircleIndicator;

public class TireTube extends AppCompatActivity {

    private CustomPagerAdapter mCustomPagerAdapter;
    private ViewPager mViewPager;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tt_tiretube_main);

        mCustomPagerAdapter = new CustomPagerAdapter(this);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);


        mViewPager.setAdapter(mCustomPagerAdapter);
        indicator.setViewPager(mViewPager);
        mCustomPagerAdapter.registerDataSetObserver(indicator.getDataSetObserver());

        ImageView imgPrev = (ImageView) findViewById(R.id.prevSlide);
        ImageView imgNext = (ImageView) findViewById(R.id.nextSlide);

        imgPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(getItem(-1),true);
            }
        });

        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(getItem(+1),true);
            }
        });


    }


    private int getItem(int i) {
        return mViewPager.getCurrentItem() + i;
    }
}
