package com.manage.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.manage.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: UserMapper
 * @Description:
 * @author: 舒克、舒克
 * @Date: 2024/11/9 22:49
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

}