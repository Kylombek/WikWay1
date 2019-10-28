package com.example.wikway1.ui.saved;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wikway1.JobAd;
import com.example.wikway1.R;
import com.example.wikway1.ui.home.HomeFragment;
import com.example.wikway1.utils.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;


public class SavedFragment extends Fragment {
    //private static final String TAG = "JobListView";
    public  ArrayList<JobAd> fav;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saved, container, false);
        fav = new ArrayList<>();
        ArrayList<JobAd> arr = fav;
        ListView listView = view.findViewById(R.id.recycler_view1);
        ArrayAdapter<JobAd> listViewAdapter = new ArrayAdapter<JobAd>(
                getActivity(),
                R.layout.fragment_saved,
                arr
        );
        listView.setAdapter(listViewAdapter);
        return view;
    }

}