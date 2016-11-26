package fdr.cyberlabs.fdr.Detail;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import fdr.cyberlabs.fdr.R;

/**
 * Created by Gizmo on 23/11/2016.
 */
public class fragmentOverview extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview,container,false);
        return view;
    }
}
