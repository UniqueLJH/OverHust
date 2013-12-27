package com.unique.overhust.Feedback;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by fhw on 12/27/13.
 */
public class SendFeedback {
    private String feedbackBody;
    private String feedbackFrom;

    public SendFeedback(String fdBody, String fdFrom) {
        this.feedbackBody = fdBody;
        this.feedbackFrom = fdFrom;
        new SendEmailTask(feedbackBody, feedbackFrom);
    }

    class SendEmailTask extends AsyncTask<Void, Void, Void> {
        private final String subject = "用户反馈";
        private final String recipients = "fanhongweiqq@gmail.com";
        private String mFeedbackBody;
        private String mFeedbackFrom;

        public SendEmailTask(String feedbackBody, String feedbackFrom) {
            this.mFeedbackBody = feedbackBody;
            this.mFeedbackFrom = feedbackFrom;
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                GmailSender sender = new GmailSender("overhustdsnc@gmail.com", "overhust");
                sender.sendMail(subject, mFeedbackBody, mFeedbackFrom, recipients);
            }catch (Exception e){
                Log.e("SendMail", e.getMessage(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result){

        }
    }
}
