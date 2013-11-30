package com.unique.overhust.MapUtils;

import android.app.Service;
import android.content.Context;
import android.os.Vibrator;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

/**
 * Created by fhw on 11/30/13.
 */
public class DsncLocation {
    private double mLongitude, mLatitude;

    private Context mContext;
    private LocationClient mLocationClient = null;
    private BDLocationListener myListener;
    private Vibrator mVibrator = null;

    public DsncLocation(Context context) {
        this.mContext = context;
    }

    public void getLocation() {
        myListener = new BDLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation location) {
                if (location == null) {
                    return;
                }
                mLatitude = location.getLatitude();
                mLongitude = location.getLongitude();
            }

            @Override
            public void onReceivePoi(BDLocation poiLocation) {
                if (poiLocation == null) {
                    return;
                }
            }
        };

        mLocationClient = new LocationClient(mContext);
        mLocationClient.setLocOption(this.getLocationOption());
        mLocationClient.registerLocationListener(myListener);
        mLocationClient.start();
        mLocationClient.requestLocation();

        mVibrator = (Vibrator) mContext.getSystemService(Service.VIBRATOR_SERVICE);
    }

    public double getLongitude() {
        return mLongitude;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public LocationClientOption getLocationOption() {
        LocationClientOption option = new LocationClientOption();
        option.disableCache(false);
        option.setOpenGps(true);
        option.setScanSpan(1000);
        option.setPriority(LocationClientOption.GpsFirst);
        option.disableCache(false);
        return option;
    }


}
