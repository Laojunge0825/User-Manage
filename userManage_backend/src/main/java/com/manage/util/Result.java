package com.manage.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * @ClassName: Result
 * @Description:   对接口返回信息做包装处理
 * @author: 舒克、舒克
 * @Date: 2024/11/8 15:38
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    /**
     *  | 0  | 请求成功
     *  |  1 | 请求失败
     */
    private static Integer [] status = {0,1};

    private Object data;

    /**
     *  服务器当前时间戳
     **/
    private  Long ts  = System.currentTimeMillis() ;

    private String msg;

    private Integer code;




    public static Result toOk(Object data, String msg) {

        return  new Result(data,System.currentTimeMillis(),msg,status[0]);
    }

    public static Result toOk( String msg) {
        return  new Result(null,System.currentTimeMillis(),msg,status[0]);
    }

    public static  Result  toFiled(String msg){
        return  new Result(null,System.currentTimeMillis(),msg,status[1]);
    }




}
