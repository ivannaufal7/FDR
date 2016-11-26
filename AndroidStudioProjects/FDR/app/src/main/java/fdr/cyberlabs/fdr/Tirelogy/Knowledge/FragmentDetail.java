package fdr.cyberlabs.fdr.Tirelogy.Knowledge;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fdr.cyberlabs.fdr.R;

/**
 * Created by Gizmo on 24/11/2016.
 */
public class FragmentDetail extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail,container,false);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
