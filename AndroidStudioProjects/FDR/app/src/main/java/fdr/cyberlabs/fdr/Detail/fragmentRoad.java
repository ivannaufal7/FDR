package fdr.cyberlabs.fdr.Detail;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import fdr.cyberlabs.fdr.R;

/**
 * Created by Gizmo on 25/11/2016.
 */
public class fragmentRoad extends Fragment implements View.OnClickListener {
    Button btnRoad1, btnRoad2, btnRoad3;
    public boolean btn1 = true, btn2 = false, btn3 = false;
    ImageView imgRoad, btnNextRoad, btnPrevRoad;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_road,container,false);

        btnRoad1 = (Button) view.findViewById(R.id.btnRoad1);
        btnRoad2 = (Button) view.findViewById(R.id.btnRoad2);
        btnRoad3 = (Button) view.findViewById(R.id.btnRoad3);

        imgRoad = (ImageView) view.findViewById(R.id.imgRoad);
        btnNextRoad = (ImageView) view.findViewById(R.id.next_road);
        btnPrevRoad = (ImageView) view.findViewById(R.id.prev_road);

        btnRoad1.setOnClickListener(this);
        btnRoad2.setOnClickListener(this);
        btnRoad3.setOnClickListener(this);
        btnNextRoad.setOnClickListener(this);
        btnPrevRoad.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v == btnRoad1){
            imgRoad.setImageResource(R.drawable.wet);
            btnRoad1.setBackground(getActivity().getResources().getDrawable(R.drawable.tab));
            btnRoad2.setBackgroundColor(Color.parseColor("#00ffffff"));
            btnRoad3.setBackgroundColor(Color.parseColor("#00ffffff"));
            btn1 = true;
            btn2 = false;
            btn3= false;
        }else if(v == btnRoad2){
            imgRoad.setImageResource(R.drawable.cornering);
            btnRoad1.setBackgroundColor(Color.parseColor("#00ffffff"));
            btnRoad2.setBackground(getActivity().getResources().getDrawable(R.drawable.tab));
            btnRoad3.setBackgroundColor(Color.parseColor("#00ffffff"));
            btn1 = false;
            btn2 = true;
            btn3 = false;
        }else if(v == btnRoad3){
            imgRoad.setImageResource(R.drawable.dry);
            btnRoad1.setBackgroundColor(Color.parseColor("#00ffffff"));
            btnRoad2.setBackgroundColor(Color.parseColor("#00ffffff"));
            btnRoad3.setBackground(getActivity().getResources().getDrawable(R.drawable.tab));
            btn1 = false;
            btn2 = false;
            btn3 = true;
        }else if(v == btnNextRoad){
            if(btn1){
                imgRoad.setImageResource(R.drawable.cornering);
                btnRoad1.setBackgroundColor(Color.parseColor("#00ffffff"));
                btnRoad2.setBackground(getActivity().getResources().getDrawable(R.drawable.tab));
                btnRoad3.setBackgroundColor(Color.parseColor("#00ffffff"));
                btn1 = false;
                btn2 = true;
                btn3 = false;
            }else if(btn2){
                imgRoad.setImageResource(R.drawable.dry);
                btnRoad1.setBackgroundColor(Color.parseColor("#00ffffff"));
                btnRoad2.setBackgroundColor(Color.parseColor("#00ffffff"));
                btnRoad3.setBackground(getActivity().getResources().getDrawable(R.drawable.tab));
                btn1 = false;
                btn2 = false;
                btn3 = true;
            }else if(btn3){
                imgRoad.setImageResource(R.drawable.wet);
                btnRoad1.setBackground(getActivity().getResources().getDrawable(R.drawable.tab));
                btnRoad2.setBackgroundColor(Color.parseColor("#00ffffff"));
                btnRoad3.setBackgroundColor(Color.parseColor("#00ffffff"));
                btn1 = true;
                btn2 = false;
                btn3= false;
            }
        }else if(v == btnPrevRoad){
            if(btn1){
                imgRoad.setImageResource(R.drawable.dry);
                btnRoad1.setBackgroundColor(Color.parseColor("#00ffffff"));
                btnRoad2.setBackgroundColor(Color.parseColor("#00ffffff"));
                btnRoad3.setBackground(getActivity().getResources().getDrawable(R.drawable.tab));
                btn1 = false;
                btn2 = false;
                btn3 = true;
            }else if(btn2){
                imgRoad.setImageResource(R.drawable.wet);
                btnRoad1.setBackground(getActivity().getResources().getDrawable(R.drawable.tab));
                btnRoad2.setBackgroundColor(Color.parseColor("#00ffffff"));
                btnRoad3.setBackgroundColor(Color.parseColor("#00ffffff"));
                btn1 = true;
                btn2 = false;
                btn3= false;
            }else if(btn3){
                imgRoad.setImageResource(R.drawable.cornering);
                btnRoad1.setBackgroundColor(Color.parseColor("#00ffffff"));
                btnRoad2.setBackground(getActivity().getResources().getDrawable(R.drawable.tab));
                btnRoad3.setBackgroundColor(Color.parseColor("#00ffffff"));
                btn1 = false;
                btn2 = true;
                btn3 = false;
            }
        }
    }
}
