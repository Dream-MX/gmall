package com.leixiang.gmall.user.service.impl;

import com.leixiang.gmall.user.bean.UserInfo;
import com.leixiang.gmall.user.mapper.UserInfoMapper;
import com.leixiang.gmall.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author leixiang
 * @version 1.0.0
 * @ClassName UserServiceImpl
 * @create 2019-12-03 16:26
 * @Description TODO
 */
public class UserServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> findAll() {
        //查询所有用户
        return userInfoMapper.selectAll();

    }

    @Override
    public void addUser(UserInfo userInfo) {
        //有条件添加用户
        userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        //通过主键有条件修改用户
        // userInfoMapper.updateByPrimaryKeySelective(userInfo);

        //通过用户自定义条件有条件修改用户
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("nickName",userInfo.getNickName());
        userInfoMapper.updateByExampleSelective(userInfo,example);

    }

    @Override
    public void deleteUser(UserInfo userInfo) {
        //根据用户信息删除用户，匹配任一字段即可删除
        userInfoMapper.delete(userInfo);
    }

    @Override
    public List<UserInfo> getgetUserByExample(String nickName) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("nickName","%"+nickName+"%");
        return userInfoMapper.selectByExample(example);
    }
}
