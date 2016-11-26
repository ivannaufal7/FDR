package fdr.cyberlabs.fdr.Tirelogy.Knowledge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fdr.cyberlabs.fdr.R;

public class DetailBan extends AppCompatActivity implements View.OnClickListener {

    TextView judulTire, deskTire;
    ImageView imageTire,btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ban);

        judulTire = (TextView) findViewById(R.id.judul_struktur);
        deskTire = (TextView) findViewById(R.id.desk_struktur);
        imageTire = (ImageView)findViewById(R.id.img_struktur);
        btnBack = (ImageView)findViewById(R.id.ban_back);

        String judul = getIntent().getExtras().getString("judulTire");
        judulTire.setText(judul);

        String desk = getIntent().getExtras().getString("deskTire");
        deskTire.setText(desk);

        int img = getIntent().getExtras().getInt("imageList");
        imageTire.setImageResource(img);

        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnBack){
            finish();
        }
    }
}
