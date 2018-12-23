package com.itcast.service.Impl;

import com.itcast.domain.PageBean;
import com.itcast.domain.User;
import com.itcast.mapper.UserMapper;
import com.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll(PageBean pageBean) throws Exception {
        pageBean.setStart((pageBean.getCurrentPage()-1)*pageBean.getPageCount());

        return userMapper.findAll(pageBean);
    }

    @Override
    public User findLogin(User user) throws Exception {
        return userMapper.findLogin(user);
    }

    @Override
    public int findCount(PageBean pageBean) throws Exception {
       return  userMapper.findCount(pageBean);
    }

    @Override
    public void saveUser(User user) throws Exception {
        userMapper.saveUser(user);
    }

    @Override
    public User findById(Integer id) throws Exception {
        return userMapper.findById(id);
    }

    @Override
    public void updateUser(User user) throws Exception {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(Integer id) throws Exception {
        userMapper.deleteUser(id);
    }

    @Override
    public void deleteAll(int[] its) throws Exception {
        userMapper.deleteAll(its);
    }
}
