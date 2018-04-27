package com.example.dell.myapplication;

import java.io.Serializable;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: UserEntity.java
 * @Package com.example.dell.myapplication
 * @Description: todo
 * @author: YFL
 * @date: 2018/4/27 23:51
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018/4/27 星期五
 * 注意：本内容仅限于学川教育有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class UserEntity implements Serializable {
        private static final long serialVersionUID = -5683263669918171030L;

        private String userName;
        // 原始密码

        public String getUserName ()
        {
            return userName;
        }

        public void setUserName (String userName)
        {
            this.userName = userName;
        }

        public String getPassword ()
        {
            return password;
        }

        public void setPassword (String password)
        {
            this.password = password;
        }

        private String password;

}
