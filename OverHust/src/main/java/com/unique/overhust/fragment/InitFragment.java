package com.unique.overhust.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unique.overhust.MainActivity.MainActivity;
import com.unique.overhust.R;

/**
 * Created by fhw on 12/1/13.
 */
public class InitFragment extends Fragment {
    private View initView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initView = inflater.inflate(R.layout.fragment_init, null);
        return initView;
    }

}
