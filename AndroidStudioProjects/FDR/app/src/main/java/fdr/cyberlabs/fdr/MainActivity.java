package fdr.cyberlabs.fdr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import fdr.cyberlabs.fdr.Detail.DetailTire;
import fdr.cyberlabs.fdr.Tirelogy.Tirelogy;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView btnChoose, btnTirelogy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_main);

        btnChoose = (ImageView)findViewById(R.id.btn_one);
        btnTirelogy = (ImageView)findViewById(R.id.btn_two);

        btnChoose.setOnClickListener(this);
        btnTirelogy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnChoose){
            Intent intent = new Intent(this, fdr.cyberlabs.fdr.TireType.MainActivity.class);
            startActivity(intent);
        }else if(v == btnTirelogy){
            Intent intent = new Intent(this, Tirelogy.class);
            startActivity(intent);
        }
    }
}
