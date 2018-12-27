package io.callstack.react.fbads;

import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdsManager;
import com.facebook.ads.AdChoicesView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewGroup;

public class AdChoicesIconView extends ReactViewGroup {
    private AdChoicesView mAdChoicesView;
    private ReactContext mContext;

    public AdChoicesIconView(ThemedReactContext context) {
        super(context);
        mContext = context;
    }

    public void setPlacementId(String placementId) {
        NativeAdManager libAdManager = mContext.getNativeModule(NativeAdManager.class);
        NativeAdsManager adsManager = libAdManager.getFBAdsManager(placementId);
        NativeAd nativeAd = adsManager.nextNativeAd();

        if (nativeAd != null) {
            mAdChoicesView = new AdChoicesView(mContext, adsManager.nextNativeAd(), true);
            mAdChoicesView.measure(mAdChoicesView.getMeasuredWidth(), mAdChoicesView.getMeasuredHeight());
            mAdChoicesView.layout(0, 0, mAdChoicesView.getMeasuredWidth(), mAdChoicesView.getMeasuredHeight());
            mAdChoicesView.bringToFront();
            addView(mAdChoicesView);
        }
    }
}
