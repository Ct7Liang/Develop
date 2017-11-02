package com.ct7liang.tangyuan.list;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.volley.VolleyError;
import com.ct7liang.tangyuan.BaseFragment;
import com.ct7liang.tangyuan.R;
import com.ct7liang.tangyuan.http.volley.VolleyErrorListener;
import com.ct7liang.tangyuan.http.volley.VolleyHelper;
import com.ct7liang.tangyuan.http.volley.VolleyListener;
import com.ct7liang.tangyuan.ui.ToastUtils;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.List;

/**
 * Created by Administrator on 2017/9/18.
 *
 */
public abstract class BaseListFragment extends BaseFragment {

    public RelativeLayout empty;
    public RelativeLayout progress;
    public LinearLayout success;
    public RelativeLayout error;
    public TextView tv;
    public SwipeRefreshLayout mSwipeRefreshLayout;
    public ListView mListView;
    public String operation;
    public String URLDesc;
    public String url;
    public int page;
    public int size = 5;
    public boolean isChange = false;
    public BaseAdapter adapter;
    public List data;

    @Override
    public int setContentView() {
        return R.layout.fragment_base_list;
    }

    @Override
    public void findView(View view) {
        empty = (RelativeLayout) view.findViewById(R.id.empty);
        progress = (RelativeLayout) view.findViewById(R.id.progress);
        success = (LinearLayout) view.findViewById(R.id.success);
        error = (RelativeLayout) view.findViewById(R.id.error);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        mListView = (ListView) view.findViewById(R.id.listView);
        tv = (TextView)view.findViewById(R.id.text_progress);
    }

    @Override
    public void initData() {
        operation = setOperation();
        url = setURL();
        URLDesc = setDesc();
    }

    @Override
    public void setView() {
        mSwipeRefreshLayout.setColorSchemeColors(Color.BLUE, Color.RED);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page=1;
                LoadData();
            }
        });
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState==SCROLL_STATE_IDLE && mListView.getLastVisiblePosition()==mListView.getCount()-1){
                    if (tv.getVisibility() == View.GONE){
                        tv.setVisibility(View.VISIBLE);
                    }
                    LoadData();
                }
            }
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setOnItemClick(data, position);
            }
        });
        error.findViewById(R.id.reLoad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page=1;
                LoadData();
            }
        });
        empty.findViewById(R.id.empty_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page=1;
                LoadData();
            }
        });
        (progress.findViewById(R.id.rotate)).startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.progress_layout_anim));
        showProgress();
    }

    @Override
    public void initFinish() {
        isDone = true;
        page = 1;
        LoadData();
    }

    public void showProgress(){
        empty.setVisibility(View.GONE);
        success.setVisibility(View.GONE);
        error.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
    }

    public void showError(){
        empty.setVisibility(View.GONE);
        success.setVisibility(View.GONE);
        error.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);
    }

    public void showEmpty(){
        empty.setVisibility(View.VISIBLE);
        success.setVisibility(View.GONE);
        error.setVisibility(View.GONE);
        progress.setVisibility(View.GONE);
    }

    public void showSuccess(){
        empty.setVisibility(View.GONE);
        success.setVisibility(View.VISIBLE);
        error.setVisibility(View.GONE);
        progress.setVisibility(View.GONE);
    }

    public void LoadData(){
        VolleyHelper getDataRequest = VolleyHelper.getInstance();
        getDataRequest
                .desc(URLDesc)
                .type(VolleyHelper.TYPE_PUT_ID)
                .url(url)
                .prams("operation", operation)
                .prams("page", page+"")
                .prams("size", size+"")
                .doPost(new VolleyListener.OnSuccess() {
                    @Override
                    public void onSuccess(String json) {
                        if (tv.getVisibility()==View.VISIBLE){
                            tv.setVisibility(View.GONE);
                        }
                        if (mSwipeRefreshLayout.isRefreshing()){
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                        try {
                            JSONObject j = new JSONObject(json);
                            String code = j.getString("code");
                            if (code.equals("000")){
                                if (initListData(json)) return;
                            }
                            if (code.equals("001")){

                            }
                            if (code.equals("002")){

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new VolleyErrorListener.OnError() {
                    @Override
                    public void onError(VolleyError volleyError) {
                        if (mSwipeRefreshLayout.isRefreshing()){
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                        showError();
                    }
                });
    }

    private boolean initListData(String json) {
        if (page == 1){
            isChange = false;
            try{
                data = setData(json);
                if (data == null || data.size()==0){
                    showEmpty();   //第一页返回为空
                    return true;
                }
                adapter = new ListAdapter();
                mListView.setAdapter(adapter);
                page++;
                showSuccess();
            }catch(com.google.gson.JsonSyntaxException e){
                showEmpty();
            }
        }else{
            try{
                if (setData(json).size()==0){
                    ToastUtils.showStatic("已经没有更多了");
                    page--;
                    isChange = true;
                    return true;
                }
                //比如加载到第5页的时候
                if (isChange){
                    //isChange=true表示上次加载到第6页没有数据,此时是再次加载第5页的数据
                    if (data.size()%size != 0){
                        //这里表示当前第5页的数据没有加载完,需要将集合里面上次加载的不全的第5页的数据替换为这次重新加载的第5页数据
                        data = deleteListData(data);
                        data.addAll(setData(json));
                        adapter.notifyDataSetChanged();
                    }
                    //这里表示当前第5页数据是满的,不需要替换
                    isChange = false;
                }else{
                    //isChange=false表示上次加载的第4页,此时将第5页加载的数据追加在集合里面
                    data.addAll(setData(json));
                    adapter.notifyDataSetChanged();
                }
                page++;
            }catch(com.google.gson.JsonSyntaxException e){
                ToastUtils.showStatic("已经没有更多了");
            }
        }
        return false;
    }

    public class ListAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            if (data!=null){
                return data.size();
            }
            return 0;
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return setItemView(position, convertView, data);
        }
    }

    /**
     * 删除集合最后面的不满一页的数据
     * @param data
     * @return
     */
    public List deleteListData(List data) {
        int a = data.size();
        int b = a/size;
        int c = a%size;
        for (int i = 0; i < c; i++) {
            data.remove(b*size);
        }
        return data;
    }

    /**
     * @return 设置额外参数
     */
    public abstract String setOperation();

    /**
     * 设置URL访问解释
     * @return 名称
     */
    public abstract String setDesc();

    /**
     * @return 设置访问URL
     */
    public abstract String setURL();

    /**
     * 设置listView条目点击事件
     * @param data 数据源集合
     * @param position 点击条目的索引
     */
    public abstract void setOnItemClick(List data, int position);

    /**
     * 返回json数据经过转换之后的对象集合
     * @param s json数据
     * @return 返回数据集合
     */
    public abstract List setData(String s);

    /**
     * @param position 索引
     * @param convertView ConvertView
     * @param data
     * @return ItemView
     */
    public abstract View setItemView(int position, View convertView, List data);

    private boolean isDone; //在setUserVisibleHint()方法中用于判断该fragment是否已经完成了初始化
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        //先判断其他方法是否调用过, 是, 则执行此方法. 否, 则不执行此方法.
        //此方法执行: page重置为1, 刷新界面数据
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser&&isDone){
            showProgress();
            page=1;
            LoadData();
        }
    }

}