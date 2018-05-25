package com.palapol.tsp_sesaminar_team02;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.palapol.tsp_sesaminar_team02.model.SeminarGroupObj;
import com.palapol.tsp_sesaminar_team02.remote.SeminarGroupService;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A SeminarGroup {@link Fragment} subclass.
 */
//@SuppressLint("ValidFragment")
public class SeminarGroupFragment extends Fragment {

    private ArrayList<String> seminar_group_data = new ArrayList<>();

//    @SuppressLint("ValidFragment")
//    public SeminarGroupFragment(String gp_master_con) {
//        gp_master = gp_master_con;
//    }

    public SeminarGroupFragment (){}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_seminar_group, container, false);
        String gp_master = "305";
        GetSeminarGroupData(gp_master, v);
        return v;
    }

    public class SeminarGroupAdapter extends RecyclerView.Adapter<SeminarGroupAdapter.CustomViewHolder> {

        private ArrayList<String> dataList;

        SeminarGroupAdapter(ArrayList<String> dataList){
            this.dataList = dataList;
        }

        class CustomViewHolder extends RecyclerView.ViewHolder {

            final View mView;

            TextView txtTitle;

            CustomViewHolder(View itemView) {
                super(itemView);
                mView = itemView;
                txtTitle = mView.findViewById(R.id.seminar_group_text_view);
            }
        }

        @NonNull
        @Override
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.recycleview_seminar_group, parent, false);
            return new CustomViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
            holder.txtTitle.setText(dataList.get(position));
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }
    }

    private void GetSeminarGroupData(final String gp_master, final View v){
        OkHttpClient okHttpClient = com.kingkarn.projectbeaconapplication.UnsafeOkHttpClient.getUnsafeOkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://se.informatics.buu.ac.th/seminar/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SeminarGroupService seminar_group_service = retrofit.create(SeminarGroupService.class);
        seminar_group_service.GetData(gp_master).enqueue(new Callback<SeminarGroupObj>() {
            @Override
            public void onResponse(@NonNull Call<SeminarGroupObj> call, @NonNull Response<SeminarGroupObj> response) {
                if (response.isSuccessful()){
                    SeminarGroupObj resObj = response.body();
                    assert resObj != null;
                    seminar_group_data = resObj.GetStudentCodeAndName();
                    System.out.println("Response = "+ response);
                    System.out.println("Response = "+ response.body());
                    System.out.println("Response = "+ seminar_group_data);
                    RecyclerView mRecyclerView = v.findViewById(R.id.seminar_group_recycler_view);
                    mRecyclerView.setHasFixedSize(true);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
                    mRecyclerView.setLayoutManager(mLayoutManager);
                    RecyclerView.Adapter mAdapter = new SeminarGroupAdapter(seminar_group_data);
                    mRecyclerView.setAdapter(mAdapter);
                }
            }
            @Override
            public void onFailure(@NonNull Call<SeminarGroupObj> call, @NonNull Throwable t) {
//                Toast.makeText(MainLogin.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}