package fdr.cyberlabs.fdr.TireType;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import fdr.cyberlabs.fdr.R;
import fdr.cyberlabs.fdr.TireType.TireTube.TireTube;

public class MainActivity extends AppCompatActivity {
    Button btnTubeType,btnTubeless,btnTireTube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTireTube = (Button) findViewById(R.id.btnTubeTire);
        btnTubeless = (Button) findViewById(R.id.btnTubeLess);
        btnTubeType = (Button) findViewById(R.id.btnTubeType);

        btnTireTube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TireTube.class);
                view.getContext().startActivity(intent);
            }
        });

        btnTubeType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TireTube.class);

                view.getContext().startActivity(intent);
            }
        });

        btnTubeless.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TireTube.class);

                view.getContext().startActivity(intent);
            }
        });

    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_main, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
}
