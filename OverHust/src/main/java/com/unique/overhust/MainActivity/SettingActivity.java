package com.unique.overhust.MainActivity;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.devspark.appmsg.AppMsg;
import com.unique.overhust.Feedback.SendFeedback;
import com.unique.overhust.R;

import java.util.Timer;
import java.util.TimerTask;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class SettingActivity extends SwipeBackActivity {

    //控制滑动返回的边缘大小
    private static final int EDGE_SIZE = 100;

    private ImageView settingBackView;
    private ImageView feedbackView;

    private MainActivity mMainActivity;
    private SwipeBackLayout mSwipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        findViews();
        viewOnClick();
//        if (savedInstanceState == null) {
//            getFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment())
//                    .commit();
//        }
        settingBackView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //左侧滑动返回
        mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        mSwipeBackLayout.setEdgeSize(EDGE_SIZE);
    }

    public void findViews() {
        settingBackView = (ImageView) findViewById(R.id.settingback);
        feedbackView = (ImageView) findViewById(R.id.feedback);
    }

    public void viewOnClick() {
        feedbackView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFeedbackAlert();
            }
        });
    }

    public void showFeedbackAlert() {
        LayoutInflater factory = LayoutInflater.from(getApplicationContext());
        final View feedbackView = factory.inflate(R.layout.alert_dialog_feedback, null);
        new AlertDialog.Builder(SettingActivity.this)
                .setTitle(R.string.alert_dialog_feedback)
                .setView(feedbackView)
                .setCancelable(false)
                .setPositiveButton(R.string.alert_dialog_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        commitFeedback(feedbackView);
                    }
                })
                .setNegativeButton(R.string.alert_dialog_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create().show();
    }

    public void commitFeedback(View feedbackView) {
        EditText feedbackEditText = (EditText) feedbackView.findViewById(R.id.feedback);
        EditText contactEditText = (EditText) feedbackView.findViewById(R.id.contact);
        String feedbackBody = feedbackEditText.getText().toString();
        String feedbackContact = contactEditText.getText().toString();
        if (feedbackBody.equals("")) {
            AppMsg appMsg = AppMsg.makeText(this, "请输入反馈内容", new AppMsg.Style(AppMsg.LENGTH_SHORT, R.color.alert));
            appMsg.setLayoutGravity(Gravity.TOP);
            appMsg.show();
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showFeedbackAlert();
                        }
                    });
                }
            }, 500);
        } else {
            SendFeedback mSendFeedback = new SendFeedback(feedbackBody, feedbackContact);
            AppMsg appMsg = AppMsg.makeText(this, "谢谢您的反馈", new AppMsg.Style(2000, R.color.overhust));
            appMsg.setLayoutGravity(Gravity.TOP);
            appMsg.show();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        AppMsg appMsg = AppMsg.makeText(this, "左滑返回", new AppMsg.Style(AppMsg.LENGTH_SHORT, R.color.overhust));
        appMsg.setLayoutGravity(Gravity.BOTTOM);
        appMsg.show();
        return false;
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
            View rootView = inflater.inflate(R.layout.fragment_setting, container, false);
            return rootView;
        }
    }


//    @Override
//    public boolean onKeyDown(int keyCode,KeyEvent event){
//        if(keyCode==KeyEvent.KEYCODE_BACK){
////            Intent meIntent=new Intent(this,MainActivity.class);
////            startActivity(meIntent);
//            finish();
//
//        }
//        return false;
//    }
}
