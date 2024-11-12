const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,

  // 配置代理
  devServer:{
    port : 8091,
    open : true , // npm run serve 时是否直接打开浏览器
    host:'localhost',
    proxy:{
      '/api':{  // 配置代理    只有/api 开头的接口才使用代理
        target:'http://localhost:8090',  // 目标地址
        changeOrigin:true, // 允许跨域
        pathReWrite:{
          '^/api':''  // 后端请求接口路径中没有/api  用  '^/api' : '' 将 /api  去掉
        }

      }
    }
  }

})
