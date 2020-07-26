//查询所有题库
<template>
  <div class="exam">
    <el-table :data="allQuestions" >
      <el-table-column prop="subject" label="试卷名称" width="180"></el-table-column>
      <el-table-column prop="question" label="题目信息" width="490"></el-table-column>
      <el-table-column prop="type" label="题目类型" ></el-table-column>
      <el-table-column prop="score" label="试题分数" ></el-table-column>
      <el-table-column prop="level" label="难度等级"></el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pagination.current"
      :page-sizes="[6, 10]"
      :page-size="pagination.size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="pagination.total"
      class="page"
    ></el-pagination>
  </div>
</template>

<script>
export default {
  data() {
    return {
      pagination: {
        //分页后的考试信息
        current: 0, //当前页
        total: null, //记录条数
        size: 6 //每页条数
      },
      allQuestions : [],
    };
  },
  created() {
    this.getAnswerInfo();
  },
  methods: {
    getAnswerInfo() {
      //分页查询所有试卷信息
      this.$axios(
        `/api/answers/${this.pagination.current}/${this.pagination.size}`
      )
        .then(res => {
          var multiQuestion = res.data[1];  //选择题
          var fillQuestion = res.data[2];   //填空题
          var judgeQuestion = res.data[3];  //判断题
          
          this.allQuestions = multiQuestion.content
          this.allQuestions = this.allQuestions.concat(fillQuestion.content)
          this.allQuestions = this.allQuestions.concat(judgeQuestion.content) 

          this.pagination.total = multiQuestion.totalElements+fillQuestion.totalElements+judgeQuestion.totalElements
          this.pagination.size = multiQuestion.size+fillQuestion.size+judgeQuestion.size
          for(let i=0; i<this.allQuestions.length; i++){
            if(this.allQuestions[i].type == 1){
              this.allQuestions[i].type = "选择题"
            }else if(this.allQuestions[i].type == 2){
              this.allQuestions[i].type = "填空题"
            }else{
              this.allQuestions[i].type = "判断题"
            }
          }
        })
        .catch(error => {});
    },
    //改变当前记录条数
    handleSizeChange(val) {
      this.pagination.size = val;
      this.getAnswerInfo();
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.current = val;
      this.getAnswerInfo();
    },
  }
};
</script>
<style lang="scss" scoped>
.exam {
  padding: 0px 40px;
  .page {
    margin-top: 20px;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .edit {
    margin-left: 20px;
  }
  .el-table tr {
    background-color: #DD5862 !important;
  }
}
  .el-table .warning-row {
    background: #000 !important;
    
  }

  .el-table .success-row {
    background: #DD5862;
  }

</style>
