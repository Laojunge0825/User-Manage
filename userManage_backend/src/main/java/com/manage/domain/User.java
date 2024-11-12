package com.manage.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 
     */
    @TableId("user_id")
    private Long userId;

    /**
     * 
     */
    private String userName;

    /**
     * 
     */
    private Integer age;

    /**
     * 
     */
    private Date birthday;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}