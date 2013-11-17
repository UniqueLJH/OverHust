package com.unique.overhust.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.unique.overhust.MainActivity.MainActivity;
import com.unique.overhust.R;

/**
 * Created by fhw on 11/15/13.
 */
public class DrawerFragment extends Fragment {

    private View drawerView;
    private ImageView map, navigation, search, schoolbus;
    private MainActivity mMainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mMainActivity = (MainActivity) getActivity();
        drawerView = inflater.inflate(R.layout.fragment_drawer, null);
        findViews();

        //按钮监听
        map.setOnClickListener(new MyOnClickListener());
        navigation.setOnClickListener(new MyOnClickListener());
        search.setOnClickListener(new MyOnClickListener());
        schoolbus.setOnClickListener(new MyOnClickListener());

        return drawerView;
    }

    public void findViews() {
        map = (ImageView) drawerView.findViewById(R.id.map);
        navigation = (ImageView) drawerView.findViewById(R.id.navigation);
        search = (ImageView) drawerView.findViewById(R.id.search);
        schoolbus = (ImageView) drawerView.findViewById(R.id.schoolbus);
    }

    class MyOnClickListener implements View.OnClickListener {

        FragmentManager fragmentManager = getFragmentManager();

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.map:
                    MapFragment mMapFragment = new MapFragment();
                    FragmentTransaction mapTransaction = fragmentManager.beginTransaction();
                    mapTransaction.replace(R.id.content_frame, mMapFragment);
                    mapTransaction.commit();
                    mMainActivity.closeDrawer();
                    break;
                case R.id.navigation:
                    NavitationFragment mNavitationFragment = new NavitationFragment();
                    FragmentTransaction navigationTransaction = fragmentManager.beginTransaction();
                    navigationTransaction.replace(R.id.content_frame, mNavitationFragment);
                    navigationTransaction.commit();
                    mMainActivity.closeDrawer();
                    break;
                case R.id.schoolbus:
                    SchoolbusFragment mSchoolbusFragment = new SchoolbusFragment();
                    FragmentTransaction schoolbusTransaction = fragmentManager.beginTransaction();
                    schoolbusTransaction.replace(R.id.content_frame, mSchoolbusFragment);
                    schoolbusTransaction.commit();
                    mMainActivity.closeDrawer();
                    break;
                case R.id.search:
                    SearchFragment mSearchFragment = new SearchFragment();
                    FragmentTransaction searchTransaction = fragmentManager.beginTransaction();
                    searchTransaction.replace(R.id.content_frame, mSearchFragment);
                    searchTransaction.commit();
                    mMainActivity.closeDrawer();
                    break;
                default:
                    break;
            }
        }
    }

}
