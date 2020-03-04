package com.archangel.messageandrecieve;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE_KEY = "com.archangel.lab_2.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyHeaderTextView;
    private TextView mReplyBodyTextView;
    private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize all of the Views
        mReplyHeaderTextView = findViewById(R.id.title_reply_received);
        mReplyBodyTextView = findViewById(R.id.reply_body_textView);
        mMessageEditText = findViewById(R.id.messageEditText);
        Button sendButton = findViewById(R.id.button_send);
        Button mImplicitActivityButton=findViewById(R.id.button_implicit_intent);

        //Check for savedStates
        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState.getBoolean("reply_visible");
            //Show both the header and the body if there is a message from the
            //other activity
            if (isVisible) {
                mReplyHeaderTextView.setVisibility(View.VISIBLE);
                mReplyBodyTextView.setText(savedInstanceState.getString("reply_text"));
                mReplyBodyTextView.setVisibility(View.VISIBLE);
            }
        }

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchSecondActivity();
            }
        });

        mImplicitActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchImplicitActivity();
            }
        });
    }

    private void launchImplicitActivity() {
        Intent implicitIntent=new Intent(this,ImplicitIntentsActivity.class);
        startActivity(implicitIntent);
    }

    /**
     * Get the text typed by the user in the EditView and pass it to the SecondActivity
     */
    private void launchSecondActivity() {
        Log.d(LOG_TAG, "Button Clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE_KEY, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST)
            if (resultCode == RESULT_OK) {
                String reply = data != null ? data.getStringExtra(SecondActivity.EXTRA_REPLY) : "";
                mReplyHeaderTextView.setVisibility(View.VISIBLE);
                mReplyBodyTextView.setText(reply);
                mReplyBodyTextView.setVisibility(View.VISIBLE);
            }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //If the heading is VISIBLE ,message needs to be saved.
        //Otherwise we are still using the same layout (hadn't destroyed or recreated yet)
        if (mReplyHeaderTextView.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text", mReplyBodyTextView.getText().toString());
        }
    }
}
