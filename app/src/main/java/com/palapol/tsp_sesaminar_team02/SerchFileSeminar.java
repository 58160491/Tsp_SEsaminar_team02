package com.palapol.tsp_sesaminar_team02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
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

public class SerchFileSeminar extends AppCompatActivity {

    String text_year;
    String catecgory;
    UserService userService;
    int year;
    RecyclerView recy;
    SerchFileAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serch_file_seminar);
        init();

        recy.setHasFixedSize(true);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        recy.setLayoutManager(lm);



        Bundle bundle = getIntent().getExtras();
        text_year = bundle.getString("YEAR");
        catecgory = bundle.getString("CATECGORY");
        year = Integer.parseInt(text_year);

//        text_year = year+"";

        service();
    }

    private void init() {
        recy = findViewById(R.id.recyclerview);
    }

    private void service() {
        OkHttpClient okHttpClient = com.kingkarn.projectbeaconapplication.UnsafeOkHttpClient.getUnsafeOkHttpClient();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
//        if (retrofit == null){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://se.informatics.buu.ac.th/seminar/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
         userService = retrofit.create(UserService.class);

        userService.search(year,catecgory).enqueue(new Callback<List<ResObj>>() {
            @Override
            public void onResponse(Call<List<ResObj>> call, Response<List<ResObj>> response) {
                if (response.isSuccessful()){
                    List<ResObj> resObj = response.body();
                    if (resObj.size() != 0){
                        Toast.makeText(SerchFileSeminar.this, "yessssssssssssssss", Toast.LENGTH_SHORT).show();

                        mAdapter = new SerchFileAdapter(SerchFileSeminar.this,resObj);
                        recy.setAdapter(mAdapter);

                    } else {
                        Toast.makeText(SerchFileSeminar.this, "The username or password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SerchFileSeminar.this, "Error Please try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ResObj>> call, Throwable t) {
                //Toast.makeText(SerchCatecgoryFragment.this.getActivity(),text_catecgory, Toast.LENGTH_SHORT).show();
                Toast.makeText(SerchFileSeminar.this,t+"", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
