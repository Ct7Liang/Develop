package com.ct7liang.develop;

import com.ct7liang.tangyuan.BaseActivity;
import com.ct7liang.tangyuan.BaseApp;

/**
 * Created by Administrator on 2017/11/1.
 *
 */

public abstract class DemosActivity extends BaseActivity {

    @Override
    public BaseApp addBaseApp() {
        return MyApp.getAppContext();
    }
}
