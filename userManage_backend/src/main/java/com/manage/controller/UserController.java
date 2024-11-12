package com.manage.controller;

import com.manage.domain.User;
import com.manage.service.UserService;
import com.manage.util.Result;
import com.manage.vo.PageVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName: UserController
 * @Description:
 * @author: 舒克、舒克
 * @Date: 2024/11/8 15:36
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/saveOrUpdateOne")
    public Result saveOrUpdateOne(@RequestBody User user){

        return  userService.saveOrUpdateOne(user);
    }

    @RequestMapping("/deleteOne/{userId}")
    public Result deleteOne(@PathVariable("userId") long userId){

        return  userService.deleteOne(userId);
    }


    @RequestMapping("/findByPage")
    public Result findByPage(@RequestBody PageVo pageVo){

        return  Result.toOk(userService.findByPage(pageVo),"分页查询");
    }



}
