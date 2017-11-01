package com.ct7liang.tangyuan;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/10/31.
 *
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        // fragment首次加载/预加载的时候调用
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        // fragment首次加载/预加载的时候调用
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // fragment加载/预加载的时候调用
        return View.inflate(getActivity(), setContentView(), null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // fragment加载/预加载的时候调用
        super.onViewCreated(view, savedInstanceState);

        findView(view);
        initData();
        setView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // fragment加载/预加载的时候调用
        super.onActivityCreated(savedInstanceState);

        initFinish();
    }

    @Override
    public void onStart() {
        // fragment加载/预加载的时候调用
        super.onStart();
    }

    @Override
    public void onResume() {
        // fragment加载/预加载的时候调用
        super.onResume();
    }

    @Override
    public void onPause() {
        // 销毁不在加载/预加载状态的fragment时候调用
        super.onPause();
    }

    @Override
    public void onStop() {
        // 销毁不在加载/预加载状态的fragment时候调用
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        // 销毁不在加载/预加载状态的fragment时候调用
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        // 依附Activity销毁时, 正在显示和预加载的fragment被销毁时调用
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        // 依附Activity销毁时, 正在显示和预加载的fragment被销毁时调用
        super.onDetach();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        /**
         *    该方法表示当fragment
         * 在界面上显示的时候isVisibleToUser==true,
         * 离开界面isVisibleToUser==false
         *
         *    与onResume()不同的是, onResume()受fragment的预加载
         * 机制影响, 即使fragment离开界面, 可能处于预加载状态中, 当界
         * 面再次显示该fragment的时候, onResume()却不会被调用
         */
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            onShowing();
        }else{
            onHiding();
        }
    }

    /**
     * @return 设置fragment的布局
     */
    public abstract int setContentView();

    /**
     * 查找控件
     */
    public abstract void findView(View view);

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 初始化View
     */
    public abstract void setView();

    /**
     * Fragment初始化完成
     */
    public abstract void initFinish();

    /**
     * 当此Fragment展示在界面上的时候
     */
    public void onShowing(){}

    /**
     * 当此Fragment在界面上消失的时候
     */
    public void onHiding(){}


}
