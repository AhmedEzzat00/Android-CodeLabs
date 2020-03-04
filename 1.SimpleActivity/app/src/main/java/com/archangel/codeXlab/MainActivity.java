package com.archangel.codeXlab;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    private Button mResetCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = findViewById(R.id.show_count);

        if (savedInstanceState != null) {
            mShowCount.setText(savedInstanceState.getString("count_value"));
        }
        mShowCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countUp(v);
            }
        });

        final Button mToast = findViewById(R.id.toast_button);
        mToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(v);
            }
        });

        mResetCounter = findViewById(R.id.zero_button);
        mResetCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount = 0;
                mShowCount.setText(String.valueOf(mCount));
                v.setBackgroundColor(Color.GRAY);
            }
        });
    }

    public void showToast(View view) {
        Toast.makeText(this, "Test_Toast", Toast.LENGTH_SHORT).show();
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(String.valueOf(mCount));
        if (mCount > 0)
            mResetCounter.setBackgroundColor(Color.GREEN);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String count = mShowCount.getText().toString();
        outState.putString("count_value", count);
    }
}
