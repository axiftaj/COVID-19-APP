package com.techeasesolution.covid_19;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
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

import java.util.ArrayList;
import java.util.List;

public class AllCountiresActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<CountryInfo> countryInfoList;
    CountryAdapter countryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_countires);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("All Countries");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        recyclerView = findViewById(R.id.recyclerView);
        countryInfoList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        apiCall();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu , menu);

        MenuItem stSearch = menu.findItem(R.id.search_bar);

        SearchView searchView = (SearchView)stSearch.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                countryAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                countryAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void apiCall() {

        String URL = "https://corona.lmao.ninja/v2/countries";

        StringRequest request = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray = new JSONArray(response);

                            for (int i = 0 ; i < jsonArray.length() ; i ++){

                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String countryname = jsonObject.getString("country");

                                JSONObject jsonObject1 = jsonObject.getJSONObject("countryInfo");
                                String flag = jsonObject1.getString("flag");

                                CountryInfo countryInfo = new CountryInfo(countryname , flag);
                                countryInfoList.add(countryInfo);
                            }

                            countryAdapter = new CountryAdapter(AllCountiresActivity.this , countryInfoList);
                            recyclerView.setAdapter(countryAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AllCountiresActivity.this, ""+error, Toast.LENGTH_SHORT).show();
                 }
        });

     RequestQueue requestQueue =  Volley.newRequestQueue(this);


        requestQueue.add(request);

    }


    public void onContactSelected(CountryInfo contact) {
        Toast.makeText(getApplicationContext(), "Selected: " + contact.getNaem(), Toast.LENGTH_LONG).show();
    }


    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(AllCountiresActivity.this , HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        super.onBackPressed();
    }
}
