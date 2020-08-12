package com.codelab.archangel.simpleasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {

    /*
    If you pass a TextView into the AsyncTask constructor and then store it in a member variable,
     that reference to the TextView means the Activity cannot ever be garbage collected
      and thus leaks memory, even if the Activity is destroyed and recreated
       as in a device configuration change. This is called creating a leaky context,
        and Android Studio will warn you if you try it.

The weak reference prevents the memory leak by allowing the object held by that
 reference to be garbage collected if necessary.
     */
    private WeakReference<TextView> mTextView;

    SimpleAsyncTask(TextView tv) {
        mTextView = new WeakReference<>(tv);
    }

    @Override
    protected String doInBackground(Void... voids) {
        // Generate a random number between 0 and 10
        Random r = new Random();
        int n = r.nextInt(11);

        // Make the task take long enough that we have
        // time to rotate the phone while it is running
        int s = n * 200;

        // Sleep for the random amount of time
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Return a String result
        return "Awake at last after sleeping for " + s + " milliseconds!";
    }

    @Override
    protected void onPostExecute(String s) {
        mTextView.get().setText(s);
    }
}
