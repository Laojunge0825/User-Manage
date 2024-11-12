// import  axios from 'axios'

import instance from "@/utils/request";

/**
 * 分页查询
 * @param data
 * @returns {Promise<AxiosResponse<any>> | *}
 */
export function  findByPage(data){
    return  instance({
        method:'post',
        url:'user/findByPage',
        data
    })
}

/**
 * 修改或者新增 用户信息
 * @param data
 * @returns {Promise<AxiosResponse<any>> | *}
 */
export function saveOrUpdate(data){
    return instance({
        method:'post',
        url:'user/saveOrUpdateOne',
        data
    })
}

/**
 * 根据id删除
 * @param id
 * @returns {Promise<AxiosResponse<any>> | *}
 */
export function  deleteById(id){
    return instance({
        method:'get',
        url:'user/deleteOne/'+id,
    })
}

