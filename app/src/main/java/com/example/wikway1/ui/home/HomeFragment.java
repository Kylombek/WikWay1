package com.example.wikway1.ui.home;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wikway1.JobAd;
import com.example.wikway1.R;
import com.example.wikway1.utils.HttpHandler;
import com.example.wikway1.utils.RecyclerViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    public static final String TAG = "JobListView";
    public static final String API_WIKWAY = "https://www.wikway.de/companies/offers-json?password=ain1018";
    public static HomeFragment instance;
    //vars
    public static ArrayList<JobAd> jobAds;
    public static ArrayList<JobAd> fav;
    public static InitImageBitmaps initialization;

    public static HomeFragment getInstance(){
        if(instance==null)
            instance = new HomeFragment();
        return instance;
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: started.");
        jobAds = new ArrayList<>();
        fav = new ArrayList<>();
        if (initialization == null){
            initialization = new InitImageBitmaps();
             }
        initialization.execute();
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    private class InitImageBitmaps extends AsyncTask<Void, Void, Void> {
        protected Void doInBackground(Void... arg0) {

                HttpHandler sh = new HttpHandler();
                // Making a request to url and getting response

                String jsonStr = sh.makeServiceCall(API_WIKWAY);
                if (jsonStr != null) {

                        try {
                            JSONArray companies = new JSONArray(jsonStr);
                        for (int i = 0; i < companies.length(); i++) {
                            JSONObject c = companies.getJSONObject(i);
                            String jobName = c.getString("Bezeichnung der Stelle");
                            String logo = c.getString("Logo");
                            Log.d(TAG, "AAAAAAAAAAAAAAAAAAAAAAAAAAA" + jobName);
                            jobAds.add(new JobAd(jobName,logo));
//                            if(i==3){
//                                fav.add(new JobAd(jobName,logo));
//                            }
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            initRecyclerView();
        }
    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = getView().findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(jobAds, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}