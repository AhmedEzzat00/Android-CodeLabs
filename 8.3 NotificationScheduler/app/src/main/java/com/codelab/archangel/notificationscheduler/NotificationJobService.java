package com.codelab.archangel.notificationscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;

public class NotificationJobService extends JobService {
    public NotificationJobService() {
    }


    @Override
    public boolean onStartJob(JobParameters params) {
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
