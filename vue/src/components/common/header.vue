<!-- 顶部信息栏 -->
<template>
  <div>
    <header id="topbar">
      <el-row>
        <el-col :span="4" class="topbar-left">
          <i class="iconfont icon-kaoshi"></i>
          <span class="title" @click="index()">EXAM-SYSTEM</span>
        </el-col>
        <el-col :span="20" class="topbar-right">
          <i class="el-icon-menu" @click="toggle()"></i>
          <div class="user">
            <span>{{ user.userName }}</span>
            <img src="@/assets/img/userimg.png" class="user-img" ref="img" @click="showSetting()" />
            <transition name="fade">
              <div class="out" ref="out" v-show="login_flag">
                <ul class="info">
                  <li>
                    <a href="javascript:;" @click="showInfo()">用户信息</a>
                  </li>
                  <li class="exit" @click="exit()">
                    <a href="javascript:;">退出登录</a>
                  </li>
                </ul>
              </div>
            </transition>
          </div>
        </el-col>
      </el-row>
    </header>
    <!-- 编辑对话框-->
    <el-dialog title="用户信息" :visible.sync="dialogVisible" width="30%">
      <section>
        <el-form ref="user" :model="user" label-width="80px">
          <el-form-item label="教职号">
            <el-input v-model="user.userId" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="姓名">
            <el-input v-model="user.userName" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="角色">
            <el-input v-model="user.role" :disabled="true"></el-input>
          </el-form-item>
        </el-form>
      </section>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
    <!-- 编辑对话框-->
    <el-dialog title="管理员信息" :visible.sync="dialogVisible1" width="30%">
      <section>
        <el-form ref="form" :model="admin" label-width="80px">
          <el-form-item label="职工号">
            <el-input v-model="admin.adminId" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="姓名">
            <el-input v-model="admin.adminName"></el-input>
          </el-form-item>
          <el-form-item label="角色">
            <el-input v-model="admin.role" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="邮箱">
            <el-input v-model="admin.email"></el-input>
          </el-form-item>
          <el-form-item label="性别">
            <el-select v-model="admin.sex" placeholder="请选择">
              <el-option v-for="item in sex" :key="item.value" :value="item.value"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="电话号码">
            <el-input v-model="admin.tel"></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input v-model="admin.pwd"></el-input>
          </el-form-item>
        </el-form>
      </section>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible1 = false">取 消</el-button>
        <el-button type="primary" @click="submit()">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import store from "@/store";
import { mapState, mapMutations } from "vuex";
export default {
  data() {
    return {
      login_flag: false,
      user: {
        //用户信息
        userName: null,
        userId: null,
        role: null
      },
      admin: {
        adminId: null,
        adminName: null,
        email: null,
        pwd: null,
        tel: null,
        sex: null,
        role: null
      },
      sex: [{ value: "男" }, { value: "女" }],
      dialogVisible: false, //对话框
      dialogVisible1: false //对话框
    };
  },
  created() {
    this.getUserInfo();
  },
  computed: mapState(["flag", "menu"]),
  methods: {
    //显示、隐藏退出按钮
    showSetting() {
      this.login_flag = !this.login_flag;
    },
    showInfo() {
      if (this.user.role == "管理员") {
        this.getAdminInfo();
        this.dialogVisible1 = true;
      } else if (this.user.role == "教师") {
        this.dialogVisible = true;
      } else {
        return;
      }
    },
    submit() {
      //提交更改
      this.dialogVisible1 = false;
      this.admin.role = 0
      this.$axios({
        url: "/api/admin",
        method: "put",
        data: {
          ...this.admin
        }
      }).then(res => {
        if (res.data.code == 200) {
          this.$message({
            message: "更新成功",
            type: "success"
          });
        }
        this.getUserInfo();
      });
    },
    //左侧栏放大缩小
    ...mapMutations(["toggle"]),
    getUserInfo() {
      //获取用户信息
      let userName = this.$cookies.get("cname");
      let userId = this.$cookies.get("cid");
      let userRole = this.$cookies.get("role");
      this.user.userName = userName;
      this.user.userId = userId;
      if (userRole == 0) {
        this.user.role = "管理员";
      } else if (userRole == 1) {
        this.user.role = "教师";
      } else if (userRole == 2) {
        this.user.role = "学生";
      } else {
        return;
      }
    },
    getAdminInfo() {
      this.$axios(`/api/admin/${this.user.userId}`)
        .then(res => {
          this.admin = res.data.data;
          this.admin.role = "管理员";
        })
        .catch(error => {});
    },
    index() {
      this.$router.push({ path: "/index" });
    },
    exit() {
      let role = this.$cookies.get("role");
      this.$router.push({ path: "/" }); //跳转到登录页面
      this.$cookies.remove("cname"); //清除cookie
      this.$cookies.remove("cid");
      this.$cookies.remove("role");
      if (role == 0) {
        this.menu.pop();
      }
    }
  },
  store
};
</script>

<style scoped>
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.5s;
}
.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
  opacity: 0;
}
#topbar {
  position: relative;
  z-index: 10;
  background-color: #124280;
  height: 80px;
  line-height: 80px;
  color: #fff;
  box-shadow: 5px 0px 10px rgba(0, 0, 0, 0.5);
}
#topbar .topbar-left {
  height: 80px;
  display: flex;
  justify-content: center;
  background: rgba(0, 0, 0, 0.05);
  overflow: hidden;
}
.topbar-left .icon-kaoshi {
  font-size: 60px;
}
.topbar-left .title {
  font-size: 20px;
  cursor: pointer;
}
.topbar-right {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.topbar-right .user-img {
  width: 50px;
  height: 50px;
  border-radius: 50%;
}
.topbar-right .el-icon-menu {
  font-size: 30px;
  margin-left: 20px;
}
.topbar-right .user {
  position: relative;
  margin-right: 40px;
  display: flex;
}
.topbar-right .user .user-img {
  margin-top: 15px;
  margin-left: 10px;
  cursor: pointer;
}
.user .out {
  font-size: 14px;
  position: absolute;
  top: 80px;
  right: 0px;
  background-color: #fff;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  padding: 12px;
}
.user .out ul {
  list-style: none;
}
.user .out ul > li {
  height: 26px;
  line-height: 26px;
}
.out a {
  text-decoration: none;
  color: #000;
}
.out .exit {
  margin-top: 4px;
  padding-top: 4px;
  border-top: 1px solid #ccc;
}
.info {
  width: 80px;
}
</style>
