package com.example.dell.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.dell.myapplication.tree.Node;
import com.example.dell.myapplication.tree.TreeListViewAdapter;

import java.util.List;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: MyTreeListViewAdapter.java
 * @Package com.example.dell.myapplication
 * @Description: todo
 * @author: YFL
 * @date: 2018/4/28 01:01
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/4/28 星期六
 * 注意：本内容仅限于学川教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class MyTreeListViewAdapter <T>extends TreeListViewAdapter<T> {
    /**
     * @param mTree
     * @param context
     * @param datas
     * @param defaultExpandLevel 默认展开几级树
     * @param isHide
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public MyTreeListViewAdapter(ListView mTree, Context context, List<T> datas, int defaultExpandLevel, boolean isHide) throws IllegalArgumentException, IllegalAccessException {
        super(mTree, context, datas, defaultExpandLevel, isHide);
    }



    @Override
    public View getConvertView(Node node, int position, View convertView, ViewGroup parent) {


        return null;
    }
}
