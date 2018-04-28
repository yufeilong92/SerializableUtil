package com.example.dell.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        SharedPreUtil.initSharedPreference(this);
        UserEntity user = SharedPreUtil.getInstance().getUser();
        Log.e("yfl", "onCreate: "+user.getUserName()+user.getPassword() );
    }
}
