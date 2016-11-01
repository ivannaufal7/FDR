package com.cyberlabs.mycyberlabs.Login;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HadianR on 26/10/2016.
 */

public class LoginRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://sharemaps.esy.es/cyberlabs_management/login.php";
    private Map<String, String> params;

    public LoginRequest(String kode_pegawai, String password, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("kode_pegawai",kode_pegawai);
        params.put("password",password);
    }

    @Override
    public Map<String,String> getParams(){
        return params;
    }
}
