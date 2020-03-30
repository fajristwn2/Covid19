package com.fajri.covid19.info.api;
import com.fajri.covid19.info.model.RiwayatModel;
import com.fajri.covid19.info.model.Countrymodel;
import com.fajri.covid19.info.model.RingkasanModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiEndPoint {


    @GET(Api.END_POINT_WORLD_HISTORY)
    Call<List<RiwayatModel>> getHistoryList(@Path("date") String date);

    @GET(Api.END_POINT_SUMMARY_WORLD)
    Call<RingkasanModel> getSummaryWorld();

    @GET(Api.END_POINT_IDN)
    Call<Countrymodel> getSummaryIdn();

}

