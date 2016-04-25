package com.younge.testproject;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Allen Lake on 2016/4/25 0025.
 */
public class MyServers extends IntentService{

    final static String TAG = "MyServers";
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public MyServers() {
        super("com.younge.testproject.MyServers");
        Log.d(TAG,this+" is constructed");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG,"begin onHandleIntent() in "+this);
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG,"end onHandleIntent() in "+this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,this+" is destroy");
    }
}
