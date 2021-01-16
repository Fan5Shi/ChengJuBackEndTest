package com.example.test.dao.dataobject;

import lombok.Data;

import java.util.Date;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Data
public class UserDO {

    private Integer userId;

    private String password;

    private String userName;

    private Date userBirth;

    private String userPhone;

    public UserDO() {
    }

    public UserDO(Integer userId, String password, String userName, Date userBirth, String userPhone) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.userBirth = userBirth;
        this.userPhone = userPhone;
    }
}
