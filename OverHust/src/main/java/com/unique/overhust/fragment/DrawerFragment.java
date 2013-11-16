package com.unique.overhust.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unique.overhust.R;

/**
 * Created by fhw on 11/15/13.
 */
public class DrawerFragment extends Fragment{
    private View drawerView;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        drawerView=inflater.inflate(R.layout.fragment_drawer,null);
        return drawerView;
    }
}
