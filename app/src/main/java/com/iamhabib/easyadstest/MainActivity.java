package com.iamhabib.easyadstest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdView;
import com.iamhabib.easyads.EasyAds;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EasyAds.forBanner(this)
                .banner((AdView)findViewById(R.id.adView))
                .show();
        EasyAds.forInterstitial(this)
                .listener(new AdListener() {
                    @Override
                    public void onAdLoaded() {
                        super.onAdLoaded();
                    }
                })
                .show();
    }
}
