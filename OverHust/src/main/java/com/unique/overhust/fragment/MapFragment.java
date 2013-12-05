package com.unique.overhust.fragment;

import android.app.Dialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.tencent.street.StreetThumbListener;
import com.tencent.street.StreetViewListener;
import com.tencent.street.StreetViewShow;
import com.tencent.street.map.basemap.GeoPoint;
import com.tencent.street.overlay.ItemizedOverlay;
import com.unique.overhust.MainActivity.MainActivity;
import com.unique.overhust.MapUtils.OverHustLocation;
import com.unique.overhust.MapUtils.StreetOverlay;
import com.unique.overhust.MapUtils.StreetPoiData;
import com.unique.overhust.R;

import java.util.ArrayList;

/**
 * Created by fhw on 11/17/13.
 */
public class MapFragment extends Fragment implements StreetViewListener {
    private ViewGroup streetView;

    private ImageView streetImageview,mapPreView;
    private ProgressDialog mDialog;

    private Handler mHandler, locationHandler;

    private Context mContext;

    private MainActivity mMainActivity;

    private View mStreetview;
    private View mapView;

    private OverHustLocation mLocation;

    private GeoPoint currentCenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mapView = inflater.inflate(R.layout.fragment_map, null);
        mMainActivity = (MainActivity) getActivity();
        mContext = mMainActivity;
        findViews();
        showDialog();

        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                streetImageview.setImageBitmap((Bitmap) msg.obj);
            }
        };
        mLocation=new OverHustLocation(mContext);
        Log.e("location",""+mLocation.getiLatitu());
        String key = "4fb2821bde027e675565c75b32245ad5";
        currentCenter = new GeoPoint((int) (mLocation.getiLatitu() * 1E6), (int) (mLocation.getiLongti() * 1E6));
        StreetViewShow.getInstance().showStreetView(mContext, currentCenter, 100, this, -170, 0, key);

        return mapView;
    }


    public void findViews() {
        streetView = (FrameLayout) mapView.findViewById(R.id.maplayout);
        streetImageview = (ImageView) mapView.findViewById(R.id.streeview);
        mapPreView=(ImageView)mapView.findViewById(R.id.map_pre);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        StreetViewShow.getInstance().requestStreetThumb(
                "10041002111120153536407",// "10011505120412110900000",
                new StreetThumbListener() {

                    @Override
                    public void onGetThumbFail() {

                    }

                    @Override
                    public void onGetThumb(Bitmap bitmap) {
                        Message msg = new Message();
                        msg.obj = bitmap;
                        mHandler.sendMessage(msg);

                    }
                });
    }

    StreetOverlay overlay;

    @Override
    public ItemizedOverlay getOverlay() {
        if (overlay == null) {
            ArrayList<StreetPoiData> pois = new ArrayList<StreetPoiData>();
            pois.add(new StreetPoiData(39984066, 116307968,
                    getBm(R.drawable.poi_center),
                    getBm(R.drawable.poi_center_pressed), 0));
            pois.add(new StreetPoiData(39984166, 11630800,
                    getBm(R.drawable.pin_green),
                    getBm(R.drawable.pin_green_pressed), 40));
            overlay = new StreetOverlay(pois);
            overlay.populate();
        }
        return overlay;
    }

    private Bitmap getBm(int resId) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inScaled = false;

        return BitmapFactory.decodeResource(getResources(), resId, options);
    }

    @Override
    public void onViewReturn(final View v) {
        mMainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mStreetview = v;
                streetView.addView(mStreetview);
            }
        });
    }

    @Override
    public void onNetError() {
        Log.e("neterror", "onNetError");
        //streetImageview.setImageResource(R.drawable.ic_overhust);
        dismissDialog();
        mapPreView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDataError() {
        dismissDialog();
        Log.e("dataerror", "onDataError");
        String key = "4fb2821bde027e675565c75b32245ad5";
        currentCenter = new GeoPoint((int) (mLocation.getiLatitu() * 1E6), (int) (mLocation.getiLongti() * 1E6));
        StreetViewShow.getInstance().showStreetView(mContext, currentCenter, 100, this, -170, 0, key);
    }

    @Override
    public void onLoaded() {
        mapPreView.setVisibility(View.INVISIBLE);
        dismissDialog();
        mMainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mStreetview.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onAuthFail() {
        // LogUtil.logStreet("onAuthFail");
    }

    //加载progressDialog
    public Dialog showDialog(){
        mDialog=new ProgressDialog(mContext);
        mDialog.setTitle("OverHust");
        mDialog.setMessage("正在加载街景...");
        mDialog.setIndeterminate(true);
        mDialog.setCancelable(true);
        mDialog.show();

        return mDialog;
    }

    //销毁progressDialog
    public void dismissDialog(){
        mDialog.dismiss();
    }
}
