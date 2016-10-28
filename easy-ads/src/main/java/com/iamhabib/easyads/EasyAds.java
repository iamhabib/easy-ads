package com.iamhabib.easyads;

import android.content.Context;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by HABIB on 10/29/2016.
 */

public class EasyAds {
    public static BuilderBanner forBanner(Context context) {
        return new BuilderBanner(context);
    }

    public static BuilderInterstitial forInterstitial(Context context) {
        return new BuilderInterstitial(context);
    }

    public static class BuilderBanner {
        private int delayTime=0;
        Context context;
        AdView adViewBanner;
        AdRequest.Builder adRequestBuilder;

        private BuilderBanner(Context context) {
            this.context = context;
            adRequestBuilder = new AdRequest.Builder();
        }

        public BuilderBanner banner(AdView adViewBanner){
            this.adViewBanner = adViewBanner;
            return this;
        }

        public BuilderBanner testDevice(String code){
            adRequestBuilder.addTestDevice(code);
            return this;
        }

        public BuilderBanner delay(int timeInMilis){
            this.delayTime=timeInMilis;
            return this;
        }

        public BuilderBanner listener(AdListener adListener){
            adViewBanner.setAdListener(adListener);
            return this;
        }

        public BuilderBanner listener(AdView.OnClickListener clickListener){
            adViewBanner.setOnClickListener(clickListener);
            return this;
        }

        public BuilderBanner show(){
            adViewBanner.loadAd(adRequestBuilder.build());
            return this;
        }

    }

    public static class BuilderInterstitial {
        private int delayTime=0;
        Context context;
        InterstitialAd interstitialAd;
        AdRequest.Builder adRequestBuilder;

        private BuilderInterstitial(Context context) {
            this.context = context;
            interstitialAd=new InterstitialAd(context);
            adRequestBuilder = new AdRequest.Builder();
        }

        public BuilderInterstitial testDevice(String code){
            adRequestBuilder.addTestDevice(code);
            return this;
        }

        public BuilderInterstitial delay(int timeInMilis){
            this.delayTime=timeInMilis;
            return this;
        }

        public BuilderInterstitial listener(AdListener adListener){
            interstitialAd.setAdListener(adListener);
            return this;
        }

        public BuilderInterstitial show(){
            interstitialAd.loadAd(adRequestBuilder.build());
            return this;
        }

    }
}
