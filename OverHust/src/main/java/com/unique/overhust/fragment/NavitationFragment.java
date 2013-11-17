package com.unique.overhust.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unique.overhust.R;

/**
 * Created by fhw on 11/17/13.
 */
public class NavitationFragment extends Fragment{
    private View navigationView;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        navigationView =inflater.inflate(R.layout.fragment_navitation,null);
        return navigationView;
    }
}
