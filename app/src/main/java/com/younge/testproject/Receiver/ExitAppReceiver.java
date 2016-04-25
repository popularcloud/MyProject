package com.younge.testproject.Receiver;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Allen Lake on 2016/4/25 0025.
 */
public class ExitAppReceiver extends BroadcastReceiver{

    /**
     *  自定义一个广播接收器,用来接收应用程序退出广播.
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        if (context != null){
            if(context instanceof Activity){
                ((Activity)context).finish();
            }else if(context instanceof FragmentActivity){
                ((FragmentActivity)context).finish();
            }else if(context instanceof Service){
                ((Service)context).stopSelf();
            }
        }
    }
}
