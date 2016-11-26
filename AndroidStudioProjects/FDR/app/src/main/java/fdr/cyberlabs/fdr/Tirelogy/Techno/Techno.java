package fdr.cyberlabs.fdr.Tirelogy.Techno;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import fdr.cyberlabs.fdr.R;

public class Techno extends AppCompatActivity {


    //Tag values to read from json
    public static final String TAG_IMAGE_URL = "image";
    public static final String TAG_NAMA = "nama";

    //GridView Object
    private GridView gridView;
    GridViewAdapter gridViewAdapter;

    //ArrayList for Storing image urls and titles
    private ArrayList<String> images;
    private ArrayList<String> nama;

    ImageView btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t_t_menu);

        gridView = (GridView) findViewById(R.id.gvTechno);
        getData();
        images = new ArrayList<>();
        nama = new ArrayList<>();


        btnBack = (ImageView)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//        Calling the getData method


        System.out.println("kaluarlah : " + TAG_IMAGE_URL);
    }

    private void getData(){
        //Showing a progress dialog while our app fetches the data from url
        String DATA_URL = "http://sharemaps.esy.es/FDR/technology.php";
        //Creating a json array request to get the json from our api
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(DATA_URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Dismissing the progressdialog on response

                        //Displaying our grid
                        showGrid(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        //Creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //Adding our request to the queue
        requestQueue.add(jsonArrayRequest);
    }

    private void showGrid(JSONArray jsonArray){
        for(int i = 0; i<jsonArray.length(); i++){
            //Creating a json object of the current index

            try {
                //getting json object from current index
                JSONObject obj = jsonArray.getJSONObject(i);

                if (obj.has("img_logo")){
                    String url_image = obj.getString("img_logo");
                    images.add(obj.getString("img_logo"));
                }
                if (obj.has("nama")){
                    String names = obj.getString("nama");
                    nama.add(obj.getString("nama"));
                }
                //getting image url and title from json object

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        //Creating GridViewAdapter Object
        GridViewAdapter gridViewAdapter = new GridViewAdapter(this,images,nama);

        //Adding adapter to gridview
        gridView.setAdapter(gridViewAdapter);
    }
}
