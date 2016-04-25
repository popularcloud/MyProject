package com.younge.testproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Allen Lake on 2016/4/25 0025.
 */
public class SecondeActivity extends BaseActivity{

    Button mainPage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconde);
        mainPage = (Button) findViewById(R.id.mainPage);
        Log.d(TESTTAG,this +" is create");
        mainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondeActivity.this,MainActivity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TESTTAG,this +" is start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TESTTAG,this +" is Resume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TESTTAG,this +" is stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TESTTAG,this +" is destroy");
    }
}
