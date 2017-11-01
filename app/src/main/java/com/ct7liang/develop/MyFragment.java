package com.ct7liang.develop;

import android.view.View;
import android.widget.TextView;
import com.ct7liang.tangyuan.list.BaseListFragment;
import com.ct7liang.tangyuan.ui.ToastUtils;
import com.google.gson.Gson;
import java.util.List;

/**
 * Created by Administrator on 2017/11/1.
 *
 */

public class MyFragment extends BaseListFragment {

    @Override
    public String setOperation() {
        return "11";
    }

    @Override
    public String setDesc() {
        return "请求工人成功订单";
    }

    @Override
    public String setURL() {
        return "http://sabrina.iask.in/xunbr_app_server/api/generalc/wOthServiceEntry";
    }

    @Override
    public void setOnItemClick(List data, int position) {
        JustBean.DataBean bean = (JustBean.DataBean) data.get(position);
        ToastUtils.showStatic(bean.getUpdateTime());
    }

    @Override
    public List setData(String s) {
        Gson gson = new Gson();
        JustBean justBean = gson.fromJson(s, JustBean.class);
        return justBean.getData();
    }

    @Override
    public View setItemView(int position, View convertView, List data) {
        View view;
        if (convertView == null){
            view = View.inflate(getActivity(), R.layout.item_test, null);
        }else{
            view = convertView;
        }
        JustBean.DataBean bean = (JustBean.DataBean) data.get(position);
        ((TextView)view.findViewById(R.id.address)).setText(bean.getAddress());
        ((TextView)view.findViewById(R.id.customerName)).setText(bean.getCustomerName());
        ((TextView)view.findViewById(R.id.description)).setText(bean.getDescription());
        ((TextView)view.findViewById(R.id.endTime)).setText(bean.getEndTime());
        return view;
    }
}