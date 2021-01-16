package com.example.test.api;

import com.example.test.api.result.ResultDO;
import com.example.test.dao.dataobject.UserDO;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
public interface UserService {

    ResultDO login(Integer userId, String password);

    ResultDO findUserById(Integer userId);

    ResultDO insert(UserDO userDO);

    ResultDO update(UserDO userDO);
}
