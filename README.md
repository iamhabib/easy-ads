# Easy Ads [ ![Download](https://api.bintray.com/packages/osongae2/maven/easy-ads/images/download.svg) ](https://bintray.com/osongae2/maven/easy-ads/_latestVersion) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-EasyAds-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/4576)
-------------------

Easy way to show AdMob ads in Android.

##Usage
-----------

Add below line in app ```build.gradle```
 
```gradle
dependencies {
	compile 'com.iamhabib:easy-ads:1.0.1'
}
```

##Code snippets
---------------

Show Banner, Native, Interstitial Ad by using those minimal code:

### Banner ###
```groovy
EasyAds.forBanner(getApplicationContext())
                .with((AdView)findViewById(R.id.adView))
                .testDevice("FBDDE95B4A3E5E14648320330112B091")
                .show();
```

#### Native ###
```groovy
EasyAds.forNative(getApplicationContext())
                .with((NativeExpressAdView)findViewById(R.id.nativeAds))
                .show();
```

### Interstitial ###
```groovy
EasyAds.forInterstitial(getApplicationContext())
                .delay(30000)
                .listener(new EasyAds.Interstitial.AdsListener(){
                    @Override
                    public void onAdLoaded() {
                        super.onAdLoaded();
                        Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_SHORT).show();
                    }
                })
                .adUnitId(getString(R.string.interstitial_ad_unit_id))
                .testDevice("FBDDE95B4A3E5E14648320330112B091")
                .show();
```

##License

Copyright 2016 Habibur Rahman

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
