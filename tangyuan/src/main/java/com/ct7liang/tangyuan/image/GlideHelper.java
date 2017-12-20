package com.ct7liang.tangyuan.image;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.io.File;
import java.lang.ref.WeakReference;

/**
 * Created by admin on 2017/4/28.
 *
 */
//Glide.with(context) // 指定Context
//        /**
//         * 当你传了一个 context，例如是当前应用的 activity，Glide 将会自动停止请求,当请求的 activity 已经停止的时候。
//         * 这整合到了应用的生命周期中通常是非常有帮助的，但是有时工作起来是困难的，如果你的target 是独立于应用的activity
//         * 生命周期。这里的解决方案是用 application 的 context: .with(context.getApplicationContext))。
//         * 如果你的请求需要在 activity 生命周期之外去做时，才用下面这样的代码.with(context.getApplicationContext))。
//         */
//        .load(file)// 指定图片的URL
//        .placeholder(ingResouseId)// 指定图片未成功加载前显示的图片 相当于占位符, 占位大小决定了加载出来的图片所占的大小
//        .error(errorResouseId)// 指定图片加载失败显示的图片
//        .override(300, 300)//指定图片的尺寸
//        .crossFade(2000)//是否设置图片的淡入效果, 并设置时长
//        .fitCenter()//指定图片缩放类型为fitCenter, 缩放为制定大小, 可能不会填充完整
//        .centerCrop()// 指定图片缩放类型为centerCrop, 裁剪为指定大小, 可能图片显示不完整
//        .skipMemoryCache(true)// 跳过内存缓存
//        .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
//        .diskCacheStrategy(DiskCacheStrategy.SOURCE)//仅仅只缓存原来的全分辨率的图像
//        .diskCacheStrategy(DiskCacheStrategy.RESULT)//仅仅缓存最终的图像
//        .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存所有版本的图像
//        .priority(Priority.HIGH)//指定优先级.Glide 将会用他们作为一个准则，并尽可能的处理这些请求，但是它不能保证所有的图片都会按照所要求的顺序加载。优先级排序:IMMEDIATE > HIGH > NORMAL >　LOW
//        .into(imageView);//指定显示图片的ImageView

public class GlideHelper {

    private GlideHelper(){}
    private static GlideHelper glideSetImageUtils;
    public static GlideHelper getInstance(){
        if (glideSetImageUtils == null){
            glideSetImageUtils = new GlideHelper();
        }
        return glideSetImageUtils;
    }

    /**
     * 设置图片到ImageView
     */
    public void setImage(Activity activity, File file, ImageView imageView){
        Glide
                .with(activity)
                .load(file)
//                .placeholder(ingResouseId)// 指定图片未成功加载前显示的图片 相当于占位符, 占位大小决定了加载出来的图片所占的大小
//                .error(errorResouseId)// 指定图片加载失败显示的图片
//                .override(300, 300)//指定图片的尺寸
//                .crossFade(2000)//是否设置图片的淡入效果, 并设置时长
                .fitCenter()//指定图片缩放类型为fitCenter, 缩放为制定大小, 可能不会填充完整
                .centerCrop()// 指定图片缩放类型为centerCrop, 裁剪为指定大小, 可能图片显示不完整
//                .skipMemoryCache(true)// 跳过内存缓存
//                .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//仅仅只缓存原来的全分辨率的图像
                .diskCacheStrategy(DiskCacheStrategy.RESULT)//仅仅缓存最终的图像
//                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存所有版本的图像
                .priority(Priority.HIGH)//指定优先级.Glide 将会用他们作为一个准则，并尽可能的处理这些请求，但是它不能保证所有的图片都会按照所要求的顺序加载。优先级排序:IMMEDIATE > HIGH > NORMAL >　LOW
                .into(imageView);//指定显示图片的ImageView
    }
    public void setImage(Activity activity, Uri uri, ImageView imageView){
        Glide
                .with(activity)
                .load(uri)
//                .placeholder(ingResouseId)// 指定图片未成功加载前显示的图片 相当于占位符, 占位大小决定了加载出来的图片所占的大小
//                .error(errorResouseId)// 指定图片加载失败显示的图片
//                .override(300, 300)//指定图片的尺寸
//                .crossFade(2000)//是否设置图片的淡入效果, 并设置时长
                .fitCenter()//指定图片缩放类型为fitCenter, 缩放为制定大小, 可能不会填充完整
                .centerCrop()// 指定图片缩放类型为centerCrop, 裁剪为指定大小, 可能图片显示不完整
//                .skipMemoryCache(true)// 跳过内存缓存
//                .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//仅仅只缓存原来的全分辨率的图像
                .diskCacheStrategy(DiskCacheStrategy.RESULT)//仅仅缓存最终的图像
//                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存所有版本的图像
                .priority(Priority.HIGH)//指定优先级.Glide 将会用他们作为一个准则，并尽可能的处理这些请求，但是它不能保证所有的图片都会按照所要求的顺序加载。优先级排序:IMMEDIATE > HIGH > NORMAL >　LOW
                .into(imageView);//指定显示图片的ImageView
    }
    public void setImage(Activity activity, int resource, ImageView imageView){
        Glide
                .with(activity)
                .load(resource)
//                .placeholder(ingResouseId)// 指定图片未成功加载前显示的图片 相当于占位符, 占位大小决定了加载出来的图片所占的大小
//                .error(errorResouseId)// 指定图片加载失败显示的图片
//                .override(300, 300)//指定图片的尺寸
//                .crossFade(2000)//是否设置图片的淡入效果, 并设置时长
                .fitCenter()//指定图片缩放类型为fitCenter, 缩放为制定大小, 可能不会填充完整
                .centerCrop()// 指定图片缩放类型为centerCrop, 裁剪为指定大小, 可能图片显示不完整
//                .skipMemoryCache(true)// 跳过内存缓存
//                .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//仅仅只缓存原来的全分辨率的图像
                .diskCacheStrategy(DiskCacheStrategy.RESULT)//仅仅缓存最终的图像
//                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存所有版本的图像
                .priority(Priority.HIGH)//指定优先级.Glide 将会用他们作为一个准则，并尽可能的处理这些请求，但是它不能保证所有的图片都会按照所要求的顺序加载。优先级排序:IMMEDIATE > HIGH > NORMAL >　LOW
                .into(imageView);//指定显示图片的ImageView
    }
    public void setImage(Activity activity, String string, ImageView imageView){
        Glide
                .with(activity)
                .load(string)
//                .placeholder(ingResouseId)// 指定图片未成功加载前显示的图片 相当于占位符, 占位大小决定了加载出来的图片所占的大小
//                .error(errorResouseId)// 指定图片加载失败显示的图片
//                .override(300, 300)//指定图片的尺寸
//                .crossFade(2000)//是否设置图片的淡入效果, 并设置时长
                .fitCenter()//指定图片缩放类型为fitCenter, 缩放为制定大小, 可能不会填充完整
                .centerCrop()// 指定图片缩放类型为centerCrop, 裁剪为指定大小, 可能图片显示不完整
//                .skipMemoryCache(true)// 跳过内存缓存
//                .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//仅仅只缓存原来的全分辨率的图像
                .diskCacheStrategy(DiskCacheStrategy.RESULT)//仅仅缓存最终的图像
//                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存所有版本的图像
                .priority(Priority.HIGH)//指定优先级.Glide 将会用他们作为一个准则，并尽可能的处理这些请求，但是它不能保证所有的图片都会按照所要求的顺序加载。优先级排序:IMMEDIATE > HIGH > NORMAL >　LOW
                .into(imageView);//指定显示图片的ImageView
    }



    /**
     * 设置圆形图片
     */
    public void setCircleImage(Activity activity, File file, ImageView imageView){
        Glide
                .with(activity) // 指定Context
                .load(file)// 指定图片的URL
//                .placeholder(ingResouseId)// 指定图片未成功加载前显示的图片 相当于占位符, 占位大小决定了加载出来的图片所占的大小
//                .error(errorResouseId)// 指定图片加载失败显示的图片
//                .override(300, 300)//指定图片的尺寸
//                .crossFade(2000)//是否设置图片的淡入效果, 并设置时长
//                .fitCenter()//指定图片缩放类型为fitCenter, 缩放为制定大小, 可能不会填充完整
                .centerCrop()// 指定图片缩放类型为centerCrop, 裁剪为指定大小, 可能图片显示不完整
                .skipMemoryCache(true)// 跳过内存缓存
//                .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//仅仅只缓存原来的全分辨率的图像
                .diskCacheStrategy(DiskCacheStrategy.RESULT)//仅仅缓存最终的图像
//                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存所有版本的图像
//                .priority(Priority.HIGH)//指定优先级.Glide 将会用他们作为一个准则，并尽可能的处理这些请求，但是它不能保证所有的图片都会按照所要求的顺序加载。优先级排序:IMMEDIATE > HIGH > NORMAL >　LOW
                .transform(getCircleTransform(activity))
                .into(imageView);//指定显示图片的ImageView
    }
    public void setCircleImage(Activity activity, Uri file, ImageView imageView){
        Glide
                .with(activity) // 指定Context
                .load(file)// 指定图片的URL
//                .placeholder(ingResouseId)// 指定图片未成功加载前显示的图片 相当于占位符, 占位大小决定了加载出来的图片所占的大小
//                .error(errorResouseId)// 指定图片加载失败显示的图片
//                .override(300, 300)//指定图片的尺寸
//                .crossFade(2000)//是否设置图片的淡入效果, 并设置时长
//                .fitCenter()//指定图片缩放类型为fitCenter, 缩放为制定大小, 可能不会填充完整
                .centerCrop()// 指定图片缩放类型为centerCrop, 裁剪为指定大小, 可能图片显示不完整
                .skipMemoryCache(true)// 跳过内存缓存
//                .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//仅仅只缓存原来的全分辨率的图像
                .diskCacheStrategy(DiskCacheStrategy.RESULT)//仅仅缓存最终的图像
//                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存所有版本的图像
//                .priority(Priority.HIGH)//指定优先级.Glide 将会用他们作为一个准则，并尽可能的处理这些请求，但是它不能保证所有的图片都会按照所要求的顺序加载。优先级排序:IMMEDIATE > HIGH > NORMAL >　LOW
                .transform(getCircleTransform(activity))
                .into(imageView);//指定显示图片的ImageView
    }
    public void setCircleImage(Activity activity, String file, ImageView imageView){
        Glide
                .with(activity) // 指定Context
                .load(file)// 指定图片的URL
//                .placeholder(ingResouseId)// 指定图片未成功加载前显示的图片 相当于占位符, 占位大小决定了加载出来的图片所占的大小
//                .error(errorResouseId)// 指定图片加载失败显示的图片
//                .override(300, 300)//指定图片的尺寸
//                .crossFade(2000)//是否设置图片的淡入效果, 并设置时长
//                .fitCenter()//指定图片缩放类型为fitCenter, 缩放为制定大小, 可能不会填充完整
                .centerCrop()// 指定图片缩放类型为centerCrop, 裁剪为指定大小, 可能图片显示不完整
                .skipMemoryCache(true)// 跳过内存缓存
//                .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//仅仅只缓存原来的全分辨率的图像
                .diskCacheStrategy(DiskCacheStrategy.RESULT)//仅仅缓存最终的图像
//                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存所有版本的图像
//                .priority(Priority.HIGH)//指定优先级.Glide 将会用他们作为一个准则，并尽可能的处理这些请求，但是它不能保证所有的图片都会按照所要求的顺序加载。优先级排序:IMMEDIATE > HIGH > NORMAL >　LOW
                .transform(getCircleTransform(activity))
                .into(imageView);//指定显示图片的ImageView
    }
    public void setCircleImage(Activity activity, int file, ImageView imageView){
        Glide
                .with(activity) // 指定Context
                .load(file)// 指定图片的URL
//                .placeholder(ingResouseId)// 指定图片未成功加载前显示的图片 相当于占位符, 占位大小决定了加载出来的图片所占的大小
//                .error(errorResouseId)// 指定图片加载失败显示的图片
//                .override(300, 300)//指定图片的尺寸
//                .crossFade(2000)//是否设置图片的淡入效果, 并设置时长
//                .fitCenter()//指定图片缩放类型为fitCenter, 缩放为制定大小, 可能不会填充完整
                .centerCrop()// 指定图片缩放类型为centerCrop, 裁剪为指定大小, 可能图片显示不完整
                .skipMemoryCache(true)// 跳过内存缓存
//                .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//仅仅只缓存原来的全分辨率的图像
                .diskCacheStrategy(DiskCacheStrategy.RESULT)//仅仅缓存最终的图像
//                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存所有版本的图像
//                .priority(Priority.HIGH)//指定优先级.Glide 将会用他们作为一个准则，并尽可能的处理这些请求，但是它不能保证所有的图片都会按照所要求的顺序加载。优先级排序:IMMEDIATE > HIGH > NORMAL >　LOW
                .transform(getCircleTransform(activity))
                .into(imageView);//指定显示图片的ImageView
    }



    /**
     * 设置圆角图片
     * @param activity BaseActivity
     * @param file File
     * @param imageView ImageView
     * @param dp 角度
     */
    public void setCircleRoundImage(Activity activity, File file, ImageView imageView, int dp){
        Glide
                .with(activity) // 指定Context
                .load(file)// 指定图片的URL
//                .placeholder(ingResouseId)// 指定图片未成功加载前显示的图片 相当于占位符, 占位大小决定了加载出来的图片所占的大小
//                .error(errorResouseId)// 指定图片加载失败显示的图片
//                .override(300, 300)//指定图片的尺寸
//                .crossFade(2000)//是否设置图片的淡入效果, 并设置时长
//                .fitCenter()//指定图片缩放类型为fitCenter, 缩放为制定大小, 可能不会填充完整
                .centerCrop()// 指定图片缩放类型为centerCrop, 裁剪为指定大小, 可能图片显示不完整
//                .skipMemoryCache(true)// 跳过内存缓存
//                .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//仅仅只缓存原来的全分辨率的图像
                .diskCacheStrategy(DiskCacheStrategy.RESULT)//仅仅缓存最终的图像
//                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存所有版本的图像
//                .priority(Priority.HIGH)//指定优先级.Glide 将会用他们作为一个准则，并尽可能的处理这些请求，但是它不能保证所有的图片都会按照所要求的顺序加载。优先级排序:IMMEDIATE > HIGH > NORMAL >　LOW
                .transform(getCircleRoundTransform(activity, dp))
                .into(imageView);//指定显示图片的ImageView
    }
    public void setCircleRoundImage(Activity activity, Uri file, ImageView imageView, int dp){
        Glide
                .with(activity) // 指定Context
                .load(file)// 指定图片的URL
//                .placeholder(ingResouseId)// 指定图片未成功加载前显示的图片 相当于占位符, 占位大小决定了加载出来的图片所占的大小
//                .error(errorResouseId)// 指定图片加载失败显示的图片
//                .override(300, 300)//指定图片的尺寸
//                .crossFade(2000)//是否设置图片的淡入效果, 并设置时长
//                .fitCenter()//指定图片缩放类型为fitCenter, 缩放为制定大小, 可能不会填充完整
                .centerCrop()// 指定图片缩放类型为centerCrop, 裁剪为指定大小, 可能图片显示不完整
//                .skipMemoryCache(true)// 跳过内存缓存
//                .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//仅仅只缓存原来的全分辨率的图像
                .diskCacheStrategy(DiskCacheStrategy.RESULT)//仅仅缓存最终的图像
//                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存所有版本的图像
//                .priority(Priority.HIGH)//指定优先级.Glide 将会用他们作为一个准则，并尽可能的处理这些请求，但是它不能保证所有的图片都会按照所要求的顺序加载。优先级排序:IMMEDIATE > HIGH > NORMAL >　LOW
                .transform(getCircleRoundTransform(activity, dp))
                .into(imageView);//指定显示图片的ImageView
    }public void setCircleRoundImage(Activity activity, String file, ImageView imageView, int dp){
        Glide
                .with(activity) // 指定Context
                .load(file)// 指定图片的URL
//                .placeholder(ingResouseId)// 指定图片未成功加载前显示的图片 相当于占位符, 占位大小决定了加载出来的图片所占的大小
//                .error(errorResouseId)// 指定图片加载失败显示的图片
//                .override(300, 300)//指定图片的尺寸
//                .crossFade(2000)//是否设置图片的淡入效果, 并设置时长
//                .fitCenter()//指定图片缩放类型为fitCenter, 缩放为制定大小, 可能不会填充完整
                .centerCrop()// 指定图片缩放类型为centerCrop, 裁剪为指定大小, 可能图片显示不完整
//                .skipMemoryCache(true)// 跳过内存缓存
//                .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//仅仅只缓存原来的全分辨率的图像
                .diskCacheStrategy(DiskCacheStrategy.RESULT)//仅仅缓存最终的图像
//                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存所有版本的图像
//                .priority(Priority.HIGH)//指定优先级.Glide 将会用他们作为一个准则，并尽可能的处理这些请求，但是它不能保证所有的图片都会按照所要求的顺序加载。优先级排序:IMMEDIATE > HIGH > NORMAL >　LOW
                .transform(getCircleRoundTransform(activity, dp))
                .into(imageView);//指定显示图片的ImageView
    }public void setCircleRoundImage(Activity activity, int file, ImageView imageView, int dp){
        Glide
                .with(activity) // 指定Context
                .load(file)// 指定图片的URL
//                .placeholder(ingResouseId)// 指定图片未成功加载前显示的图片 相当于占位符, 占位大小决定了加载出来的图片所占的大小
//                .error(errorResouseId)// 指定图片加载失败显示的图片
//                .override(300, 300)//指定图片的尺寸
//                .crossFade(2000)//是否设置图片的淡入效果, 并设置时长
//                .fitCenter()//指定图片缩放类型为fitCenter, 缩放为制定大小, 可能不会填充完整
                .centerCrop()// 指定图片缩放类型为centerCrop, 裁剪为指定大小, 可能图片显示不完整
//                .skipMemoryCache(true)// 跳过内存缓存
//                .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//仅仅只缓存原来的全分辨率的图像
                .diskCacheStrategy(DiskCacheStrategy.RESULT)//仅仅缓存最终的图像
//                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存所有版本的图像
//                .priority(Priority.HIGH)//指定优先级.Glide 将会用他们作为一个准则，并尽可能的处理这些请求，但是它不能保证所有的图片都会按照所要求的顺序加载。优先级排序:IMMEDIATE > HIGH > NORMAL >　LOW
                .transform(getCircleRoundTransform(activity, dp))
                .into(imageView);//指定显示图片的ImageView
    }

    /**
     * 设置本地gif图片
     * @param activity BaseActivity
     * @param file File
     * @param imageView ImageView
     */
    public void setGifImageView(Activity activity, File file, ImageView imageView){
        Glide
                .with(activity) // 指定Context
                .load(file)// 指定图片的URL
                .asGif()
//                .placeholder(ingResouseId)// 指定图片未成功加载前显示的图片 相当于占位符, 占位大小决定了加载出来的图片所占的大小
//                .error(errorResouseId)// 指定图片加载失败显示的图片
//                .skipMemoryCache(true)// 跳过内存缓存
//                .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//仅仅只缓存原来的全分辨率的图像
                .into(imageView);//指定显示图片的ImageView
    }
    public void setGifImageView(Activity activity, String imageUrl, ImageView imageView){
        Glide
                .with(activity) // 指定Context
                .load(imageUrl)// 指定图片的URL
                .asGif()
//                .placeholder(ingResouseId)// 指定图片未成功加载前显示的图片 相当于占位符, 占位大小决定了加载出来的图片所占的大小
//                .error(errorResouseId)// 指定图片加载失败显示的图片
//                .skipMemoryCache(true)// 跳过内存缓存
//                .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//仅仅只缓存原来的全分辨率的图像
                .into(imageView);//指定显示图片的ImageView
    }
    public void setGifImageView(Activity activity, Uri imageUrl, ImageView imageView){
        Glide
                .with(activity) // 指定Context
                .load(imageUrl)// 指定图片的URL
                .asGif()
//                .placeholder(ingResouseId)// 指定图片未成功加载前显示的图片 相当于占位符, 占位大小决定了加载出来的图片所占的大小
//                .error(errorResouseId)// 指定图片加载失败显示的图片
//                .skipMemoryCache(true)// 跳过内存缓存
//                .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//仅仅只缓存原来的全分辨率的图像
                .into(imageView);//指定显示图片的ImageView
    }
    public void setGifImageView(Activity activity, int imageUrl, ImageView imageView){
        Glide
                .with(activity) // 指定Context
                .load(imageUrl)// 指定图片的URL
                .asGif()
//                .placeholder(ingResouseId)// 指定图片未成功加载前显示的图片 相当于占位符, 占位大小决定了加载出来的图片所占的大小
//                .error(errorResouseId)// 指定图片加载失败显示的图片
//                .skipMemoryCache(true)// 跳过内存缓存
//                .diskCacheStrategy(DiskCacheStrategy.NONE)//跳过磁盘缓存
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)//仅仅只缓存原来的全分辨率的图像
                .into(imageView);//指定显示图片的ImageView
    }


    /**
     * 设置图片到其它控件中
     * @param context 上下文
     * @param imageFrom 图片来源
     * @param view 目标View
     */
    public void setImageToOther(Context context, Uri imageFrom, View view){
        DisplayMetrics dm2 = context.getResources().getDisplayMetrics();
        Glide
                .with(context)
                .load(imageFrom)
                .asBitmap()
                .centerCrop() //指定图片缩放类型为centerCrop, 裁剪为指定大小, 可能图片显示不完整
                .into(new MySimpleTarget(view, dm2.widthPixels, dm2.heightPixels));
    }
    public void setImageToOther(Context context, String imageFrom, View view){
        DisplayMetrics dm2 = context.getResources().getDisplayMetrics();
        Glide
                .with(context)
                .load(imageFrom)
                .asBitmap()
                .centerCrop() //指定图片缩放类型为centerCrop, 裁剪为指定大小, 可能图片显示不完整
                .into(new MySimpleTarget(view, dm2.widthPixels, dm2.heightPixels));
    }
    public void setImageToOther(Context context, int imageFrom, View view){
        DisplayMetrics dm2 = context.getResources().getDisplayMetrics();
        Glide
                .with(context)
                .load(imageFrom)
                .asBitmap()
                .centerCrop() //指定图片缩放类型为centerCrop, 裁剪为指定大小, 可能图片显示不完整
                .into(new MySimpleTarget(view, dm2.widthPixels, dm2.heightPixels));
    }
    public void setImageToOther(Context context, File imageFrom, View view){
        DisplayMetrics dm2 = context.getResources().getDisplayMetrics();
        Glide
                .with(context)
                .load(imageFrom)
                .asBitmap()
                .centerCrop() //指定图片缩放类型为centerCrop, 裁剪为指定大小, 可能图片显示不完整
                .into(new MySimpleTarget(view, dm2.widthPixels, dm2.heightPixels));
    }



    /**
     * 清理缓存
     * @param ctx
     * Glide自带清除缓存的功能,分别对应
     * Glide.get(context).clearDiskCache();(清除磁盘缓存)与
     * Glide.get(context).clearMemory();(清除内存缓存)两个方法.
     * 其中
     * clearDiskCache()方法必须运行在子线程,
     * clearMemory()方法必须运行在主线程,
     * 这是这两个方法所强制要求的.
     */
    public void clearCache(Context ctx){
        Glide.get(ctx).clearMemory();
        new ClearCacheThread(ctx).start();
    }

    /**
     * 配置圆形图片
     * @param context Context
     * @return BitmapTransformation
     */
    private BitmapTransformation getCircleTransform(Context context) {
        if (circleTransform == null){
            circleTransform = new GlideCircleTransform(context);
        }
        return circleTransform;
    }
    private GlideCircleTransform circleTransform;
    private class GlideCircleTransform extends BitmapTransformation {
        GlideCircleTransform(Context context) {
            super(context);
        }
        @Override
        protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
            return circleCrop(pool, toTransform);
        }
        private Bitmap circleCrop(BitmapPool pool, Bitmap source) {
            if (source == null) return null;
            int size = Math.min(source.getWidth(), source.getHeight());
            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;
            Bitmap squared = Bitmap.createBitmap(source, x, y, size, size);
            Bitmap result = pool.get(size, size, Bitmap.Config.ARGB_8888);
            if (result == null) {
                result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
            paint.setAntiAlias(true);
            float r = size / 2f;
            canvas.drawCircle(r, r, r, paint);
            return result;
        }
        @Override
        public String getId() {
            return getClass().getName();
        }
    }

    /**
     * 配置圆角图片
     * @param context Context
     * @return BitmapTransformation
     */
    private BitmapTransformation getCircleRoundTransform(Context context, int dp) {
        if (transform == null){
            transform = new GlideRoundTransform(context, dp);
        }
        return transform;
    }
    private GlideRoundTransform transform;
    private class GlideRoundTransform extends BitmapTransformation {
        private float radius = 0f;
        public GlideRoundTransform(Context context) {
            this(context, 4);
        }
        GlideRoundTransform(Context context, int dp) {
            super(context);
            this.radius = Resources.getSystem().getDisplayMetrics().density * dp;
        }
        @Override
        protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
            return roundCrop(pool, toTransform);
        }
        private Bitmap roundCrop(BitmapPool pool, Bitmap source) {
            if (source == null) return null;
            Bitmap result = pool.get(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
            if (result == null) {
                result = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            paint.setShader(new BitmapShader(source, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
            paint.setAntiAlias(true);
            RectF rectF = new RectF(0f, 0f, source.getWidth(), source.getHeight());
            canvas.drawRoundRect(rectF, radius, radius, paint);
            return result;
        }
        @Override
        public String getId() {
            return getClass().getName() + Math.round(radius);
        }
    }

    /**
     * 配置设置图片到其他控件
     */
    private class MySimpleTarget extends SimpleTarget<Bitmap> {
        private View view;
        private Drawable mDrawable;
        MySimpleTarget(View view, int width, int height){
            super(width, height);
            this.view = view;
        }
        @Override
        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
            mDrawable = new BitmapDrawable(resource);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                //设置背景
                view.setBackground(mDrawable);
            }
        }
    }

    /**
     * 清理Glide缓存的子线程
     */
    private static class ClearCacheThread extends Thread{
        private WeakReference<Context> mReference;
        ClearCacheThread(Context ctx){
            mReference = new WeakReference<>(ctx);
        }
        @Override
        public void run() {
            Context context = mReference.get();
            if (context != null){
                Glide.get(context).clearDiskCache();
            }
        }
    }
}
