package com.palapol.tsp_sesaminar_team02.remote;

import com.palapol.tsp_sesaminar_team02.model.SeminarGroupObj;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SeminarGroupService {
    @GET("index.php/sam/Group/SeminarGroupDataJsonService/{gp_master}")
    Call<SeminarGroupObj> GetData(@Path("gp_master") String gp_master);
}
