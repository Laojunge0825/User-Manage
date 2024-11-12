import axios from 'axios'



const  instance = axios.create({
    baseURL : 'http://localhost:8090' , // baseURL 会自动加在请求的地址上
    // 网络请求的公共配置
    timeout:5000
})

// 拦截器
// 发送数据之前
instance.interceptors.request.use( config => {
    config.headers['lang'] = 'zh_CN';
    // config 包含网络请求的所有信息
    return config;
}, error => {
    return Promise.reject(error)
})

// 获取数据之前/ 响应数据之前
instance.interceptors.response.use(
    res => {
        return  res.status === 200 ? Promise.resolve(res) : Promise.reject(res)
    }, error => {
        //  错误处理
        Promise.reject(error)
    }
)

export default instance;
