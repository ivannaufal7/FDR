package fdr.cyberlabs.fdr.Detail;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import fdr.cyberlabs.fdr.Adapter.TabPagerAdapter;
import fdr.cyberlabs.fdr.R;

/**
 * Created by Gizmo on 23/11/2016.
 */
public class fragmentSpec extends Fragment implements View.OnClickListener {
    TabLayout tabs;
    ViewPager pager;
    TabPagerAdapter adapter;
    private FragmentActivity context;

    Button btnIcon1, btnIcon2, btnIcon3;
    public boolean btn1 = true, btn2 = false, btn3 = false;

    ImageView imgPerform, btnNext, btnPrev;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spec,container,false);

        btnIcon1 = (Button) view.findViewById(R.id.btnIcon1);
        btnIcon2 = (Button) view.findViewById(R.id.btnIcon2);
        btnIcon3 = (Button) view.findViewById(R.id.btnIcon3);

        imgPerform = (ImageView) view.findViewById(R.id.imgPerform);
        btnNext = (ImageView) view.findViewById(R.id.next);
        btnPrev = (ImageView) view.findViewById(R.id.prev);

        btnIcon1.setOnClickListener(this);
        btnIcon2.setOnClickListener(this);
        btnIcon3.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnPrev.setOnClickListener(this);
//        tabs = (TabLayout) view.findViewById(R.id.tabs);
//        pager = (ViewPager)view.findViewById(R.id.pager);
//        adapter = new TabPagerAdapter(context.getSupportFragmentManager());
//
//        adapter.setFragmentList(new fragmentCornering());
//        adapter.setFragmentList(new fragmentDry());
//        adapter.setFragmentList(new fragmentWet());
//
//        pager.setAdapter(adapter);
//        tabs.setupWithViewPager(pager);
//        tabs.setTabGravity(TabLayout.GRAVITY_FILL);
//        tabs.setOnTabSelectedListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v == btnIcon1){
            imgPerform.setImageResource(R.drawable.cornering);
            btnIcon1.setBackground(getActivity().getResources().getDrawable(R.drawable.tab));
            btnIcon2.setBackgroundColor(Color.parseColor("#00ffffff"));
            btnIcon3.setBackgroundColor(Color.parseColor("#00ffffff"));
            btn1 = true;
            btn2 = false;
            btn3= false;
        }else if(v == btnIcon2){
            imgPerform.setImageResource(R.drawable.dry);
            btnIcon1.setBackgroundColor(Color.parseColor("#00ffffff"));
            btnIcon2.setBackground(getActivity().getResources().getDrawable(R.drawable.tab));
            btnIcon3.setBackgroundColor(Color.parseColor("#00ffffff"));
            btn1 = false;
            btn2 = true;
            btn3 = false;
        }else if(v == btnIcon3){
            imgPerform.setImageResource(R.drawable.wet);
            btnIcon1.setBackgroundColor(Color.parseColor("#00ffffff"));
            btnIcon2.setBackgroundColor(Color.parseColor("#00ffffff"));
            btnIcon3.setBackground(getActivity().getResources().getDrawable(R.drawable.tab));
            btn1 = false;
            btn2 = false;
            btn3 = true;
        }else if(v == btnNext){
            if (btn1){
                imgPerform.setImageResource(R.drawable.dry);
                btnIcon1.setBackgroundColor(Color.parseColor("#00ffffff"));
                btnIcon2.setBackground(getActivity().getResources().getDrawable(R.drawable.tab));
                btnIcon3.setBackgroundColor(Color.parseColor("#00ffffff"));
                btn1 = false;
                btn2 = true;
                btn3 = false;
            }else if (btn2){
                imgPerform.setImageResource(R.drawable.wet);
                btnIcon1.setBackgroundColor(Color.parseColor("#00ffffff"));
                btnIcon2.setBackgroundColor(Color.parseColor("#00ffffff"));
                btnIcon3.setBackground(getActivity().getResources().getDrawable(R.drawable.tab));
                btn1 = false;
                btn2 = false;
                btn3 = true;
            }else if(btn3){
                imgPerform.setImageResource(R.drawable.cornering);
                btnIcon1.setBackground(getActivity().getResources().getDrawable(R.drawable.tab));
                btnIcon2.setBackgroundColor(Color.parseColor("#00ffffff"));
                btnIcon3.setBackgroundColor(Color.parseColor("#00ffffff"));
                btn1 = true;
                btn2 = false;
                btn3= false;
            }
        }else if(v == btnPrev){
            if(btn1){
                imgPerform.setImageResource(R.drawable.wet);
                btnIcon1.setBackgroundColor(Color.parseColor("#00ffffff"));
                btnIcon2.setBackgroundColor(Color.parseColor("#00ffffff"));
                btnIcon3.setBackground(getActivity().getResources().getDrawable(R.drawable.tab));
                btn1 = false;
                btn2 = false;
                btn3 = true;
            }else if(btn2){
                imgPerform.setImageResource(R.drawable.cornering);
                btnIcon1.setBackground(getActivity().getResources().getDrawable(R.drawable.tab));
                btnIcon2.setBackgroundColor(Color.parseColor("#00ffffff"));
                btnIcon3.setBackgroundColor(Color.parseColor("#00ffffff"));
                btn1 = true;
                btn2 = false;
                btn3= false;
            }else if(btn3){
                imgPerform.setImageResource(R.drawable.dry);
                btnIcon1.setBackgroundColor(Color.parseColor("#00ffffff"));
                btnIcon2.setBackground(getActivity().getResources().getDrawable(R.drawable.tab));
                btnIcon3.setBackgroundColor(Color.parseColor("#00ffffff"));
                btn1 = false;
                btn2 = true;
                btn3 = false;
            }
        }
    }

//    @Override
//    public void onTabSelected(TabLayout.Tab tab) {
//        pager.setCurrentItem(tab.getPosition());
//    }
//
//    @Override
//    public void onTabUnselected(TabLayout.Tab tab) {
//
//    }
//
//    @Override
//    public void onTabReselected(TabLayout.Tab tab) {
//
//    }
//
//    @Override
//    public void onAttach(Activity activity) {
//        context = (FragmentActivity)activity;
//        super.onAttach(activity);
//    }
}
