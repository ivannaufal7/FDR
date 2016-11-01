package com.cyberlabs.mycyberlabs.Notif;

import android.annotation.TargetApi;
import android.app.Fragment;
//import android.icu.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cyberlabs.mycyberlabs.R;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by HadianR on 28/10/2016.
 */

public class FragmentNotif extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notif, container, false);

//        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String formattedDate = df.format(c.getTime());

        TextView tv = (TextView) view.findViewById(R.id.tvDate);
        tv.setText(formattedDate);


        return view;

    }
}