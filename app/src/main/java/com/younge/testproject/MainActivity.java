package com.younge.testproject;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

/**
 * 测试
 * 1.intentServer
 * 2.通过广播退出app
 */
public class MainActivity extends BaseActivity {

    Button secondPage;
    Button exitApp;
    Button visitBrowser;

    private String visitUrl = "http://blog.csdn.net/sodino";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.d(TESTTAG,this +" is create");
        //测试intentService
       // testStartIntentServer();

        //测试退出app
        testExitApp();

        //测试打开特定网页
        testOpenGivenBrowser();

        }

    private void testOpenGivenBrowser() {
        visitBrowser = (Button) findViewById(R.id.visitBrowser);
        visitBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //choiceBrowserToVisitUrl(visitUrl);
                doDefault();
            }
        });
    }

    private void testStartIntentServer(){
       Intent intent = new Intent(this,MyServers.class);
       startService(intent);
       startService(intent);
       startService(intent);
    }

    private void testExitApp(){
        secondPage = (Button) findViewById(R.id.secondPage);
        exitApp = (Button) findViewById(R.id.exitApp);
        secondPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondeActivity.class));
            }
        });
        exitApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               exitApp();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TESTTAG,this +" is destroy");
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

    private void choiceBrowserToVisitUrl(String url) {
        boolean existUC = false, existOpera = false, existQQ = false, existDolphin = false, existSkyfire = false, existSteel = false, existGoogle = false;
        String ucPath = "", operaPath = "", qqPath = "", dolphinPath = "", skyfirePath = "", steelPath = "", googlePath = "";
        PackageManager packageMgr = getPackageManager();
        List<PackageInfo> list = packageMgr.getInstalledPackages(0);
        for (int i = 0; i < list.size(); i++) {
            PackageInfo info = list.get(i);
            String temp = info.packageName;
            if (temp.equals("com.android.chrome")) {
                // 存在GoogleBroser
                googlePath = temp;
                existGoogle = true;
            }else if (temp.equals("com.UCMobile")) {
                // 存在UC
                ucPath = temp;
                existUC = true;
            }  else if (temp.equals("com.android.chrome")) {
                // 存在GoogleBroser
                googlePath = temp;
                existGoogle = true;
            }else if (temp.equals("com.tencent.mtt")) {
                // 存在QQ
                qqPath = temp;
                existQQ = true;
            } else if (temp.equals("com.opera.mini.android")) {
                // 存在Opera
                operaPath = temp;
                existOpera = true;
            } else if (temp.equals("mobi.mgeek.TunnyBrowser")) {
                dolphinPath = temp;
                existDolphin = true;
            } else if (temp.equals("com.skyfire.browser")) {
                skyfirePath = temp;
                existSkyfire = true;
            } else if (temp.equals("com.kolbysoft.steel")) {
                steelPath = temp;
                existSteel = true;
            }
        }
        if (existUC) {
            gotoUrl(ucPath, url, packageMgr);
        } else if (existOpera) {
            gotoUrl(operaPath, url, packageMgr);
        } else if (existQQ) {
            gotoUrl(qqPath, url, packageMgr);
        } else if (existDolphin) {
            gotoUrl(dolphinPath, url, packageMgr);
        } else if (existSkyfire) {
            gotoUrl(skyfirePath, url, packageMgr);
        } else if (existSteel) {
            gotoUrl(steelPath, url, packageMgr);
        } else if (existGoogle) {
            gotoUrl(googlePath, url, packageMgr);
        } else {
            doDefault();
        }
    }

    private void gotoUrl(String packageName, String url,
                         PackageManager packageMgr) {
        try {
            Intent intent;
            intent = packageMgr.getLaunchIntentForPackage(packageName);
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        } catch (Exception e) {
            // 在1.5及以前版本会要求catch(android.content.pm.PackageManager.NameNotFoundException)异常，该异常在1.5以后版本已取消。
            e.printStackTrace();
        }
    }
    private void doDefault() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(visitUrl));
        startActivity(intent);
    }
}
