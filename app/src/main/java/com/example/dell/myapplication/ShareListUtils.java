package com.example.dell.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: ShareListUtils.java
 * @Package com.example.dell.myapplication
 * @Description: todo
 * @author: YFL
 * @date: 2018/4/27 23:58
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/4/27 星期五
 * 注意：本内容仅限于学川教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class ShareListUtils {
    // 用户名key
    public final static String KEY_NAME = "YFLLONG";

    public final static String KEY_LEVEL = "TYJBAJAD";
    //    恶汉
    private static ShareListUtils s_SharedPreUtil;
    //获取sp
    private SharedPreferences msp;
    //获取对象
    private static List<UserEntity> s_User = null;

    // 初始化，一般在应用启动之后就要初始化
    public static synchronized void initSharedPreference(Context context) {
        if (s_SharedPreUtil == null) {
            s_SharedPreUtil = new ShareListUtils(context);
        }
    }

    public static ShareListUtils getInstance(){
        return s_SharedPreUtil;
    }
    public ShareListUtils(Context context) {
        msp = context.getSharedPreferences("SharedPreUtil",
                Context.MODE_PRIVATE | Context.MODE_APPEND);
    }

    public synchronized void putListUser(List<UserEntity> user) {

        SharedPreferences.Editor editor = msp.edit();

        String str = "";
        try {
            str = SerializableUtil.list2String(user);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        editor.putString(KEY_NAME, str);
        editor.commit();

        s_User = user;
    }
    public synchronized List<UserEntity> getListUser()
    {

        if (s_User == null)
        {
            s_User = new ArrayList<>();


            //获取序列化的数据
            String str = msp.getString(SharedPreUtil.KEY_NAME, "");

            try {
                List<UserEntity> list = SerializableUtil.string2List(str);
                if(list != null){
                    s_User =list;
                }

            } catch (StreamCorruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return s_User;
    }
    public synchronized void DeleteUser()
    {
        SharedPreferences.Editor editor = msp.edit();
        editor.putString(KEY_NAME,"");

        editor.commit();
        s_User = null;
    }
}
