package fdr.cyberlabs.fdr.Tirelogy.Techno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import fdr.cyberlabs.fdr.R;

public class TechnoDetail extends AppCompatActivity {
    TextView tvNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t_t_detail_techno);

        Intent i = getIntent();
        String nama = i.getStringExtra("nama");

        tvNama = (TextView) findViewById(R.id.tvNama);
        tvNama.setText(nama);

        System.out.println("Nama : " + nama);


    }
}
