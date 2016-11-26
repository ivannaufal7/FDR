package fdr.cyberlabs.fdr.Tirelogy.UsageSafety;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import fdr.cyberlabs.fdr.R;

public class UsageSafety extends AppCompatActivity {

    private List<DataUsage> dataUsages = new ArrayList<DataUsage>();
    private ListView listView;
    private UsageAdapter adapter;
    Context context;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t_us_menu);

        listView = (ListView) findViewById(R.id.lvUsage);
        adapter = new UsageAdapter(this,dataUsages,context);
        listView.setAdapter(adapter);

        onData();



    }

    public void onData(){
        String url = "http://sharemaps.esy.es/FDR/usage.php";

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        DataUsage data = new DataUsage();
                        if (!jsonObject.isNull("ask")) {
                            data.setPertanyaan(jsonObject.getString("ask"));
                        }
                        dataUsages.add(data);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}
