package com.itheima.service.impl;

import com.itheima.domain.PageBean;
import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: liwei
 * @Date: 2018-12-16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> findAll(PageBean pageBean) throws Exception {
        return userMapper.findAll(pageBean);
    }

    @Override
    public User login(User user) throws Exception {
        return userMapper.login(user);
    }

    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    @Override
    public void deleteById(int id) {
        userMapper.deleteById(id);
    }

    @Override
    public User findById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public int findTotalCount(PageBean pageBean) throws Exception {
        return userMapper.findTotalCount(pageBean);
    }

}
