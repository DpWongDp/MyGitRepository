package com.dp.vue.dao;

import com.dp.vue.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Description: vue
 * Created by DP on 2020/10/22 12:58
 */
@Mapper
public interface UserDao {
    public List<User> findAll();

    public User getUser(Integer id);

    public int addUser(User user);

    public void deleteUserById(Integer id);

    public void updateUserById(User user);

    public List<User> findByPage(Integer start,Integer pageSize);

    public Long getTotal();
}


