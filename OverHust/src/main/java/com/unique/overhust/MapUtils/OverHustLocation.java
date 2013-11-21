package com.unique.overhust.MapUtils;

import android.location.Location;

import com.tencent.mapapi.map.LocationListener;
import com.tencent.mapapi.map.LocationManager;

/**
 * Created by fhw on 11/20/13.
 */
public class OverHustLocation {
    private LocationManager locManager = null;
    private LocationListener locListener = null;

    private double iLongti, iLatitu;

    public OverHustLocation() {
        locManager = LocationManager.getInstance();
        locManager.requestLocationUpdates(locListener);

        locListener=new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                if(location==null){
                    return;
                }

                iLongti=location.getLongitude();
                iLatitu=location.getLatitude();
            }
        };
    }

    //获得经度值
    public double getiLongti() {
        return iLongti;
    }

    //获得维度值
    public double getiLatitu() {
        return iLatitu;
    }
}
