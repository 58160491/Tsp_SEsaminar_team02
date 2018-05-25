package com.palapol.tsp_sesaminar_team02;


import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.palapol.tsp_sesaminar_team02.model.ResObj;
import com.palapol.tsp_sesaminar_team02.remote.UserService;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */

public class SerchCatecgoryFragment extends Fragment {

    Spinner sp_year;
    Spinner sp_catecgory;
    Button btnSearch;
    UserService userService;
    Fragment serchCatecgoryFragment;

    public SerchCatecgoryFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_serch_catecgory, container, false);

        sp_year = (Spinner)view.findViewById(R.id.spinYear);
        sp_catecgory = (Spinner)view.findViewById(R.id.spinCategory);
        btnSearch = view.findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text_year = sp_year.getSelectedItem().toString();
                String text_catecgory = sp_catecgory.getSelectedItem().toString();
                Intent intent = new Intent(getActivity(),SerchFileSeminar.class);
                intent.putExtra("YEAR",text_year);
                intent.putExtra("CATECGORY",text_catecgory);
                startActivity(intent);

//                serchCatecgoryFragment = new SerchCatecgoryFragment();
//                FragmentManager fm = getFragmentManager();// อันนี้
//                FragmentTransaction ft = fm.beginTransaction(); //อันนี้เป็นคำสั่งเดิมของ Fragment
//
//                ft.replace(R.id.layout_for_Fragment, serchCatecgoryFragment);//เปลี่ยนจากหน้าไหนไปหน้าไหน ไอดีหน้า ที่ต้องการให้เปลี่ยน layout_for_fragment แล้วเลือกหน้าที่เราจะเอามาแทนคือbookStorefragment
//                ft.commit();
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.year, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_year.setAdapter(adapter);
        sp_year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.catecgory, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_catecgory.setAdapter(adapter2);
        sp_catecgory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }



}
