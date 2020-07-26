const path = require('path')

module.exports = {
  // lintOnSave: false,
  devServer: {
    port: 8090,
    proxy: {
      './': {
        target: 'http://localhost:8080', //本地地址
        changeOrigin: true, //支持跨域
        ws: false,
        pathRewrite: {
          "^/api": ''  //这里理解成用‘/api’代替target里面的地址，后面组件中我们掉接口时直接用api代替 比如我要调用'http://40.00.100.100:3002/user/add'，直接写‘/api/user/add’即可
        }
      }
    }
    
    // host: 'localhost',
    // port: 8088, // can be overwritten by process.env.PORT, if port is in use, a free one will be 
    // autoOpenBrowser: true,
    // errorOverlay: true,
    // notifyOnErrors: true,
  },
}