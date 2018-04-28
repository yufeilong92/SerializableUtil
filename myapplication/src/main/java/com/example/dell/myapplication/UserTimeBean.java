package com.example.dell.myapplication;

import java.util.List;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: UserTime.java
 * @Package com.example.dell.myapplication
 * @Description: todo
 * @author: YFL
 * @date: 2018/4/28 00:56
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/4/28 星期六
 * 注意：本内容仅限于学川教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class UserTimeBean {
    private String oid;
    private String prid;
    private String sex;

    public String getPrid() {
        return prid;
    }

    public void setPrid(String prid) {
        this.prid = prid;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    private String name;
    private String time;
    private List<UserTimeBean> data;

    public UserTimeBean(String oid,String prid, String name,List<UserTimeBean> data) {
        this.oid = oid;
        this.name = name;
        this.data = data;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<UserTimeBean> getData() {
        return data;
    }

    public void setData(List<UserTimeBean> data) {
        this.data = data;
    }
}
