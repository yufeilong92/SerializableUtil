package com.example.dell.myapplication;

import android.app.Application;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: mAPP.java
 * @Package com.example.dell.myapplication
 * @Description: todo
 * @author: YFL
 * @date: 2018/4/28 09:26
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/4/28 星期六
 * 注意：本内容仅限于学川教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class mAPP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreUtil.initSharedPreference(this);
    }
}
