package com.manage.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.manage.domain.User;
import com.manage.util.Result;
import com.manage.vo.PageVo;


/**
* @author 16422
* @description 针对表【user】的数据库操作Service
* @createDate 2024-11-08 15:31:03
*/
public interface UserService extends IService<User> {

    /**
     * @Author 舒克、舒克
     * @Description 新增/修改 用户
     * @Date 16:42 2024/11/8
     * @Param
     * @return
     **/
    Result saveOrUpdateOne(User user);

    /**
     * @Author 舒克、舒克
     * @Description  根据用户id删除
     * @Date 16:43 2024/11/8
     * @Param
     * @return
     **/
    Result deleteOne(long userId);

    /**
     * @Author 舒克、舒克
     * @Description  分页查询
     * @Date 16:45 2024/11/8
     * @Param
     * @return
     **/
    Page<User> findByPage(PageVo pageVo);


}
