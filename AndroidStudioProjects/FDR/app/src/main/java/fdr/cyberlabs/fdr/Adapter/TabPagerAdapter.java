package fdr.cyberlabs.fdr.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gizmo on 23/11/2016.
 */
public class TabPagerAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragmentList = new ArrayList<>();
    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setFragmentList(Fragment fragment) {
        this.fragmentList.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch(position){
            case 0:
                title = "Cornering Stability";
                break;
            case 1:
                title = "Dry Grip";
                break;
            case 2 :
                title = "Wet Grip";
                break;
        }
        return title;
    }
}
