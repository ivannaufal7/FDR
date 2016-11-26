package fdr.cyberlabs.fdr.Tirelogy.Knowledge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fdr.cyberlabs.fdr.R;

public class DetailKnow extends AppCompatActivity implements View.OnClickListener {

    TextView judulSimbol,deskripsiSimbol;
    ImageView btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_know);

        judulSimbol = (TextView)findViewById(R.id.judul_detail);
        deskripsiSimbol = (TextView)findViewById(R.id.desk);
        btnBack = (ImageView) findViewById(R.id.simbol_back);

        String data = getIntent().getExtras().getString("title");
        judulSimbol.setText(data);
        Log.i("ADA : ",data);

        String desk = getIntent().getExtras().getString("desk");
        deskripsiSimbol.setText(desk);
        Log.i("DESK: ",desk);

        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnBack){
            finish();
        }
    }
}
