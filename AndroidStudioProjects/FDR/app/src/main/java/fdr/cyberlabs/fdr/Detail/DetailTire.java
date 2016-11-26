package fdr.cyberlabs.fdr.Detail;

import android.animation.Animator;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import fdr.cyberlabs.fdr.R;

public class DetailTire extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener {

    Animation slideup, slidedown;
    LinearLayout bottomNav, fragKonten;
    ImageView close,back;
    TextView perform, overview, road;
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    Fragment fragment;
    private int buff=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tire);
        initComponent();

//        fragmentManager = getFragmentManager();
//        transaction = fragmentManager.beginTransaction();
//        transaction.add(R.id.detail_img, new fragmentImage());
//        transaction.commit();

        fragmentImage();
//        fragmentSpec();
        slideup = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slideup);
        slidedown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slidedown);
        perform.setOnClickListener(this);
        close.setOnClickListener(this);
        overview.setOnClickListener(this);
        road.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == perform) {
            fragKonten.setVisibility(View.VISIBLE);
            close.setVisibility(View.VISIBLE);
            back.setVisibility(View.GONE);
            fragmentManager = getFragmentManager();
            transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.spec_slider, new fragmentSpec());
            transaction.commit();
            overview.setBackgroundColor(Color.parseColor("#191919"));
            perform.setBackgroundColor(Color.parseColor("#ed1e24"));
            road.setBackgroundColor(Color.parseColor("#191919"));
            if(buff==0)bottomNav.startAnimation(slideup);
            buff++;
//            bottomNav.animate().translationY(-10).setDuration(1000).start();
//            bottomNav.clearAnimation();

        }else if(v == overview){
            close.setVisibility(View.VISIBLE);
            fragKonten.setVisibility(View.VISIBLE);
            back.setVisibility(View.GONE);
            if(buff==0)bottomNav.startAnimation(slideup);
            buff++;
            fragmentManager = getFragmentManager();
            transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.spec_slider, new fragmentOverview());
            transaction.commit();
            overview.setBackgroundColor(Color.parseColor("#ed1e24"));
            perform.setBackgroundColor(Color.parseColor("#191919"));
            road.setBackgroundColor(Color.parseColor("#191919"));
//            bottomNav.clearAnimation();
        }else if(v == road){
            close.setVisibility(View.VISIBLE);
            fragKonten.setVisibility(View.VISIBLE);
            back.setVisibility(View.GONE);
            if(buff==0)bottomNav.startAnimation(slideup);
            buff++;
            fragmentManager = getFragmentManager();
            transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.spec_slider, new fragmentRoad());
            transaction.commit();
            overview.setBackgroundColor(Color.parseColor("#191919"));
            perform.setBackgroundColor(Color.parseColor("#191919"));
            road.setBackgroundColor(Color.parseColor("#ed1e24"));
//            bottomNav.clearAnimation();
        }else if(v == back){
            finish();
        }
        else if (v == close) {
            fragKonten.setVisibility(View.GONE);
            close.setVisibility(View.GONE);
            back.setVisibility(View.VISIBLE);
            buff = 0;
            bottomNav.startAnimation(slidedown);
//            fragKonten.startAnimation(slidedown);
        }
    }
    private void initComponent() {
        bottomNav = (LinearLayout) findViewById(R.id.bottomNav);
        fragKonten = (LinearLayout) findViewById(R.id.fragKonten);
        perform = (TextView) findViewById(R.id.perform);
        overview = (TextView)findViewById(R.id.overview);
        road = (TextView) findViewById(R.id.road);
        close = (ImageView) findViewById(R.id.close);
        back = (ImageView) findViewById(R.id.back);
    }

    private void fragmentImage() {
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.detail_img, new fragmentImage());
        transaction.commit();
    }
    private void fragmentSpec() {
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.spec_slider, new fragmentSpec());
        transaction.commit();
    }
    private void fragmentOverview(){
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.spec_slider,new fragmentOverview());
        transaction.commit();
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
