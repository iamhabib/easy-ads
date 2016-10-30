package com.iamhabib.easyads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/**
 * Created by HABIB on 10/29/2016.
 */

public class EasyAds {
    static Handler delayHandler = new Handler();
    static Runnable delayRunnable;

    public static Banner forBanner(Context context) {
        return new Banner(context);
    }

    public static Native forNative(Context context) {
        return new Native(context);
    }

    public static Interstitial forInterstitial(Context context) {
        return new Interstitial(context);
    }

    public static class Banner {

        private long delayTime = 0;
        Context context;
        AdView adViewBanner;
        AdRequest.Builder adRequestBuilder;

        private Banner(final Context context) {
            this.context = context;
            adRequestBuilder = new AdRequest.Builder();
        }

        public Banner with(AdView adViewBanner) {
            this.adViewBanner=adViewBanner;
            return this;
        }

        public Banner testDevice(String deviceCode) {
            adRequestBuilder.addTestDevice(deviceCode);
            return this;
        }

        public Banner adUnitId(String adsUnitId) {
            this.adViewBanner.setAdUnitId(adsUnitId);
            return this;
        }

        public Banner adSize(AdSize adSize) {
            this.adViewBanner.setAdSize(adSize);
            return this;
        }

        public Banner playStorePurchaseParams(PlayStorePurchaseListener storePurchaseListener, String s) {
            this.adViewBanner.setPlayStorePurchaseParams(storePurchaseListener, s);
            return this;
        }

        public Banner inAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
            this.adViewBanner.setInAppPurchaseListener(inAppPurchaseListener);
            return this;
        }

        public Banner delay(int timeInMillis) {
            this.delayTime = timeInMillis;
            return this;
        }

        public Banner listener(AdListener adListener) {
            adViewBanner.setAdListener(adListener);
            return this;
        }

        public Banner show() {
            delayRunnable = new Runnable() {
                @Override
                public void run() {
                    if (((Activity) context).isFinishing()) {
                        return;
                    }
                    try {
                        adViewBanner.loadAd(adRequestBuilder.build());
                    } catch (Exception e) {
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            };
            delayHandler.postDelayed(delayRunnable, delayTime);
            return this;
        }

    }

    public static class Native {

        private long delayTime = 0;
        Context context;
        NativeExpressAdView adViewNative;
        AdRequest.Builder adRequestBuilder;

        private Native(final Context context) {
            this.context = context;
            adRequestBuilder = new AdRequest.Builder();
            delayRunnable = new Runnable() {
                @Override
                public void run() {
                    if (((Activity) context).isFinishing()) {
                        return;
                    }
                    try {
                        adViewNative.loadAd(adRequestBuilder.build());
                    } catch (Exception e) {
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            };
        }

        public Native with(NativeExpressAdView adViewNative) {
            this.adViewNative = adViewNative;
            return this;
        }

        public Native testDevice(String code) {
            adRequestBuilder.addTestDevice(code);
            return this;
        }

        public Native adSize(AdSize adSize) {
            this.adViewNative.setAdSize(adSize);
            return this;
        }

        public Native playStorePurchaseParams(PlayStorePurchaseListener storePurchaseListener, String s) {
            this.adViewNative.setPlayStorePurchaseParams(storePurchaseListener, s);
            return this;
        }

        public Native inAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
            this.adViewNative.setInAppPurchaseListener(inAppPurchaseListener);
            return this;
        }

        public Native adUnitId(String adsUnitId) {
            this.adViewNative.setAdUnitId(adsUnitId);
            return this;
        }

        public Native delay(int timeInMillis) {
            this.delayTime = timeInMillis;
            return this;
        }

        public Native listener(AdListener adListener) {
            adViewNative.setAdListener(adListener);
            return this;
        }

        public Native show() {
            delayHandler.postDelayed(delayRunnable, delayTime);
            return this;
        }

    }

    public static class Interstitial {
        private long delayTime = 0;
        private boolean isAddedListener = false;
        Context context;
        static InterstitialAd interstitialAd;
        AdRequest.Builder adRequestBuilder;

        private Interstitial(final Context context) {
            this.context = context;
            interstitialAd = new InterstitialAd(context);
            adRequestBuilder = new AdRequest.Builder();
            delayRunnable = new Runnable() {
                @Override
                public void run() {
                    if (((Activity) context).isFinishing()) {
                        return;
                    }
                    try {
                        interstitialAd.loadAd(adRequestBuilder.build());
                    } catch (Exception e) {
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            };
        }

        public Interstitial testDevice(String deviceCode) {
            adRequestBuilder.addTestDevice(deviceCode);
            return this;
        }

        public Interstitial adUnitId(String adsUnitId) {
            this.interstitialAd.setAdUnitId(adsUnitId);
            return this;
        }

        public Interstitial playStorePurchaseParams(PlayStorePurchaseListener storePurchaseListener, String s) {
            this.interstitialAd.setPlayStorePurchaseParams(storePurchaseListener, s);
            return this;
        }

        public Interstitial inAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
            this.interstitialAd.setInAppPurchaseListener(inAppPurchaseListener);
            return this;
        }

        public Interstitial rewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
            this.interstitialAd.setRewardedVideoAdListener(rewardedVideoAdListener);
            return this;
        }

        public Interstitial delay(int timeInMillis) {
            this.delayTime = timeInMillis;
            return this;
        }

        public Interstitial listener(AdsListener adListener) {
            this.isAddedListener = true;
            interstitialAd.setAdListener(adListener);
            return this;
        }

        public Interstitial show() {
            if (!isAddedListener) {
                interstitialAd.setAdListener(new Interstitial.AdsListener());
            }
            delayHandler.postDelayed(delayRunnable, delayTime);
            return this;
        }

        public static class AdsListener extends AdListener {

            public AdsListener() {
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                interstitialAd.show();
            }
        }
    }
}
