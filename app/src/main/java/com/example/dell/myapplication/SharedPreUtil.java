package com.example.dell.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;
import java.io.StreamCorruptedException;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: SharedPreUtil.java
 * @Package com.example.dell.myapplication
 * @Description: todo
 * @author: YFL
 * @date: 2018/4/27 23:51
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/4/27 星期五
 * 注意：本内容仅限于学川教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class SharedPreUtil {
    // 用户名key
    public final static String KEY_NAME = "KEY_NAME";

    public final static String KEY_LEVEL = "KEY_LEVEL";


    private static SharedPreUtil s_SharedPreUtil;

    private static UserEntity s_User = null;

    private SharedPreferences msp;

    // 初始化，一般在应用启动之后就要初始化
    public static synchronized void initSharedPreference(Context context)
    {
        if (s_SharedPreUtil == null)
        {
            s_SharedPreUtil = new SharedPreUtil(context);
        }
    }

    /**
     * 获取唯一的instance
     *
     * @return
     */
    public static synchronized SharedPreUtil getInstance()
    {
        return s_SharedPreUtil;
    }

    public SharedPreUtil(Context context)
    {
        msp = context.getSharedPreferences("SharedPreUtil",
                Context.MODE_PRIVATE | Context.MODE_APPEND);
    }

    public SharedPreferences getSharedPref()
    {
        return msp;
    }


    public synchronized void putUser(UserEntity user)
    {

        SharedPreferences.Editor editor = msp.edit();

        String str="";
        try {
            str = SerializableUtil.obj2Str(user);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        editor.putString(KEY_NAME,str);
        editor.commit();

        s_User = user;
    }

    public synchronized UserEntity getUser()
    {

        if (s_User == null)
        {
            s_User = new UserEntity();


            //获取序列化的数据
            String str = msp.getString(SharedPreUtil.KEY_NAME, "");

            try {
                Object obj = SerializableUtil.str2Obj(str);
                if(obj != null){
                    s_User = (UserEntity)obj;
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
