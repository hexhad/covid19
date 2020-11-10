package com.hashan.covidapi;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchData extends AsyncTask<Void,Void,Void> {
    String data = "";
    String update_date_time,local_new_cases,local_total_cases,local_total_number_of_individuals_in_hospitals,local_deaths,local_new_deaths,local_recovered,local_active_cases,total_pcr_testing_count;
    @Override
    protected Void doInBackground(Void... voids) {
        
        try {
            URL url = new URL("X");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }
            JSONObject jobj = new JSONObject(data);
            JSONObject dataobj = jobj.getJSONObject("data");
            update_date_time = dataobj.getString("update_date_time");
            local_new_cases = dataobj.getString("local_new_cases");
            local_total_cases = dataobj.getString("local_total_cases");
            local_total_number_of_individuals_in_hospitals = dataobj.getString("local_total_number_of_individuals_in_hospitals");
            local_deaths = dataobj.getString("local_deaths");
            local_new_deaths = dataobj.getString("local_new_deaths");
            local_recovered = dataobj.getString("local_recovered");
            local_active_cases = dataobj.getString("local_active_cases");
            total_pcr_testing_count = dataobj.getString("total_pcr_testing_count");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.update_date_time.setText(this.update_date_time);
        MainActivity.local_new_cases.setText(this.local_new_cases);
        MainActivity.local_total_cases.setText(this.local_total_cases);
        MainActivity.local_total_number_of_individuals_in_hospitals.setText(this.local_total_number_of_individuals_in_hospitals);
        MainActivity.local_deaths.setText(this.local_deaths);
        MainActivity.local_new_deaths.setText(this.local_new_deaths);
        MainActivity.local_recovered.setText(this.local_recovered);
        MainActivity.local_active_cases.setText(this.local_active_cases);
        MainActivity.total_pcr_testing_count.setText(this.total_pcr_testing_count);
    }
}
