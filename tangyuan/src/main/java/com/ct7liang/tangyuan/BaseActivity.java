package com.ct7liang.tangyuan;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import com.ct7liang.tangyuan.ui.ToastUtils;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/28.
 *      setContentView(); 设置布局
 *      findView(); 查找控件
 *      initData(); 初始化数据
 *      initView(); 初始化View
 *      initFinish(); 初始化完成
 *      initNetData(); 初始化数据(子线程)
 *      initNetDataFinish(); 子线程初始化数据完成
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    public Activity mAct;
    private ProgressDialog mPd;
    private BaseApp mBaseApp;
    public ArrayList<WeakReference<Activity>> temp;

    public void getCreateParams(Bundle savedInstanceState){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //去掉系统自带的ActionBar
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        getCreateParams(savedInstanceState);

        mAct = this;

        mBaseApp = addBaseApp();

        mBaseApp.actList.add(this);

        setContentView();

        setStatusBar();

        findView();

        initDataView();

        initNetData();

        initNetDataFinish();
    }

    protected void setStatusBar(){

    }

    @Override
    protected void onDestroy() {
        mBaseApp.actList.remove(this);
        super.onDestroy();
    }

    /**
     * 刷新页面
     */
    public void refreshActivity(){
        setContentView();
        setStatusBar();
        findView();
        initDataView();
        initNetData();
        initNetDataFinish();
    }

    /**
     * 设置布局
     */
    public abstract void setContentView();

    /**
     * @return 设置BaseApp
     */
    public abstract BaseApp addBaseApp();

    /**
     * 查找控件
     */
    public abstract void findView();

    /**
     * 初始化数据
     */
    public void initDataView(){
        initData();
        initView();
        initFinish();
    }

    /**
     * 数据初始化中
     */
    public abstract void initData();

    /**
     * 设置控件(各种监听事件)
     */
    public abstract void initView();

    /**
     * 数据初始化完成
     */
    public abstract void initFinish();

    /**
     * 加载网络数据
     */
    public void initNetData(){}

    /**
     * 加载网络数据完成
     */
    public void initNetDataFinish(){}


    private Dialog pd;

    /**
     * 显示一个加载框
     * @param act BaseActivity
     */
    public void showProgressBar(android.app.Activity act){

        if (pd==null){
            pd = new ProgressDialog(this);
            pd.requestWindowFeature(1);
            pd = ProgressDialog.show(this, "", "请稍后", true, false);
        }else{
            if (!pd.isShowing()){
                pd = new ProgressDialog(this);
                pd.requestWindowFeature(1);
                pd = ProgressDialog.show(this, "", "请稍后", true, false);
            }
        }

//        if (mPd != null && mPd.isShowing()){
//
//        }else {
//            mPd = new ProgressDialog(act);
//            mPd.setMessage(getProgressContent());
//            mPd.show();
//        }
    }

    /**
     * 隐藏一个加载框
     * @param act BaseActivity
     */
    public void cancelProgressBar(android.app.Activity act){
        if(pd != null) {
            pd.dismiss();
        }

//        if (mPd!=null && mPd.isShowing()) {
//            mPd.dismiss();
//        }
    }

    public String getProgressContent(){
        return progressContent[(int) (Math.random()*2)];
    }

    private String[] progressContent = {
            "正在玩儿命连接网络...",
            "疯狂请求数据中...",
    };

    public void startActivityNOFinish(Class <?> cls){
        Intent i = new Intent(mAct, cls);
        startActivity(i);
    }
    public void startActivityAndFinish(Class <?> cls){
        Intent i = new Intent(mAct, cls);
        startActivity(i);
        finish();
    }
    public void startActivityNOFinish(Class <?> cls, String key, String value){
        Intent i = new Intent(mAct, cls);
        i.putExtra(key, value);
        startActivity(i);
    }
    public void startActivityAndFinish(Class <?> cls, String key, String value){
        Intent i = new Intent(mAct, cls);
        i.putExtra(key, value);
        startActivity(i);
        finish();
    }
    public void startActivityNOFinish(Class <?> cls, String key, int value){
        Intent i = new Intent(mAct, cls);
        i.putExtra(key, value);
        startActivity(i);
    }
    public void startActivityAndFinish(Class <?> cls, String key, int value){
        Intent i = new Intent(mAct, cls);
        i.putExtra(key, value);
        startActivity(i);
        finish();
    }
    public void startActivityNOFinish(Class <?> cls, String key, boolean value){
        Intent i = new Intent(mAct, cls);
        i.putExtra(key, value);
        startActivity(i);
    }
    public void startActivityAndFinish(Class <?> cls, String key, boolean value){
        Intent i = new Intent(mAct, cls);
        i.putExtra(key, value);
        startActivity(i);
        finish();
    }
    public void startActivityNOFinish(Class <?> cls, String[] key, String[] value){
        Intent i = new Intent(mAct, cls);
        for (int j = 0; j < key.length; j++) {
            i.putExtra(key[j], value[j]);
        }
        startActivity(i);
    }
    public void startActivityAndFinish(Class <?> cls, String[] key, String[] value){
        Intent i = new Intent(mAct, cls);
        for (int j = 0; j < key.length; j++) {
            i.putExtra(key[j], value[j]);
        }
        startActivity(i);
        finish();
    }
    public void startActivityNOFinish(Class <?> cls, String[] key, int[] value){
        Intent i = new Intent(mAct, cls);
        for (int j = 0; j < key.length; j++) {
            i.putExtra(key[j], value[j]);
        }
        startActivity(i);
    }
    public void startActivityAndFinish(Class <?> cls, String[] key, int[] value){
        Intent i = new Intent(mAct, cls);
        for (int j = 0; j < key.length; j++) {
            i.putExtra(key[j], value[j]);
        }
        startActivity(i);
        finish();
    }
    public void startActivityNOFinish(Class <?> cls, String[] key, boolean[] value){
        Intent i = new Intent(mAct, cls);
        for (int j = 0; j < key.length; j++) {
            i.putExtra(key[j], value[j]);
        }
        startActivity(i);
    }
    public void startActivityAndFinish(Class <?> cls, String[] key, boolean[] value){
        Intent i = new Intent(mAct, cls);
        for (int j = 0; j < key.length; j++) {
            i.putExtra(key[j], value[j]);
        }
        startActivity(i);
        finish();
    }

    /**
     * 清除除自己以外的所有activity,退出页面
     */
    public void clearOtherActivity() {
        temp = new ArrayList<>();
        for (android.app.Activity act : mBaseApp.actList) {
            if (act != this) {
                temp.add(new WeakReference<>(act));
            }
        }
        for (WeakReference<android.app.Activity> weakReference : temp) {
            if (weakReference != null) {
                weakReference.get().finish();
            }
        }
    }

    /**
     * 清除所有activity,退出页面
     */
    public void clearAllActivity() {
        temp = new ArrayList<>();
        for (Activity act : mBaseApp.actList) {
            temp.add(new WeakReference<>(act));
        }
        for (WeakReference<Activity> weakReference : temp) {
            if (weakReference != null) {
                weakReference.get().finish();
            }
        }
    }

    public long currentTime;
    public long lastTime;
    /**
     * 提示用户, 直接退出应用, 清理所有页面
     */
    public void exitApp() {
        currentTime = System.currentTimeMillis();
        if (currentTime - lastTime < 2000){
            lastTime = currentTime;
            clearAllActivity();
        }else {
            ToastUtils.showShort("再按一次退出");
            lastTime = currentTime;
        }
    }
}