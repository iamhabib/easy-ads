package com.iamhabib.easyadstest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.NativeExpressAdView;
import com.iamhabib.easyads.EasyAds;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EasyAds.forBanner(this)
                .with((AdView)findViewById(R.id.adView))
                .testDevice("FBDDE95B4A3E5E14648320330112B091")
                .show();
        EasyAds.forNative(MainActivity.this)
                .with((NativeExpressAdView)findViewById(R.id.nativeAds))
                .show();
        EasyAds.forInterstitial(MainActivity.this)
                .delay(30000)
                .listener(new EasyAds.Interstitial.AdsListener(){
                    @Override
                    public void onAdLoaded() {
                        super.onAdLoaded();
                        Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                    }
                })
                .adUnitId(getString(R.string.interstitial_ad_unit_id))
                .testDevice("FBDDE95B4A3E5E14648320330112B091")
                .show();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
