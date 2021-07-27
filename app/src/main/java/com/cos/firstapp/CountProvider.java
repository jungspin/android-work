package com.cos.firstapp;

import android.util.Log;

public class CountProvider {

    private static final String TAG = "CountProvider";

    public int download() {
        for (int i = 1; i < 6; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "download: " + i + "초");
        }
        return 5;
    }
}
