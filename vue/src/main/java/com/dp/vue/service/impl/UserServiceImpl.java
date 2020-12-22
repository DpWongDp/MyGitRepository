package com.dp.vue.service.impl;

import com.dp.vue.dao.UserDao;
import com.dp.vue.entity.User;
import com.dp.vue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: vue
 * Created by DP on 2020/10/22 13:00
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User getUser(Integer id) {
        return userDao.getUser(id);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public void deleteUserById(Integer id) {
         userDao.deleteUserById(id);
    }

    @Override
    public void updateUserById(User user) {
        userDao.updateUserById(user);
    }

    @Override
    public List<User> findByPage(Integer start, Integer pageSize) {
        Integer startIndex = (start-1) * pageSize;
        return userDao.findByPage(startIndex,pageSize);
    }

    @Override
    public Long getTotal() {
        return userDao.getTotal();
    }
}
