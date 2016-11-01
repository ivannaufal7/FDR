package com.cyberlabs.mycyberlabs.Attend;


import android.app.Fragment;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.cyberlabs.mycyberlabs.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FragmentAttend extends Fragment implements SearchView.OnQueryTextListener {
    public static final String JSON_URL = "http://cyberdata.hol.es/all_users.php";
    public static final String JSON_URL_AVAI = "http://cyberdata.hol.es/users_avai.php";
    public static final String JSON_URL_UNA = "http://cyberdata.hol.es/users_una.php";
    private ListView lv;
    CustomList cl;
    Spinner sp;
    String[] data1 = {"Jadi"};
    SearchView searchView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_attend, container, false);
        lv = (ListView)view.findViewById(R.id.lv_name);
        lv.setTextFilterEnabled(true);
        ArrayAdapter<String> data = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data1);
        sp = (Spinner) view.findViewById(R.id.spinner);
        List<String> status = new ArrayList<String>();
        status.add("Status");
        status.add("Available");
        status.add("Unavailable");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, status);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(dataAdapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected : "+item, Toast.LENGTH_SHORT).show();

                if(item == "Available"){
                    lv.setAdapter(null);
                    sendRequestAvai();
                }else if(item == "Unavailable"){
                    lv.setAdapter(null);
                    sendRequestUna();
                }else{
                    lv.setAdapter(null);
                    sendRequest();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        setHasOptionsMenu(true);
        return view;
    }

    private void sendRequest(){
        StringRequest stringRequest = new StringRequest(JSON_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response == null){
                    Toast.makeText(getActivity(), "TEST", Toast.LENGTH_SHORT).show();
                }else{
                    showJSON(response);
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }
    private void sendRequestAvai(){
        StringRequest stringRequest = new StringRequest(JSON_URL_AVAI, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }
    private void sendRequestUna(){
        StringRequest stringRequest = new StringRequest(JSON_URL_UNA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }
    private void showJSON(String json){
        ParseJson pj = new ParseJson(json);
        pj.parseJson();
        cl = new CustomList(getActivity(), ParseJson.name,ParseJson.status,ParseJson.masuk,ParseJson.pulang);
        lv.setAdapter(cl);

        String data = Arrays.toString(ParseJson.name);
        Log.i("showJSON: ", data);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        searchView = (SearchView)item.getActionView();
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setOnQueryTextListener(this);
        searchView.setBackgroundColor(-1);
        searchView.setIconifiedByDefault(false);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.i("onQueryTextChange: ",newText);
        cl.getFilter().filter(newText);

        return true;
    }
}
