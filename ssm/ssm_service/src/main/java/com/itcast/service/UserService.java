package com.itcast.service;

import com.itcast.domain.PageBean;
import com.itcast.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAll(PageBean pageBean) throws Exception;
    User findLogin(User user) throws Exception;
    int findCount(PageBean pageBean) throws Exception;
    void saveUser(User user)throws Exception;
    User findById(Integer id) throws Exception;
    void updateUser(User user) throws Exception;
    void deleteUser(Integer id)throws Exception;
    void deleteAll(int[] its)throws Exception;
}

