package com.example.dell.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnSave;
    private Button mBtnRead;
    private String s;
    private Button mAddList;
    private Button mReadList;
    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        SharedPreUtil.initSharedPreference(this);
        ShareListUtils.initSharedPreference(this);
    }

    private void initView() {
        mBtnSave = (Button) findViewById(R.id.btn_save);
        mBtnRead = (Button) findViewById(R.id.btn_read);

        mBtnSave.setOnClickListener(this);
        mBtnRead.setOnClickListener(this);
        mAddList = (Button) findViewById(R.id.add_list);
        mAddList.setOnClickListener(this);
        mReadList = (Button) findViewById(R.id.read_list);
        mReadList.setOnClickListener(this);
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                Log.e("yfl", "onClick: ");
                add();
                break;
            case R.id.btn_read:
                Log.e("yfl", "onClick: ");
                read();
                break;
            case R.id.add_list:
                addllist();
                break;
            case R.id.read_list:
                readlist();
                break;
            case R.id.btn:
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                 startActivity(intent);
                break;
        }
    }

    private void readlist() {
        List<UserEntity> listUser = ShareListUtils.getInstance().getListUser();
        for (int i = 0; i < listUser.size(); i++) {
            UserEntity userEntity = listUser.get(i);
            Log.e("yfl", "readlist: " + userEntity.getPassword() + userEntity.getUserName());
        }
    }

    private void addllist() {
        int a = 10;
        ArrayList<UserEntity> entities = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            UserEntity entity = new UserEntity();
            entity.setUserName("小");
            entity.setPassword("2222");
            entities.add(entity);
        }
        ShareListUtils instance = ShareListUtils.getInstance();
        instance.putListUser(entities);

    }

    private void read() {
        UserEntity user = SharedPreUtil.getInstance().getUser();
        String password = user.getPassword();
        String userName = user.getUserName();
        Log.e("yfl", "read: " + password + userName);
    }

    private void add() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("xaiisad");
        userEntity.setPassword("2i3132132");
        SharedPreUtil.getInstance().putUser(userEntity);
    }


}
