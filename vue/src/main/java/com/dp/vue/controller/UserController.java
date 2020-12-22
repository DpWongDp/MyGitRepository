package com.dp.vue.controller;

import com.dp.vue.entity.User;
import com.dp.vue.service.UserService;
import com.dp.vue.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Description: vue
 * Created by DP on 2020/10/21 14:37
 */
@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("getuser")
    public Map<String,User> getUser(Integer id){
        HashMap<String, User> map = new HashMap<>();
        System.out.println(id);
        User user = userService.getUser(id);
        if(!ObjectUtils.isEmpty(user)){
           map.put("userInfo",user);
           return map;
        }
        map.put("userInfo",null);
        return map;
    }

    @GetMapping("getusers")
    public List<User> getUsers(){
        List<User> users = userService.findAll();
        return users;
    }

    @PostMapping("saveuser")
    public String saveuser(@RequestBody User user){
        System.out.println(user.getUsername()+"年方"+user.getAge()+"江湖人称"+user.getContent());
        return "接收数据成功！";
    }

    @PostMapping("adduser")
    public Result adduser(@RequestBody User user){
        HashMap<String, String> map = new HashMap<>();
        Result result = new Result();
            if(user.getId()==null) {
                try{
                    int i = userService.addUser(user);
                    result.setStatus(true);
                    result.setMsg("添加成功！");
                }catch (Exception e){
                    e.printStackTrace();
                    result.setMsg("添加失败！");
                    result.setStatus(false);
                    return result;
                }
            }else {
                try{
                    userService.updateUserById(user);
                    result.setStatus(true);
                    result.setMsg("更新成功！");
                }catch (Exception e){
                    e.printStackTrace();
                    result.setMsg("更新失败！");
                    result.setStatus(false);
                    return result;
                }
            }
            return result;
    }

    @DeleteMapping("deleteuser")
    public Result deleteuser(Integer id){
        Result result = new Result();
        try{
            userService.deleteUserById(id);
            result.setStatus(true);
            result.setMsg("删除成功！");
        }catch (Exception e){
            result.setStatus(false);
            result.setMsg("删除失败！");
            return result;
        }
        return result;
    }

    @GetMapping("findByPage")
    public Map<String,Object> findByPage(Integer start,Integer pageSize){
        HashMap<String, Object> map = new HashMap<>();
        System.out.println(start+"==-=-=-=-=-=-"+pageSize);
        List<User> users = userService.findByPage(start, pageSize);
        Long total = userService.getTotal();
        map.put("users",users);
        map.put("total",total);
        return map;
    }

}

