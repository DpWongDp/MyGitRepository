package com.dp.vue.service;


import com.dp.vue.entity.User;

import java.util.List;

/**
 * Description: vue
 * Created by DP on 2020/10/22 12:59
 */
public interface UserService {
    public List<User> findAll();

    public User getUser(Integer id);

    public int addUser(User user);

    public void deleteUserById(Integer id);

    public void updateUserById(User user);

    public List<User> findByPage(Integer start,Integer pageSize);

    public Long getTotal();
}
