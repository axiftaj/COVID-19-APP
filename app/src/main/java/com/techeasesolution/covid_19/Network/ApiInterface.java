package com.techeasesolution.covid_19.Network;


import com.techeasesolution.covid_19.Model.GlobalResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("all")
    Call<GlobalResponse>  globalResponse();
}
