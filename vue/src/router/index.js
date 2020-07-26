import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
    {
      path: '/',
      name: 'login', //登录界面
      component: () => import('@/components/common/login')
    },
    {
      path: '/index', //教师主页
      component: () => import('../views/admin/index.vue'),
      children: [
        {
          path: '/', //首页默认路由
          component: () => import('@/components/common/hello')
        },
        {
          path:'/grade', //学生成绩
          component: () => import('@/components/echarts/grade')
        },
        {
          path: '/selectExamToPart', //学生分数段
          component: () => import('@/views/teacher/selectExamToPart')
        },
        {
          path: '/scorePart',
          component: () => import('@/components/echarts/scorePart')
        },
        {
          path: '/allStudentsGrade', //所有学生成绩统计
          component: () => import('@/views/teacher/allStudentsGrade')
        },
        {
          path: '/examDescription', //考试管理功能描述
          component: () => import('@/views/teacher/examDescription')
        },
        {
          path: '/selectExam', //查询所有考试
          component: () => import('@/views/teacher/selectExam')
        },
        {
          path: '/addExam', //添加考试
          component: () => import('@/views/teacher/addExam')
        },
        {
          path: '/answerDescription', //题库管理功能介绍
          component: ()=> import('@/views/teacher/answerDescription')
        },
        {
          path: '/selectAnswer', //查询所有题库
          component: () => import('@/views/teacher/selectAnswer')
        },
        {
          path: '/addAnswer', //增加题库主界面
          component: () => import('@/views/teacher/addAnswer')
        },
        {
          path: '/addAnswerChildren', //点击试卷跳转到添加题库页面
          component: () => import('@/views/teacher/addAnswerChildren')
        },
        {
          path: '/studentManage', //学生管理界面
          component: () => import('@/views/teacher/studentManage')
        },
        {
          path: '/addStudent', //添加学生
          component: () => import('@/views/teacher/addStudent')
        },
        {
          path: '/teacherManage',
          component: () => import('../views/admin/tacherManage')
        },
        {
          path: '/addTeacher',
          component: () => import ('../views/admin/addTeacher')
        }
      ]
    },
    {
      path: '/student', //学生主页
      component: () => import('@/views/student/index'),
      children: [
        {path:"/",component: ()=> import('@/views/student/myExam')},
        {path:'/startExam', component: () => import('@/views/student/startExam')},
        {path: '/manager', component: () => import('@/views/student/manager')},
        {path: '/examMsg', component: () => import('@/views/student/examMsg')},
        {path: '/message', component: () => import('@/views/student/message')},
        {path: '/studentScore', component: () => import("@/views/student/answerScore")},
        {path: '/scoreTable', component: () => import("@/views/student/scoreTable")}
      ]
    },
    //答题时的页面路由
    {path: '/answer',component: () => import('@/views/student/answer')}
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
