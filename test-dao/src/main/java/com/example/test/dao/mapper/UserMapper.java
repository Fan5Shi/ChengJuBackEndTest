package com.example.test.dao.mapper;

import com.example.test.dao.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Mapper
public interface UserMapper {

    UserDO login(Integer userId, String password);

    UserDO findUserById(Integer userId);

    int insert(UserDO userDO);

    int update(UserDO userDO);
}
