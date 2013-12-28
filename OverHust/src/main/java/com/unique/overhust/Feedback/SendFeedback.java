package com.unique.overhust.Feedback;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by fhw on 12/27/13.
 */
public class SendFeedback {
    private String feedbackBody;
    private String feedbackContact;

    public SendFeedback(String fdBody, String fdContact) {
        this.feedbackBody = fdBody;
        this.feedbackContact = fdContact;
        new SendEmailTask(feedbackBody, feedbackContact).execute();
//        try {
//            GmailSender sender = new GmailSender("overhustdsnc@gmail.com", "overhust");
//            sender.sendMail(subject, feedbackBody, feedbackFrom, recipients);
//            Log.e("sendmail", "ok");
//        } catch (Exception e) {
//            Log.e("SendMail", e.getMessage(), e);
//        }
    }

    class SendEmailTask extends AsyncTask<Void, Void, Void> {
        private final String subject = "用户反馈";
        private final String recipients = "overhustdsnc@gmail.com";
        private String mFeedbackBody;
        private String mFeedbackContact;

        public SendEmailTask(String feedbackBody, String feedbackContact) {
            this.mFeedbackBody = feedbackBody;
            this.mFeedbackContact = feedbackContact;
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                GmailSender sender = new GmailSender("overhustdsnc@gmail.com", "overhust");
                sender.sendMail(subject, "反馈内容\n" + mFeedbackBody +"\n"+ "联系方式\n" + mFeedbackContact, recipients, recipients);
            } catch (Exception e) {
                Log.e("SendMail", e.getMessage(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

        }
    }
}
