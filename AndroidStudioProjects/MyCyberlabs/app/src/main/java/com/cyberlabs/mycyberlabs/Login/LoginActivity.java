package com.cyberlabs.mycyberlabs.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.cyberlabs.mycyberlabs.Index;
import com.cyberlabs.mycyberlabs.R;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername,etPassword;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin =(Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                final String kode_pegawai = etUsername.getText().toString();
                final String password = etPassword.getText().toString();

                final ProgressDialog pd = new ProgressDialog(LoginActivity.this);
                pd.setMessage("Please Wait..");
                pd.show();

                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            String kode_pegawai = jsonResponse.getString("kode_pegawai");
                            Log.i("kaluar maneh : ",kode_pegawai);
                            if (kode_pegawai !="null"){

                                String nama = jsonResponse.getString("nama");
                                Intent i = new Intent(LoginActivity.this,Index.class);
                                i.putExtra("nama",nama);
                                i.putExtra("kode_pegawai",kode_pegawai);

                                LoginActivity.this.startActivity(i);
                                finish();
                                Toast.makeText(LoginActivity.this, "Login Succes", Toast.LENGTH_SHORT).show();
                            }else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Wrong username/password")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                            pd.dismiss();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(kode_pegawai,password,responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }


        });
    }
}
