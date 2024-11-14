package com.manage.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
    //  后端传long类型的值给前端，当数据大于17位时。前端第16位会四舍五入，17位后的用0代替。在Json中会出现精度丢失的情况
    //  第一种：  使用  JsonSerialize(using = ToStringSerializer.class)  对字段Json序列化
//    @JsonSerialize(using = ToStringSerializer.class)
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
    private String birthdayStr;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}