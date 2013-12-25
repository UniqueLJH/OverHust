package com.unique.overhust.MainActivity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aphidmobile.flip.FlipViewController;
import com.unique.overhust.FirstInto.GuideAdapter;
import com.unique.overhust.MapUtils.OverHustLocation;
import com.unique.overhust.R;

import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends Activity {

    private ImageView startView;

    private OverHustLocation mOverHustLocation;

    private boolean isFirstIn;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences = getSharedPreferences("OverHust", MODE_PRIVATE);
        isFirstIn = preferences.getBoolean("isFirstIn", true);

        if (!isFirstIn) {
            noFirstUse();
        } else {
            FlipViewController flipView = new FlipViewController(this, FlipViewController.HORIZONTAL);
            flipView.setAdapter(new GuideAdapter(this));
            setContentView(flipView);
            flipView.setOnViewFlipListener(new FlipViewController.ViewFlipListener() {
                @Override
                public void onViewFlipped(View view, int i) {
                    if (i == 3) {
                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        noFirstUse();
                                    }
                                });
                            }
                        }, 500);
                    }
                }
            });
            updateIsFirstIn();
        }
    }

    public void noFirstUse() {
        setContentView(R.layout.activity_start);
        startView = (ImageView) findViewById(R.id.start);
        startView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(startIntent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void updateIsFirstIn() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isFirstIn", false);
        editor.commit();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_start, container, false);
            return rootView;
        }
    }

}
