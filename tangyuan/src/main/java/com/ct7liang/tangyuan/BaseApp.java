package com.ct7liang.tangyuan;

import android.app.Activity;
import android.app.Application;
import android.os.Environment;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.ct7liang.tangyuan.local_storage.SpUtils;
import com.ct7liang.tangyuan.ui.ToastUtils;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/31.
 *
 */
public abstract class BaseApp extends Application {

    /**
     * 存储Activity的集合
     */
    public ArrayList<Activity> actList;

    /**
     * Application对象
     */
    public static BaseApp instance;

    /**
     * App的本地文件夹
     */
    public static File mFile;

    /**
     * volley请求队列
     */
    private static RequestQueue requestQueue;

    /**
     * 网络请求交互过程中的cookie
     */
    private static String sessionId;


    @Override
    public void onCreate() {
        super.onCreate();

        actList = new ArrayList<>();

        instance = this;

        SpUtils.init(this);

        ToastUtils.init(this);

        requestQueue = Volley.newRequestQueue(this);

        createAppFolder(setFolderName());

        initOther();
    }

    public abstract String setFolderName();

    /**
     * 提供继承者初始化其他的配置
     */
    public abstract void initOther();

    /**
     * 创建app文件夹
     */
    public void createAppFolder(String folderName){
        if (folderName != null){
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                String sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
                mFile = new File(sdPath, folderName);
                if (!mFile.exists()){
                    try{
                        mFile.mkdirs();
                    }catch(Exception e){
                        //防止读写sd卡造成的权限问题,而崩溃
                    }
                }
            }
        }
    }

    /**
     * @return 返回App文件夹(File)
     */
    public static File getAppFolder(){
        if (mFile != null){
            return mFile;
        }else{
            return null;
        }
    }

    /**
     * @return 获取初始化全局上下文
     */
    public static BaseApp getAppContext(){
        return instance;
    }

    /**
     * @return 获取Volley请求队列
     */
    public static RequestQueue getRequestQueue(){
        return requestQueue;
    }

}