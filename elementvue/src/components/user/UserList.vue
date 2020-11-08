<template>
  <div>
    <el-table
      :data="tableData.filter(data => !search || data.username.toLowerCase().includes(search.toLowerCase()))"
      style="width: 100%">

      <el-table-column
        label="编号"
        width="180" prop="id">
      </el-table-column>

      <el-table-column
        label="姓名"
        width="180" prop="username">
      </el-table-column>

      <el-table-column label="年龄" width="180" prop="age">
      </el-table-column>

      <el-table-column label="外号" width="300" prop="content">
      </el-table-column>
      <el-table-column label="操作" width="200">
        <template slot="header" slot-scope="scope">
          <el-input
            v-model="search"
            size="mini"
            placeholder="输入关键字搜索"/>
        </template>

        <template slot-scope="scope">
          <el-button
            size="mini"
            @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="sizeChange"
      @current-change="currentChange"
      layout="prev, pager, next,total,sizes,jumper"
      :total="total"
      :current-page="currentPage"
      :page-size="pageSize"
      :page-sizes="[2,3,4,5,6]"
      :background="true"
      prev-text="上一頁"
      next-text="下一頁"
    >
    </el-pagination>
    <el-button style="margin-top:20px" type="success" size="mini" @click="showFlag=!showFlag">
      添加
    </el-button>

    <transition name="el-zoom-in-center">
      <div v-show="!showFlag" class="transition-box">
        <el-form :hide-required-asterisk="false" :rules="rules" ref="form" :model="form" label-width="80px" label-suffix=":">
          <el-form-item label="姓名" prop="username">
            <el-input v-model="form.username"></el-input>
          </el-form-item>
          <el-form-item label="年龄" prop="age">
            <el-input v-model="form.age"></el-input>
          </el-form-item>
          <el-form-item label="称号" prop="content">
            <el-input type="textarea" v-model="form.content"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit('form')">提交</el-button>
            <el-button @click="clearForm">取消</el-button>
          </el-form-item>
        </el-form>
      </div>
    </transition>
  </div>
</template>

<script>
    export default {
        name: "UserList",
      data() {
        return {
          tableData: [],
          search: '',
          showFlag:true,
          form: {
            username: '',
            age: '',
            content: ''
          },
          rules: {
            username: [
              { required: true, message: '请输入名字', trigger: 'blur' },
              { min: 2, max: 4, message: '长度在 2 到 4 个字符', trigger: 'blur' }
            ],
            age: [
              { required: true, message: '请输入年龄', trigger: 'blur' }
            ],
            content: [
              { required: true, message: '请输入称号', trigger: 'blur' }
            ]
          },
          currentPage:1,
          pageSize:4,
          total:1
        }
      },
      methods: {
        handleEdit(index, row) {
          console.log(index, row);
          this.$http.get("http://localhost:8024/user/getuser?id="+row.id).then((resp)=>{
            this.form = resp.data.userInfo;
            this.showFlag = false;
          })
        },
        handleDelete(index, row) {
          console.log(index, row);
          this.$http.delete("http://localhost:8024/user/deleteuser?id="+row.id).then((resp)=>{
            if(resp.data.status){
              this.form = {};
              this.showFlag = true;
              this.$message({
                message: '恭喜你，'+resp.data.msg,
                type: 'success'
              });
              this.findAll();
            }else {
              this.$message.error('错了哦，'+resp.data.msg);
            }
          })
        },
        findAll(page,size){
          page = page?page:this.currentPage;
          size = size?size:this.pageSize;

          this.$http.get("http://localhost:8024/user/findByPage?start="+page+"&pageSize="+size)
            .then((resp)=>{
              this.tableData = resp.data.users;
              this.total = resp.data.total;
            });
        },
        onSubmit(form) {
          this.$refs[form].validate((valid) => {
            if (valid) {
              this.$http.post("http://localhost:8024/user/adduser",this.form).then((resp)=>{
                console.log(resp.data);
                if(resp.data.status){
                  this.form = {};
                  this.showFlag = true;
                  this.$message({
                    message: '恭喜你，'+resp.data.msg,
                    type: 'success'
                  });
                  this.findAll();
                }else {
                  this.$message.error('错了哦，'+resp.data.msg);
                }
              })
            } else {
              this.$message.error("请填写必填项！");
              return false;
            }
          });
        },
        clearForm(){
          this.form = {};
        },
        sizeChange(size){
          this.pageSize = size;
          this.findAll(this.currentPage,size);
          console.log("asdfasdf"+size);
          console.log("asdfasdf"+this.currentPage)
        },
        currentChange(rows){
          this.currentPage = rows;
          this.findAll(rows,this.pageSize);
          console.log(this.pageSize);
          console.log(rows);
        }
      },
      created() {
          this.findAll();
      },

    }
</script>

<style scoped>
  .transition-box {
    margin-bottom: 10px;
    width: 100%;
    height: 350px;
    border-radius: 4px;
    padding: 40px 20px;
    box-sizing: border-box;
    margin-right: 20px;
  }
</style>
