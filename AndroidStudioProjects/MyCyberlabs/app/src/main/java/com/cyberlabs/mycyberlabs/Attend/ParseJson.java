package com.cyberlabs.mycyberlabs.Attend;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Gizmo on 30/10/2016.
 */
public class ParseJson {
    public static String[] name;
    public static String[] status;
    public static String[] masuk;
    public static String[] pulang;

    public static final String JSON_ARRAY = "result";
    public static final String KEY_NAME = "name";
    public static final String KEY_STATUS = "status";
    public static final String KEY_MASUK = "masuk";
    public static final String KEY_PULANG = "pulang";

    private JSONArray users = null;
    private String json;

    public ParseJson(String json){
        this.json = json;
    }
    protected void parseJson(){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

            name = new String[users.length()];
            status = new String[users.length()];
            masuk = new String[users.length()];
            pulang = new String[users.length()];

            for(int i=0; i<users.length(); i++){
                JSONObject jo =  users.getJSONObject(i);
                name[i] = jo.getString(KEY_NAME);
                status[i] = jo.getString(KEY_STATUS);
                masuk[i] = jo.getString(KEY_MASUK);
                pulang[i] = jo.getString(KEY_PULANG);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
