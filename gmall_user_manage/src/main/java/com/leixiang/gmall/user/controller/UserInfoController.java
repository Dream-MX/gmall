package com.leixiang.gmall.user.controller;

import com.leixiang.gmall.user.bean.UserInfo;
import com.leixiang.gmall.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName UserInfoController
 * @create 2019-12-03 16:26
 * @Description 用户管理页面
 */
@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/findAll")
    public List<UserInfo> findAll(){
        return userInfoService.findAll();
    }

    @PostMapping("/addUser")
    public void addUser(UserInfo userInfo){
        userInfoService.addUser(userInfo);
    }

    @PostMapping("/updateUser")
    public void updateUser(UserInfo userInfo){
        userInfoService.updateUser(userInfo);
    }

    @PostMapping("/deleteUser")
    public void deleteUser(UserInfo userInfo){
        userInfoService.deleteUser(userInfo);
    }

    @GetMapping("/getUserByExample")
    public List<UserInfo> getgetUserByExample(String nickName){
        return userInfoService.getgetUserByExample(nickName);
    }
}
