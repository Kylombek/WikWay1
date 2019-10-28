package com.example.wikway1.ui.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wikway1.JobAd;
import com.example.wikway1.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class VacancyAdapter extends RecyclerView.Adapter<VacancyAdapter.VacancyViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<JobAd> jobs;

    VacancyAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public VacancyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.vacancy_item, parent, false);
        return new VacancyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VacancyViewHolder holder, int position) {
        holder.setData(jobs.get(position));
    }

    @Override
    public int getItemCount() {
        if (jobs == null) return 0;
        return jobs.size();
    }

    public void setJobs(ArrayList<JobAd> jobs) {
        this.jobs = jobs;
        notifyDataSetChanged();
    }

    class VacancyViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imageView;
        TextView jobTitleTextView;
        VacancyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.companyLogoInList);
            jobTitleTextView = itemView.findViewById(R.id.jobNameTextView);
        }

        void setData(JobAd job) {
            Glide.with(context)
                    .asBitmap()
                    .load(job.imageLink)
                    .into(imageView);
            jobTitleTextView.setText(job.title);
        }
    }
}
