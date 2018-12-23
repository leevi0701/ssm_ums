package com.itheima.mapper;

import com.itheima.domain.PageBean;
import com.itheima.domain.User;

import java.util.List;

/**
 * @author: liwei
 * @Date: 2018-12-16
 */
public interface UserMapper {

    List<User> findAll(PageBean pageBean) throws Exception;

    User login(User user) throws Exception;

    void save(User user);

    void deleteById(int id);

    User findById(int id);

    void update(User user);

    int findTotalCount(PageBean pageBean) throws Exception;
}
