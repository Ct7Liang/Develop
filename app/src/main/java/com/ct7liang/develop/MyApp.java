package com.ct7liang.develop;

import android.content.Context;

import com.ct7liang.tangyuan.BaseApp;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Administrator on 2017/10/26.
 *
 */
public class MyApp extends BaseApp {

    private RefWatcher mRefWatcher;

    @Override
    public String setFolderName() {
        return "NEW_PROJECT";
    }

    @Override
    public void initOther() {
        mRefWatcher = LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context){
        MyApp baseApplication = (MyApp) context.getApplicationContext();
        return baseApplication.mRefWatcher;
    }
}
