# 在线考试系统

* ## 系统介绍

     该项目是一个前后端分离，基于 RESTFUL 风格接口的项目。后台使用 SpringBoot，前端使用 VUE 和 Element-UI 组件库配合完成开发。
     该项目使用mysql数据库，采用JPA风格，是一个很基础前后端分离到项目，对于初学者来说十分友好。

## 项目启动

### 1 mysql数据库准备
打开mysql数据库，新建一个数据库，命名为exam。
```mysql
create database exam;
```

然后运行sql文件夹下的exam.sql,找到文件的路径位置
执行下面sql语句

```mysql
source ***/exam.sql;
```

### 2 springboot启动
使用IDE打开spingboot项目，
直接运行 `src/main/java/com/exam/`下的**ExamsystemApplication.java**即可启动项目

### 3 vue启动

```
# install dependencies
npm install --save

# serve with hot reload at localhost:8090
npm run serve
```
## 运行效果截图
![输入图片说明](https://images.gitee.com/uploads/images/2019/1219/204347_293d0715_5421355.png "屏幕截图.png")

![输入图片说明](https://images.gitee.com/uploads/images/2019/1219/204500_0dab0241_5421355.png "屏幕截图.png")

![输入图片说明](https://images.gitee.com/uploads/images/2019/1219/204600_ea94ddc0_5421355.png "屏幕截图.png")