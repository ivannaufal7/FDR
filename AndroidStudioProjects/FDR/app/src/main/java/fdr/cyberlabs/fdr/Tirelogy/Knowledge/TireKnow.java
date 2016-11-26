package fdr.cyberlabs.fdr.Tirelogy.Knowledge;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import fdr.cyberlabs.fdr.R;

public class TireKnow extends AppCompatActivity implements View.OnClickListener {
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    Button btnSimbol,btnTire;
    ImageView btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tire_know);

//        fragmentManager = getFragmentManager();
//        transaction = fragmentManager.beginTransaction();
//        transaction.add(R.id.fragSimbol, new FragmentSimbol());
//        transaction.commit();

        fragSimbol();

        btnSimbol = (Button) findViewById(R.id.btnSimbol);
        btnTire = (Button) findViewById(R.id.btnTire);
        btnBack = (ImageView)findViewById(R.id.back);
        btnSimbol.setOnClickListener(this);
        btnTire.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnSimbol){
            fragSimbol();
            btnSimbol.setBackgroundColor(Color.parseColor("#ed1e24"));
            btnTire.setBackgroundColor(Color.parseColor("#191919"));
        }else if(v == btnTire){
            fragTire();
            btnSimbol.setBackgroundColor(Color.parseColor("#191919"));
            btnTire.setBackgroundColor(Color.parseColor("#ed1e24"));
        }else if(v == btnBack){
            finish();
        }
    }

    private void fragSimbol(){
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragSimbol, new FragmentSimbol());
        transaction.commit();
    }

    private void fragTire(){
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragSimbol, new FragmentTire());
        transaction.commit();
    }
}
