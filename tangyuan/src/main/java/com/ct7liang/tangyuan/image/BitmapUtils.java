package com.ct7liang.tangyuan.image;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2017/10/12.
 *   对Bitmap文件处理的工具类
 *    需要权限:
 *  <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
 *  <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
 */
public class BitmapUtils {

    private static String TAG = "BitmapUtils";

    /**
     * 根路径(用于存储本地文件/文件夹调用)
     */
    public static String ROOT_PATH = Environment.getExternalStorageDirectory().getPath();

    /**
     * 图片Uri转换为图片Bitmap
     * @param context 上下文
     * @param uri Uri
     * @return Bitmap bitmap
     */
    public static Bitmap uriToBitmap(Context context, Uri uri){
        ContentResolver cr = context.getContentResolver();
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.e(TAG, "图片Uri转换为图片Bitmap异常, 文件未找到");
        }
        return bitmap;
    }

    /**
     * 图片Bitmap转换为图片Uri
     * @param context 上下文
     * @param bitmap Bitmap
     * @return Uri uri
     */
    public static Uri bitmapToUri(Context context, Bitmap bitmap){
        return Uri.parse(MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, null, null));
    }

    /**
     * 将Bitmap转换成File
     * @param bitmap Bitmap
     * @param path 输出File文件路径
     * @param fileName 输出File文件名称
     * @return File
     * @throws IOException e
     */
    public static File bitmapToFile(Bitmap bitmap, String path, String fileName) throws IOException {
        File dirFile = new File(path);
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
        File myFile = new File(path, fileName);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myFile));
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bos);
        bos.flush();
        bos.close();
        return myFile;
    }

    /**
     * 将File转换成Bitmap对象
     * @param file File
     * @return Bitmap
     */
    public static Bitmap fileToBitmap(File file){
        return BitmapFactory.decodeFile(file.getPath());
    }

    /**
     * 对Bitmap的质量进行压缩
     * @param image Bitmap文件
     * @return Bitmap
     */
    public static Bitmap compressQuality(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        int options = 100;
        int p = 0;
        while (true) { //循环判断如果压缩后图片是否大于100kb,大于继续压缩
            int i = baos.toByteArray().length / 1024;
            if (i == p){
                break; //当bitmap的大小不再发生变化时跳出循环
            }
            p = i;
            baos.reset();//重置baos即清空baos
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
            options -= 10;//每次都减少10
            if (options == 0){
                break;
            }
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片
        return bitmap;
    }

    /**
     * 对Bitmap的尺寸进行压缩
     * @param image Bitmap文件
     * @return Bitmap
     */
    public static Bitmap compressSize(Bitmap image, float size) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        if(baos.toByteArray().length / 1024>1024) {//判断如果图片大于1M,进行压缩避免在生成图片（BitmapFactory.decodeStream）时溢出
            baos.reset();//重置baos即清空baos
            image.compress(Bitmap.CompressFormat.JPEG, 50, baos);//这里压缩50%，把压缩后的数据存放到baos中
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        //开始读入图片，此时把options.inJustDecodeBounds 设回true了
        newOpts.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
        newOpts.inJustDecodeBounds = false;
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;
        float hh;
        float ww;
        if (size == 0){
            //现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
            hh = 130f;//这里设置高度为100f
            ww = 130f;//这里设置宽度为100f
        }else{
            hh = size;//这里设置高度为100f
            ww = size;//这里设置宽度为100f
        }
        //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = 8;//be=1表示不缩放
        if (w > h && w > ww) {//如果宽度大的话根据宽度固定大小缩放
            be = (int) (newOpts.outWidth / ww);
        } else if (w < h && h > hh) {//如果高度高的话根据宽度固定大小缩放
            be = (int) (newOpts.outHeight / hh);
        }
        if (be <= 0)
            be = 1;
        newOpts.inSampleSize = be;//设置缩放比例
        //重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
        isBm = new ByteArrayInputStream(baos.toByteArray());
        bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
        return bitmap;//压缩好比例大小后再进行质量压缩
    }

    /**
     * 获取Bitmap文件的大小
     * @param bitmap Bitmap
     * @return String
     */
    public static String getBitmapSize(Bitmap bitmap){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        int i = baos.toByteArray().length / 1024;
        if (i > 1024){
            return i/1024+"M";
        }else{
            return i+"K";
        }
    }
}