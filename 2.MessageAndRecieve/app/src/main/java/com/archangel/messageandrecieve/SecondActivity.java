package com.archangel.messageandrecieve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String LOG_TAG=SecondActivity.class.getSimpleName();
    public static final String EXTRA_REPLY="com.archangel.lab_2.extra.REPLY";
    private EditText mReplyEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent=getIntent();
        String message=intent.getStringExtra(MainActivity.EXTRA_MESSAGE_KEY);
        TextView mMessageTextView=findViewById(R.id.message_textview);
        mMessageTextView.setText(message);

        mReplyEditText=findViewById(R.id.replyEditText);
        Button mReplyButton=findViewById(R.id.replyButton);
        mReplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reply();
            }
        });
    }

    private void reply()
    {
        Log.d(LOG_TAG,"Reply Button Clicked!");
        Intent intent=new Intent(this,MainActivity.class);
        String replyMessage=mReplyEditText.getText().toString();
        intent.putExtra(EXTRA_REPLY,replyMessage);
        setResult(RESULT_OK,intent);
        finish();

    }

}
