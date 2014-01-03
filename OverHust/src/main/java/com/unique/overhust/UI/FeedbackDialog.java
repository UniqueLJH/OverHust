package com.unique.overhust.UI;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.devspark.appmsg.AppMsg;
import com.unique.overhust.Feedback.SendFeedback;
import com.unique.overhust.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by fhw on 1/3/14.
 */
public class FeedbackDialog extends Dialog {
    private ImageView fdCommit, fdCancel;
    private EditText fdDetails, fdContact;

    private Activity mActivity;

    public FeedbackDialog(Activity activity, int theme) {
        super(activity, theme);
        this.mActivity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_dialog);

        fdCommit = (ImageView) findViewById(R.id.feedback_commit);
        fdCancel = (ImageView) findViewById(R.id.feedback_cancel);
        fdDetails = (EditText) findViewById(R.id.feedback_details);
        fdContact = (EditText) findViewById(R.id.feedback_contact);

        fdCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commitFeedback();
                if(commitFeedback()==true){
                    dismiss();
                }else{

                }
            }
        });
        fdCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    public boolean commitFeedback() {
        String feedbackBody = fdDetails.getText().toString();
        String feedbackContact = fdContact.getText().toString();
        if (feedbackBody.equals("")) {
            AppMsg appMsg = AppMsg.makeText(mActivity, "请输入反馈内容", new AppMsg.Style(AppMsg.LENGTH_SHORT, R.color.alert), R.layout.appmsg_red);
            appMsg.setLayoutGravity(Gravity.TOP);
            appMsg.show();
            return false;
        } else {
            SendFeedback mSendFeedback = new SendFeedback(feedbackBody, feedbackContact, 1);
            AppMsg appMsg = AppMsg.makeText(mActivity, "谢谢您的反馈", new AppMsg.Style(2000, R.color.overhust), R.layout.appmsg_green);
            appMsg.setLayoutGravity(Gravity.TOP);
            appMsg.show();
            return true;
        }
    }
}
