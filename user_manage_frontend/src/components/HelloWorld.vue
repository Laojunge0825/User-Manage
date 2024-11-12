<template>
  <div>
    <div style="margin-bottom: 15px">
      <el-input v-model="pageVo.userName" style="width: 200px;margin-left: 5px" placeholder="请输入姓名"></el-input>
      <el-button type="warning" style="margin-left: 10px" @click="findTableList()">查询</el-button>
      <el-button type="primary" style="margin-left: 10px" @click="addForm()">新增</el-button>
    </div>
  <div>
  <el-table
      :data="tableData"
      border
      style="width: 100%">
    <el-table-column
        prop="userName"
        label="用户姓名"
        width="150">
    </el-table-column>
    <el-table-column
        prop="age"
        label="用户年龄"
        width="120">
    </el-table-column>
    <el-table-column
        prop="birthday"
        label="用户生日"
        width="120"
        :formatter="dateFormatter">
    </el-table-column>
    <el-table-column
        label="操作"
        width="160">
      <template slot-scope="scope">
        <el-button @click="updateForm(scope.row)" type="primary" size="small">修改</el-button>
        <el-button @click="deleteOne(scope.row)" type="danger" size="small">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
  </div>
  <div id="pagination" style="margin-top: 10px">
    <el-pagination
        @size-change="PageSizeChange"
        @current-change="PageCurrentChange"
        :current-page="pageVo.pageNum"
        :page-sizes="[5, 10, 15, 20]"
        :page-size="pageVo.pageSize"
        background
        layout="total, sizes, prev, pager, next"
        :total="total">
    </el-pagination>
  </div>

    <div id="addForm">
      <el-dialog title="请填写信息" :visible.sync="IsAddForm" width="30%">
        <el-form :model="userInfo">

          <el-form-item label="姓名" label-width="15%">
            <el-input v-model="userInfo.userName" autocomplete="off" style="width: 90%;" ></el-input>
          </el-form-item>

          <el-form-item label="年龄" label-width="15%">
            <el-input v-model.number="userInfo.age" autocomplete="off" style="width: 90%;"></el-input>
          </el-form-item>

          <el-form-item label="生日" label-width="15%">
            <el-date-picker
                v-model="userInfo.birthday"
                type="datetime"
                placeholder="选择日期时间">
            </el-date-picker>

          </el-form-item>


        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="cancelAddForm()">取 消</el-button>
          <el-button type="primary" @click="submitAddForm()">确 定</el-button>
        </div>
      </el-dialog>
    </div>

    <div id="updateForm">
      <el-dialog title="请填写信息" :visible.sync="IsUpdateForm" width="30%">
        <el-form :model="userInfo">

          <el-form-item label="姓名" label-width="15%">
            <el-input v-model="userInfo.userName" autocomplete="off" style="width: 90%;" ></el-input>
          </el-form-item>

          <el-form-item label="年龄" label-width="15%">
            <el-input v-model.number="userInfo.age" autocomplete="off" style="width: 90%;"></el-input>
          </el-form-item>

          <el-form-item label="生日" label-width="15%">
            <el-date-picker
                v-model="userInfo.birthday"
                type="datetime"
                placeholder="选择日期时间">
            </el-date-picker>

          </el-form-item>


        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="cancelUpdateForm()">取 消</el-button>
          <el-button type="primary" @click="submitUpdateForm()">确 定</el-button>
        </div>


      </el-dialog>
    </div>

  </div>
</template>

<script>

import {findByPage , deleteById , saveOrUpdate} from "@/api/user"

export default {
  name: 'HelloWorld',
  data() {
    return {
      IsAddForm:false,
      IsUpdateForm:false,
      tableData: [{
        userName: '王潇',
        age: 2,
        birthday: '2000-05-05'
      }],
      pageVo:{
        pageSize:5,
        pageNum:1,
        userName:''
      },
      userInfo:{

      },
      total:0
    }
  },

  created() {
    this.findTableList()
  },
  methods: {
    findTableList(){
      findByPage(this.pageVo).then( res => {
        this.tableData = res.data.data.records
        this.total =res.data.data.total
        console.log(this.total)
      });
    },

    // 日期转换
    dateFormatter(row, column, cellValue) {
      const date = new Date(cellValue);
      return `${date.getFullYear()}-${date.getMonth() + 1}-${date.getDate()}`;
    },
    // 翻页
    PageSizeChange(val){
      this.pageVo.pageSize = val;
      this.findTableList();
    },
    // 切换条数
    PageCurrentChange(val){
      this.pageVo.pageNum = val;
      this.findTableList();
    },

    // 打开新增表单
    addForm(){
      this.IsAddForm = true
    },
    // 取消 新增
    cancelAddForm(){
      this.IsAddForm = false
      this.userInfo = {}
    },
    // 提交新增表单
    async  submitAddForm(){
      await saveOrUpdate(this.userInfo)
      this.cancelAddForm()
      this.findTableList()

    },

    // 删除一条用户信息
    deleteOne(row){
      this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
        center: true
      }).then(() => {
        deleteById(row.userId).then(
            ()=>{
              this.$message({
                    type: 'success',
                    message: '删除成功!'
                  },
                  this.findTableList()
              )
            }
        )
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },

    //打开修改表单
    updateForm(row){
      this.IsUpdateForm = true
      this.userInfo = row
    },
    //取消修改表单
    cancelUpdateForm(){
      this.IsUpdateForm = false
      this.userInfo = {}
    },
    //提交修改表单
    async submitUpdateForm(){
      await  saveOrUpdate(this.userInfo)
      this.cancelUpdateForm()
      this.findTableList()
    },

  },


}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
