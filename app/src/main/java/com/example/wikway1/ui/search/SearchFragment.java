package com.example.wikway1.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wikway1.App;
import com.example.wikway1.JobAd;
import com.example.wikway1.R;

import java.util.ArrayList;


public class SearchFragment extends Fragment {

    private EditText searchEditText;
    private Spinner spinner;
    private Button button;
    private RecyclerView rv;
    private VacancyAdapter vacancyAdapter;
    private App.OnDataReadyListener onDataReadyListener;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

       View v = inflater.inflate(R.layout.fragment_search, container, false);
        initViews(v);
        getJobs();
       return v;
    }

    private void initViews(View v) {
        searchEditText = v.findViewById(R.id.search_input);
        spinner = v.findViewById(R.id.category_spinner);
        button = v.findViewById(R.id.search_button);
        rv = v.findViewById(R.id.rv);
        initRV();
    }

    private void initRV() {
        vacancyAdapter = new VacancyAdapter(getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(vacancyAdapter);
    }

    private void getJobs() {
        onDataReadyListener = new App.OnDataReadyListener() {
            @Override
            public void setData(ArrayList<JobAd> jobs) {
                vacancyAdapter.setJobs(App.jobAds);
            }
        };
        App.setOnDataReadyListener(onDataReadyListener);
        App.parseJobs();
    }
}