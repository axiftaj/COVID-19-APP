package com.techeasesolution.covid_19;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.techeasesolution.covid_19.Model.GlobalResponse;
import com.techeasesolution.covid_19.Network.ApiClientPrivate;
import com.techeasesolution.covid_19.Network.ApiInterface;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeActivity extends AppCompatActivity {

    //init
    TextView cases , todayCases , deaths , todayDeaths , recovered , active ,critical , affectedCountries;
    Button contrytacker;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        cases = findViewById(R.id.tvCases);
        todayCases = findViewById(R.id.tvTodaysCases);
        deaths = findViewById(R.id.tvDeaths);
        todayDeaths = findViewById(R.id.tvTodaysDeaths);
        recovered = findViewById(R.id.tvRecovered);
        active = findViewById(R.id.tvActive);
        critical = findViewById(R.id.tvCritical);
        affectedCountries = findViewById(R.id.tvAffectedCountires);
        contrytacker = findViewById(R.id.contrytacker);

        contrytacker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this , AllCountiresActivity.class));
            }
        });

        apiCall();


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void apiCall() {

        ApiInterface apiInterface = null ;
        apiInterface = ApiClientPrivate.getApiClient().create(ApiInterface.class);

        Call<GlobalResponse> call = apiInterface.globalResponse();

        call.enqueue(new Callback<GlobalResponse>() {
            @Override
            public void onResponse(Call<GlobalResponse> call, Response<GlobalResponse> response) {

                if (response.isSuccessful()){

                    String stCase = String.valueOf(response.body().getCases());
                    String sttodayCases = String.valueOf(response.body().getTodayCases());
                    String stDeaths = String.valueOf(response.body().getDeaths());
                    String stTodasDeath = String.valueOf(response.body().getTodayDeaths());
                    String stRecocered = String.valueOf(response.body().getRecovered());
                    String stActive = String.valueOf(response.body().getActive());
                    String stCritical = String.valueOf(response.body().getCritical());
                    String stCountires = String.valueOf(response.body().getAffectedCountries());

                    cases.setText(stCase);
                    todayCases.setText(sttodayCases);
                    deaths.setText(stDeaths);
                    todayDeaths.setText(stTodasDeath);
                    recovered.setText(stRecocered);
                    active.setText(stActive);
                    critical.setText(stCritical);
                    affectedCountries.setText(stCountires);
             
                }
            }

            @Override
            public void onFailure(Call<GlobalResponse> call, Throwable t) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
