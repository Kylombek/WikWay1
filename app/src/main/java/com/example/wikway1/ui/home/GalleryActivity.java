package com.example.wikway1.ui.home;

import android.os.Bundle;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.wikway1.R;


public class GalleryActivity extends AppCompatActivity {

    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Log.d(TAG, "onCreate: started.");

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("image_url") &&
                getIntent().hasExtra("image_name") &&
                    getIntent().hasExtra("image_artDerStelle")&&
                        getIntent().hasExtra("image_anschreiben")&&
                            getIntent().hasExtra("image_abteilung")&&
                                getIntent().hasExtra("image_qualifizirung")&&
                                    getIntent().hasExtra("image_anforderung")&&
                                        getIntent().hasExtra("image_strasse")&&
                                            getIntent().hasExtra("image_email")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String imageArtDerStelle = getIntent().getStringExtra("image_artDerStelle");
            String imageAnschreiben = getIntent().getStringExtra("image_anschreiben");
            String imageAbteilung = getIntent().getStringExtra("image_abteilung");
            String imageQualifizirung = getIntent().getStringExtra("image_qualifizirung");
            String imageAnforderung = getIntent().getStringExtra("image_anforderung");
            String imageStrasse = getIntent().getStringExtra("image_strasse");
            String imageEmail = getIntent().getStringExtra("image_email");

            setImage(imageUrl, imageName, imageArtDerStelle,
                    imageAnschreiben,imageAbteilung,imageQualifizirung,
                    imageAnforderung,imageStrasse,imageEmail);
        }
    }


    private void setImage(String imageUrl,
                            String imageName,
                                String imageartDerStelle,
                                    String imageAnschreiben,
                                        String imageAbteilung,
                                            String imageQualifizirung,
                                                String imageAnforderung,
                                                    String imageStrasse,
                                                        String imageEmail){
        Log.d(TAG, "setImage: setting te image and name to widgets.");
        //--------------------------------------------------------
        TextView name = findViewById(R.id.image_description);
        TextView artDerStelle = findViewById(R.id.artDerStelleTextView);
        TextView anschreiben = findViewById(R.id.anschreibenTextView);
        TextView abteilung = findViewById(R.id.abteilungTextView);
        TextView qualifizirung = findViewById(R.id.qualifizirungTextView);
        TextView anforderung = findViewById(R.id.anforderungTextView);
        TextView strasse = findViewById(R.id.strasseTextView);
        TextView email = findViewById(R.id.emailTextView);
        //--------------------------------------------------------
        name.setText(imageName);
            artDerStelle.setText(imageartDerStelle);
        anschreiben.setText(imageAnschreiben);
            abteilung.setText(imageAbteilung);
        qualifizirung.setText(imageQualifizirung);
            anforderung.setText(imageAnforderung);
        strasse.setText(imageStrasse);
            email.setText(imageEmail);
        ImageView image = findViewById(R.id.image);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }

}


















