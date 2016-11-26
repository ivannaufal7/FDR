package fdr.cyberlabs.fdr.Tirelogy.UsageSafety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fdr.cyberlabs.fdr.R;

public class UsageDetail extends AppCompatActivity {

    TextView tvAskDetail;
    ImageView imgBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t_us_detail_usage);

        tvAskDetail = (TextView) findViewById(R.id.tvAskTitle);
        imgBack = (ImageView) findViewById(R.id.imgBack);

        final Intent i = getIntent();
        final String ask = i.getStringExtra("ask");

        tvAskDetail.setText(ask);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
