package com.younge.testproject;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.younge.testproject.Receiver.ExitAppReceiver;

/**
 * Created by Allen Lake on 2016/4/25 0025.
 */
public class BaseActivity extends AppCompatActivity {

    private ExitAppReceiver exitReceiver = new ExitAppReceiver();
    //自定义退出应用Action,实际应用中应该放到整个应用的Constant类中.
    private static final String EXIT_APP_ACTION = "com.micen.exit_app";

    public static final String TESTTAG = "testTag";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.d(TESTTAG,this +" is create");
        registerExitReceiver();
    }

    private void registerExitReceiver() {
        IntentFilter exitFilter = new IntentFilter();
        exitFilter.addAction(EXIT_APP_ACTION);
        registerReceiver(exitReceiver, exitFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // Log.d(TESTTAG,this +" is destroy");
        unRegisterExitReceiver();
    }

    private void unRegisterExitReceiver() {
        unregisterReceiver(exitReceiver);
    }

    public void exitApp(){
        Intent intent = new Intent();
        intent.setAction(EXIT_APP_ACTION);
        sendBroadcast(intent);
    }


    @Override
    protected void onStart() {
        super.onStart();
      //  Log.d(TESTTAG,this +" is start");
    }

    @Override
    protected void onResume() {
        super.onResume();
       // Log.d(TESTTAG,this +" is Resume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Log.d(TESTTAG,this +" is stop");
    }
}
