package com.change.guideforzoom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.appbrain.AdId;
import com.appbrain.InterstitialBuilder;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private ImageButton imageButton;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private InterstitialBuilder interstitialBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        interstitialBuilder = InterstitialBuilder.create()
                .setAdId(AdId.LEVEL_COMPLETE)
                .preload(this);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-4006728735427748/9401069143");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        ImageButton butabout= (ImageButton) findViewById(R.id.about);
        ImageButton butlaunch= (ImageButton)  findViewById(R.id.After_launch);
        ImageButton butmobileapp= (ImageButton)  findViewById(R.id.destop_mobileapp);
        ImageButton butstart= (ImageButton) findViewById(R.id.starting);
        ImageButton butbefore= (ImageButton) findViewById(R.id.beforemeeting);
        ImageButton butduring= (ImageButton) findViewById(R.id.duringMeeting);
        ImageButton butstarting= (ImageButton) findViewById(R.id.startingmeeting);



        butabout.setOnClickListener(this);
        butlaunch.setOnClickListener(this);
        butmobileapp.setOnClickListener(this);
        butstart.setOnClickListener(this);
        butbefore.setOnClickListener(this);
        butduring.setOnClickListener(this);
        butstarting.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.about:
                Intent intent = new Intent(this, About_Zoom.class);
                startActivity(intent);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    interstitialBuilder.show(this);
                }
                break;
            case R.id.starting:
                Intent intstarting = new Intent(this, Launching_Zoom.class);
                startActivity(intstarting);

                break;
            case R.id.startingmeeting:
                Intent intstart = new Intent(this, Start_Meeting.class);
                startActivity(intstart);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    interstitialBuilder.show(this);
                }
                break;
            case R.id.destop_mobileapp:
                Intent intdesktop = new Intent(this, Find_Desktop_App.class);
                startActivity(intdesktop);

                break;

            case R.id.duringMeeting:
                Intent intduring = new Intent(this, During_Meetinf.class);
                startActivity(intduring);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    interstitialBuilder.show(this);
                }
                break;
            case R.id.beforemeeting:
                Intent intbefore = new Intent(this, Before_Meeting.class);
                startActivity(intbefore);
                if (!interstitialBuilder.show(this)) {
                    super.onBackPressed();
                }
                break;
            case R.id.After_launch:
                Intent intlaunch = new Intent(this, After_Launch.class);
                startActivity(intlaunch);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    interstitialBuilder.show(this);
                }
                break;


        }

    }
}