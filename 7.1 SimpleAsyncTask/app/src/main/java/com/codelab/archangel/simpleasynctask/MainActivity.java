package com.codelab.archangel.simpleasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.text_id);
        Button sleepButton = findViewById(R.id.sleep_button);
        sleepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.setText(R.string.napping);

                // Start the AsyncTask.
                // The AsyncTask has a callback that will update the text view.
                new SimpleAsyncTask(mTextView).execute();
            }
        });
    }
}