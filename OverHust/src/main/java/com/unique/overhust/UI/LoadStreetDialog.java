package com.unique.overhust.UI;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.unique.overhust.R;

/**
 * Created by fhw on 1/4/14.
 */
public class LoadStreetDialog extends Dialog{

    public LoadStreetDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_street_dialog);

    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    @Override
    public void show() {
        super.show();
    }
}
