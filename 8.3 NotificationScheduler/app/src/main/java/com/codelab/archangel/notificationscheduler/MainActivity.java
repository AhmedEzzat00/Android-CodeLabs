package com.codelab.archangel.notificationscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private JobScheduler mScheduler;
    private static final int JOB_ID = 0;

    //Switches for setting idle and charging jon constrains
    private Switch mDeviceIdleSwitch;
    private Switch mDeviceChargingSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDeviceIdleSwitch = findViewById(R.id.idleSwitch);
        mDeviceChargingSwitch = findViewById(R.id.chargingSwitch);
    }

    public void scheduleJob(View view) {
        RadioGroup networkOptions = findViewById(R.id.networkOptions);
        int selectedNetworkID = networkOptions.getCheckedRadioButtonId();
        int selectedNetworkType = JobInfo.NETWORK_TYPE_NONE;
        switch(selectedNetworkID){
            case R.id.noNetwork:
                selectedNetworkType = JobInfo.NETWORK_TYPE_NONE;
                break;
            case R.id.anyNetwork:
                selectedNetworkType = JobInfo.NETWORK_TYPE_ANY;
                break;
            case R.id.wifiNetwork:
                selectedNetworkType = JobInfo.NETWORK_TYPE_UNMETERED;
                break;
        }
        mScheduler= (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        ComponentName serviceName=new ComponentName(getPackageName(),NotificationJobService.class.getName());
        JobInfo.Builder builder=new JobInfo.Builder(JOB_ID,serviceName);

        builder.setRequiredNetworkType(selectedNetworkType);

        builder.setRequiresDeviceIdle(mDeviceIdleSwitch.isChecked());
        builder.setRequiresCharging(mDeviceChargingSwitch.isChecked());

        //Check if there any constraints is set for the job
        boolean constraintSet = (selectedNetworkType != JobInfo.NETWORK_TYPE_NONE)
                || mDeviceChargingSwitch.isChecked() || mDeviceIdleSwitch.isChecked();
        if (constraintSet){
            JobInfo jobInfo=builder.build();
            mScheduler.schedule(jobInfo);
            Toast.makeText(this, "Job Scheduled, job will run when the constraints are met.",
                    Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Please set at least one constraint",Toast.LENGTH_SHORT).show();
        }
    }

    public void cancelJobs(View view) {
        if (mScheduler!=null){
            mScheduler.cancelAll();
            mScheduler=null;
            Toast.makeText(this, "Jobs cancelled", Toast.LENGTH_SHORT).show();
        }
    }
}