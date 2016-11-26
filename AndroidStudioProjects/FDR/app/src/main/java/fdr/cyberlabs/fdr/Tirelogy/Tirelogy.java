package fdr.cyberlabs.fdr.Tirelogy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import fdr.cyberlabs.fdr.Detail.DetailTire;
import fdr.cyberlabs.fdr.R;
import fdr.cyberlabs.fdr.Tirelogy.Knowledge.TireKnow;
import fdr.cyberlabs.fdr.Tirelogy.Techno.Techno;
import fdr.cyberlabs.fdr.Tirelogy.UsageSafety.UsageSafety;

public class Tirelogy extends AppCompatActivity implements View.OnClickListener {
    Button btnTireTech,btnTireKnow,btnTireUse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tirelogy);
        initComponent();

        btnTireTech.setOnClickListener(this);
        btnTireKnow.setOnClickListener(this);
        btnTireUse.setOnClickListener(this);
    }
    private void initComponent(){
        btnTireTech = (Button)findViewById(R.id.button_tech);
        btnTireKnow = (Button)findViewById(R.id.button_know);
        btnTireUse = (Button)findViewById(R.id.button_usage);
    }

    @Override
    public void onClick(View v) {
        if(v == btnTireTech){
            Intent intent = new Intent(getApplicationContext(), Techno.class);
            startActivity(intent);
        }else if(v == btnTireKnow){
            Intent intent = new Intent(getApplicationContext(), TireKnow.class);
            startActivity(intent);
        }else if(v == btnTireUse){
            Intent intent = new Intent(getApplicationContext(), UsageSafety.class);
            startActivity(intent);
        }
    }
}
