package fdr.cyberlabs.fdr.Tirelogy.Knowledge;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import fdr.cyberlabs.fdr.Adapter.CustomListAdapter;
import fdr.cyberlabs.fdr.Adapter.CustomListTireAdapter;
import fdr.cyberlabs.fdr.R;

/**
 * Created by Gizmo on 24/11/2016.
 */
public class FragmentTire extends Fragment {
    ListView lvTire;
    CustomListAdapter adapter;
    private List<Simbol> SimbolList = new ArrayList<>();
    ArrayList myList = new ArrayList();
    String[] title = {"Tread","Sidewall","Rimline", "Bead Wire", "Inner Liner", "Carcass", "Tread Grooves"};
    String[] desk_struk = {"Bagian telapak ban  yang membentuk pattern (kembangan) yang berfungsi untuk membuang air saat melintasi jalan basah dan melindungi ban dari benturan.",
    "Dinding pada ban sebagai penopang dan ini juga sebagai penentu kelenturan ban saat digunakan sehingga berefek pada kenyamanan ban.",
    "Garis acuan yang berguna pada saat pemasangan ban terhadap velg sehingga ban tidak dirasa oleng.",
    "Kawat yang disatukan oleh karet yang keras dan berfungsi sebagai pemegang ban terhadap pelek.",
    "Lapisan khusus pada ban tubeless yang berfungsi sama dengan ban dalam, yaitu sebagai kantung udara. Pada ban tubetype lapisan inner liner ini tidak ada.",
    "Bagian ban yang berfungsi sebagai tulang bagi ban. Terbentuk dari anyaman benang nylon yang  dilapisi oleh karet.",
    "Alur pada ban yang membentuk kembangan (pattern) yang berfungsi untuk membuang air saat melintasi jalan basah."};

    int[] imageList = new int[]{R.drawable.tread,R.drawable.sidewall,R.drawable.rimline,R.drawable.beadwire,R.drawable.innerliner,
    R.drawable.carcass, R.drawable.treadgrooves};

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tire, container, false);

        getDataList();
        lvTire = (ListView)v.findViewById(R.id.lvTire);
        lvTire.setAdapter(new CustomListTireAdapter(getActivity(), myList));
        lvTire.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for(int i=0; i < title.length; i++){
                    if(position == i) {
                        String judulTire = title[i];
                        String deskTire = desk_struk[i];
                        int image_list = imageList[i];
                        Intent intent = new Intent(getActivity(), DetailBan.class);
                        intent.putExtra("judulTire",judulTire);
                        intent.putExtra("deskTire",deskTire);
                        intent.putExtra("imageList",image_list);
                        startActivity(intent);
                    }
                }
            }
        });
        return v;
    }

    private void getDataList() {
        for(int i=0; i < title.length; i++){
            Tire tr  = new Tire();
            tr.setTire(title[i]);
            myList.add(tr);
        }

    }
}
