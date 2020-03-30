package com.fajri.covid19.info.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fajri.covid19.info.model.Countrymodel;
import com.fajri.covid19.info.api.ApiEndPoint;
import com.fajri.covid19.info.api.ApiService;
import com.fajri.covid19.info.model.Countrymodel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CountryViewModel extends ViewModel {

    private MutableLiveData<Countrymodel> mutableLiveData = new MutableLiveData<>();

    public void setCountryData() {
        Retrofit retrofit = ApiService.getRetrofitService();
        ApiEndPoint apiEndpoint = retrofit.create(ApiEndPoint.class);
        Call<Countrymodel> call = apiEndpoint.getSummaryIdn();
        call.enqueue(new Callback<Countrymodel>() {
            @Override
            public void onResponse(Call<Countrymodel> call, Response<Countrymodel> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Countrymodel> call, Throwable t) {

            }
        });
    }

    public LiveData<Countrymodel> getCountryData() {
        return mutableLiveData;
    }
}





