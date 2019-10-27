package com.example.wikway1.utils;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.wikway1.R;
import com.example.wikway1.ui.home.GalleryActivity;

import java.util.ArrayList;



public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>  {
    public static final String TAG= "RecyclerViewAdapter";

    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mJobNamesText = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> mImages, ArrayList<String> mJobNamesText, Context mContext) {
        this.mImages = mImages;
        this.mJobNamesText = mJobNamesText;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(mContext)
                .asBitmap().load(mImages.get(position))
                .into(holder.logoImage);
        holder.textView.setText(mJobNamesText.get(position));
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,mJobNamesText.get(position),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, GalleryActivity.class);
                intent.putExtra("image_url", mImages.get(position));
                intent.putExtra("image_name", mJobNamesText.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mJobNamesText.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView logoImage;
        TextView textView;
        RelativeLayout relativeLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            logoImage = itemView.findViewById(R.id.companyLogoInList);
            textView = itemView.findViewById(R.id.jobNameTextView);
            relativeLayout = itemView.findViewById(R.id.parent_layout);

        }
    }
}
