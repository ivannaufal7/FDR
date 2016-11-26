package fdr.cyberlabs.fdr.Tirelogy.Knowledge;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fdr.cyberlabs.fdr.Adapter.CustomListAdapter;
import fdr.cyberlabs.fdr.R;

/**"
 * Created by Gizmo on 24/11/2016.
 */
public class FragmentSimbol extends Fragment {
    ListView lvSimbol;
    CustomListAdapter adapter;
    private List<Simbol> SimbolList = new ArrayList<>();
    ArrayList myList = new ArrayList();
    String[] title = {"Brand Name","Rotation","Country Of Manufacture", "Product Name", "Date Code", "Tire Type", "Tire Size",
    "Tire Cord", "Load & Pressure Requirement", "Tread Wire Indicator"};

    String[] deskripsi = {"Merek","Arah panah menunjukkan arah putaran ban. Pasang ban sesuai rotasi ban",
    "Negara Pembuat dan logo Standar Nasional Indonesia","Nama merek dagang ","Menunjukkan usia produksi\n" +
            "07 = minggu produksi \n" +
            "14 = tahun produksi, yaitu 2014 \n","Menunjukkan salah satu jenis ban, yaitu:\n" +
            "•\tTubetype adalah jenis ban yang aplikasinya harus menggunakan ban dalam \n" +
            "•\tTubeless adalah jenis ban yang tidak menggunakan ban dalam\n","NULL","Anyaman benang untuk lapisan yang berfungsi sebagai tulang ban terbuat dari benang nilon",
    "Menunjukkan beban maksimum yang bisa tanggung ban, yaitu 170 kg (374lbs) dengan tekanan ban 260kPa (33psi) pada kondisi ban dingin atau saat kendaraan tidak sedang berjalan.",
    "Simbol segitiga menunjukkan lokasi TWI atau batas pemakaian ban yang berada di sejumlah titik pada pola kembangan ban. Jika keausan ban sudah mencapai tanda ini maka ban harus segera diganti."};
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.simbol, container, false);

        getDataList();
        lvSimbol = (ListView)v.findViewById(R.id.lvSimbol);
        adapter = new CustomListAdapter(getActivity(), myList);
        lvSimbol.setAdapter(adapter);

        lvSimbol.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for(int i = 0; i < title.length; i++){
                    if(position == i){
                      String data = title[i];
                        String desk = deskripsi[i];
                        Intent intent = new Intent(getActivity(), DetailKnow.class);
                        intent.putExtra("title",data);
                        intent.putExtra("desk",desk);
                        startActivity(intent);
                    }
                }
            }
        });
        return v;
    }

    private void getDataList() {
        for(int i=0; i < title.length; i++){
            Simbol sb  = new Simbol();
            sb.setJudul(title[i]);
            myList.add(sb);
        }

    }
}
