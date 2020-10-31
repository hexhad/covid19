package com.hashan.covidapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    public static TextView update_date_time,local_new_cases,local_total_cases,local_total_number_of_individuals_in_hospitals,local_deaths,local_new_deaths,local_recovered,local_active_cases,total_pcr_testing_count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

        update_date_time = findViewById(R.id.update_date_time);
        local_new_cases = findViewById(R.id.local_new_cases);
        local_total_cases = findViewById(R.id.local_total_cases);
        local_total_number_of_individuals_in_hospitals = findViewById(R.id.local_total_number_of_individuals_in_hospitals);
        local_deaths = findViewById(R.id.local_deaths);
        local_new_deaths = findViewById(R.id.local_new_deaths);
        local_recovered = findViewById(R.id.local_recovered);
        local_active_cases = findViewById(R.id.local_active_cases);
        total_pcr_testing_count = findViewById(R.id.total_pcr_testing_count);

        process();
    }


    private void process() {
        fetchData process = new fetchData();
        process.execute();
    }
}