package com.techeasesolution.covid_19;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.techeasesolution.covid_19.Adapter.CountryAdapter;
import com.techeasesolution.covid_19.Model.AllCountriesModel.CountryInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DetailActivity extends AppCompatActivity {

    TextView cases , todayCases , deaths , todayDeaths , recovered , active ,critical , affectedCountries , globalStates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        cases = findViewById(R.id.tvCases);
        todayCases = findViewById(R.id.tvTodaysCases);
        deaths = findViewById(R.id.tvDeaths);
        todayDeaths = findViewById(R.id.tvTodaysDeaths);
        recovered = findViewById(R.id.tvRecovered);
        active = findViewById(R.id.tvActive);
        critical = findViewById(R.id.tvCritical);
        affectedCountries = findViewById(R.id.tvAffectedCountires);
        globalStates = findViewById(R.id.globalStates);

        Intent intent = getIntent();
        String countryName = intent.getStringExtra("countryName");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(countryName);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        globalStates.setText(countryName+" States");

        ApiCall(countryName);
    }

    private void ApiCall(String countryName) {

        String URL = "https://corona.lmao.ninja/v2/countries/"+countryName;

        StringRequest request = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            cases.setText(jsonObject.getString("cases"));
                            todayCases.setText(jsonObject.getString("todayCases"));
                            todayDeaths.setText(jsonObject.getString("todayDeaths"));
                            deaths.setText(jsonObject.getString("deaths"));
                            recovered.setText(jsonObject.getString("recovered"));
                            active.setText(jsonObject.getString("active"));
                            critical.setText(jsonObject.getString("critical"));


                            Log.d("cases" , jsonObject.getString("cases"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DetailActivity.this, ""+error, Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue =  Volley.newRequestQueue(this);


        requestQueue.add(request);

    }

    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(DetailActivity.this , AllCountiresActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        super.onBackPressed();
    }


}
