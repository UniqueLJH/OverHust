package com.unique.overhust.MapUtils;


import android.app.Fragment;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;


import com.unique.overhust.fragment.MapFragment;


/**
 * Created by fhw on 11/20/13.
 */
public class OverHustLocation {
    private LocationManager locManager = null;
    private LocationListener locListener = null;

    private double iLongti, iLatitu;

    private Location mLocation;
    private Context mContext;

    private MapFragment mMapFragment;

    public OverHustLocation(Context context) {
        this.mContext = context;
    }

    public void getLocation() {
        if (locManager == null) {

            /*locListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    if (location == null) {
                        return;
                    }
                    iLatitu = location.getLatitude();
                    iLongti = location.getLongitude();
                    Log.e("haha", String.valueOf(iLatitu));

                    setiLatitu(iLatitu);
                    setiLongti(iLongti);
                }
            };
            locManager = LocationManager.getInstance();
            locManager.requestLocationUpdates(locListener);
            locManager.enableProvider(mContext);*/

            //查找到服务信息
            /*Criteria mCriteria = new Criteria();
            mCriteria.setAccuracy(Criteria.ACCURACY_FINE);  //高精度
            mCriteria.setAltitudeRequired(false);
            mCriteria.setBearingRequired(false);
            mCriteria.setCostAllowed(true);
            mCriteria.setPowerRequirement(Criteria.POWER_LOW);  //低功耗
            String provider = locManager.getBestProvider(mCriteria, true);      //获取gps信息*/

            locManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
            if (locManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                Log.e("gps", "ok");
                //gps定位
                locListener = new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        if (location == null) {
                            return;
                        }
                        iLatitu = location.getLatitude();
                        iLongti = location.getLongitude();
                        Log.e("listener", String.valueOf(iLatitu));
                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras) {

                    }

                    @Override
                    public void onProviderEnabled(String provider) {

                    }

                    @Override
                    public void onProviderDisabled(String provider) {

                    }
                };
                //locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 0, locListener);
                mLocation = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (mLocation != null) {
                    iLongti = mLocation.getLongitude();
                    iLatitu = mLocation.getLatitude();
                }
                if (mLocation == null && locManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                    Log.e("network", "ok");
                    locManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, locListener);
                    mLocation = locManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    if (mLocation != null) {
                        iLatitu = mLocation.getLatitude();
                        iLongti = mLocation.getLongitude();
                    }
                }
            } else {
                Log.e("network", "ok");
                locListener = new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        if (location == null) {
                            return;
                        }
                        iLatitu = location.getLatitude();
                        iLongti = location.getLongitude();
                        Log.e("listener", String.valueOf(iLatitu));
                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras) {

                    }

                    @Override
                    public void onProviderEnabled(String provider) {

                    }

                    @Override
                    public void onProviderDisabled(String provider) {

                    }
                };
                locManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, locListener);
                mLocation = locManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                if (mLocation != null) {
                    iLatitu = mLocation.getLatitude();
                    iLongti = mLocation.getLongitude();
                }
            }
            Log.e("lo", String.valueOf(mLocation));
        }


    }

    //获得经度值
    public double getiLongti() {
        //Log.e("get", "" + iLongti);
        return iLongti;
    }

    //获得维度值
    public double getiLatitu() {
        return this.iLatitu;
    }

}
