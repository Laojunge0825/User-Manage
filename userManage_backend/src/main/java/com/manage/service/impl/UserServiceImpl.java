package com.manage.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manage.domain.User;
import com.manage.mapper.UserMapper;
import com.manage.service.UserService;
import com.manage.util.Result;
import com.manage.vo.PageVo;
import org.springframework.stereotype.Service;


/**
* @author 16422
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-11-08 15:31:03
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {


    @Override
    public Result saveOrUpdateOne(User user) {
        int res ;
        if(user.getUserId() != null){
            res = baseMapper.updateById(user);
            if(res == 1){
                return Result.toOk("修改成功");
            }else {
                return Result.toFiled("修改失败，id不存在");
            }
        }else{
            user.setUserId(System.currentTimeMillis());
            res = baseMapper.insert(user);
            if(res == 1){
                return Result.toOk("添加成功");
            }else {
                return Result.toFiled("添加失败");
            }

        }

    }

    @Override
    public Result deleteOne(long userId) {
        int res= baseMapper.deleteById(userId);
        if(res == 1){
            return Result.toOk("删除成功");
        }else {
            return Result.toFiled("删除失败,id不存在");
        }

    }

    @Override
    public Page<User> findByPage(PageVo pageVo) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        if(pageVo.getUserName() != null){
            wrapper.like(User::getUserName,pageVo.getUserName());
        }
        return baseMapper.selectPage(new Page<>(pageVo.getPageNum(),pageVo.getPageSize()),wrapper);
    }
}




