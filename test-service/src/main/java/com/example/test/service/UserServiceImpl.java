package com.example.test.service;

import com.example.test.api.enums.HttpCode;
import com.example.test.api.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Component;

import com.example.test.dao.dataobject.UserDO;
import com.example.test.dao.mapper.UserMapper;
import com.example.test.api.UserService;
import com.example.test.api.model.UserModel;
import org.springframework.util.CollectionUtils;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    private static final BeanCopier copier = BeanCopier.create(UserModel.class, UserDO.class, false);

    @Override
    public ResultDO login(Integer userId, String password) {
        if (userId == 0 || password == null) {
            return new ResultDO(HttpCode.FAIL.getCode(), "输入参数不能为0或空!");
        }
        UserDO userDO = userMapper.findUserById(userId);
        System.out.println(userDO.toString());
        if (userDO == null) {
            return new ResultDO(HttpCode.FAIL.getCode(), "不存在该用户！");
        }
        if (!userDO.getPassword().equals(password)) {
            return new ResultDO(HttpCode.FAIL.getCode(), "用户密码错误！");
        }
        return new ResultDO(HttpCode.SUCCESS.getCode(), "登录成功", userDO);
    }

    @Override
    public ResultDO findUserById(Integer userId) {
        if (userId == null) {
            return new ResultDO(HttpCode.FAIL.getCode(), "输入的学号不能为空或0");
        }
        UserDO userDO = userMapper.findUserById(userId);
        if (userDO == null) {
            return new ResultDO(HttpCode.FAIL.getCode(), "不存在此用户");
        }
        return new ResultDO(HttpCode.SUCCESS.getCode(), "查找成功", userDO);
    }

    @Override
    public ResultDO insert(UserDO userDO) {
        int influencedLines = userMapper.insert(userDO);
        if (influencedLines <= 0) {
            return new ResultDO(HttpCode.FAIL.getCode(), "插入失败");
        }
        return new ResultDO(HttpCode.SUCCESS.getCode(), "插入成功", influencedLines);
    }

    @Override
    public ResultDO update(UserDO userDO) {
        int influencedLines = userMapper.update(userDO);
        if (influencedLines <= 0) {
            return new ResultDO(HttpCode.FAIL.getCode(), "更新失败");
        }
        return new ResultDO(HttpCode.SUCCESS.getCode(), "更新成功", influencedLines);
    }

//    public String getUserName(Long id) {
//        UserDO userDO = userMapper.getById(id);
//        return userDO != null ? userDO.getName() : null;
//    }
//
//    public UserModel addUser(UserModel user) {
//        UserDO userDO = new UserDO();
//        copier.copy(user, userDO, null);
//
//        Long id = userMapper.insert(userDO);
//        user.setId(id);
//        return user;
//    }
}
