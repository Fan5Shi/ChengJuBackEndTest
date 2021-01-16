package com.example.test.web;

import com.example.test.api.enums.HttpCode;
import com.example.test.api.result.ResultDO;
import com.example.test.dao.dataobject.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.test.api.UserService;
import com.example.test.api.model.UserModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Component
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 必须使用JSON格式
     * @param userDO
     * @return
     */
    @RequestMapping(value="/register", method= RequestMethod.POST)
    @ResponseBody
    public ResultDO addUser(@RequestBody UserDO userDO) {
        System.out.println(userDO.toString());
        try {
            ResultDO resultDO = userService.insert(userDO);
            return resultDO;
        } catch (Exception e) {
            return new ResultDO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    @RequestMapping(value="/login", method= RequestMethod.POST)
    @ResponseBody
    public ResultDO findUser(@RequestParam("userId") Integer userId,
                             @RequestParam("password") String password) {
        try {
            ResultDO resultDO = userService.login(userId, password);
            return resultDO;
        } catch (Exception e) {
            return new ResultDO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    @RequestMapping(value="/mine/{userId}", method= RequestMethod.GET)
    @ResponseBody
    public ResultDO getUserInfo(@PathVariable("userId") Integer userId) {
        try {
            ResultDO resultDO = userService.findUserById(userId);
            return resultDO;
        } catch (Exception e) {
            return new ResultDO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    @RequestMapping(value="/mine/update", method= RequestMethod.PUT)
    @ResponseBody
    public ResultDO updateUser(@RequestBody UserDO userDO) {
        try {
            ResultDO resultDO = userService.update(userDO);
            return resultDO;
        } catch (Exception e) {
            return new ResultDO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }
}
