package com.archangel.messageandrecieve;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ShareCompat;
import androidx.core.content.ContextCompat;

public class ImplicitIntentsActivity extends AppCompatActivity {
    private static final String TAG =ImplicitIntentsActivity.class.getSimpleName();

    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareEditText;
    private Button mPictureButton;

    // private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_CAMERA_PERMISSION=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intents);
        Button mWebsiteButton = findViewById(R.id.button_uri);
        Button mLocationButton = findViewById(R.id.button_location);
        Button mShareButton = findViewById(R.id.button_share);
        mPictureButton=findViewById(R.id.button_picture);
        mWebsiteEditText = findViewById(R.id.editText_url);
        mLocationEditText = findViewById(R.id.editText_location);
        mShareEditText = findViewById(R.id.editText_share);


        mWebsiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebsite();
            }
        });

        mLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLocation();
            }
        });

        mShareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                shareText();
            }
        });

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            mPictureButton.setEnabled(false);
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);
        }
        mPictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPictureButton.isEnabled())
                    takePicture();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CAMERA_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mPictureButton.setEnabled(true);
            }
        }
    }
    private void takePicture() {
        Intent intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager())!=null)
            startActivity(intent);
    }

    private void shareText() {
        String text=mShareEditText.getText().toString();
        String mimeType="text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.chooser_tilte)
                .setText(text)
                .startChooser();
    }

    private void openLocation() {
        String location=mLocationEditText.getText().toString();
        Uri addressUri=Uri.parse("geo:0,0?q=" + location);
        Intent locationIntent=new Intent(Intent.ACTION_VIEW,addressUri);
        if (locationIntent.resolveActivity(getPackageManager())!=null)
            startActivity(locationIntent);
        else
            Log.d(TAG,"Can't handle location");
    }

    private void openWebsite() {
        String url=mWebsiteEditText.getText().toString();
        Uri website=Uri.parse(url);
        Intent intent=new Intent(Intent.ACTION_VIEW,website);
        //If there is at least one activity that can handle the request go for it
        if (intent.resolveActivity(getPackageManager())!=null)
            startActivity(intent);
        else
            Log.d(TAG,"Can't find an APP to handle the request");
    }
}
