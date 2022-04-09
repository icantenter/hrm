<template>
  <div class="dashboard-container">
    <div class="app-container">
      <el-card shadow="never">
        <!-- 数据 -->
        <el-tabs v-model="activeName">
          <el-tab-pane label="企业信息" name="first">
            <el-form ref="form" :model="formData" label-width="200px">
              <el-form-item label="企业名称">
                <el-input
                  style="width: 250px"
                  disabled
                  v-model="formData.name"
                ></el-input>
              </el-form-item>
              <el-form-item label="公司地址">
                <el-input
                  style="width: 250px"
                  disabled
                  v-model="formData.companyAddress"
                ></el-input>
              </el-form-item>
              <el-form-item label="公司电话">
                <el-input
                  style="width: 250px"
                  disabled
                  v-model="formData.companyPhone"
                ></el-input>
              </el-form-item>
              <el-form-item label="公司邮箱">
                <el-input
                  style="width: 250px"
                  disabled
                  v-model="formData.mailbox"
                ></el-input>
              </el-form-item>
              <el-form-item label="备注">
                <el-input
                  style="width: 250px"
                  v-model="formData.remark"
                ></el-input>
              </el-form-item>

              <el-form-item>
                <el-button type="primary">立即创建</el-button>
                <el-button>取消</el-button>
              </el-form-item>
            </el-form>
          </el-tab-pane>
          <el-tab-pane label="账户信息" name="second">账户信息</el-tab-pane>
          <el-tab-pane label="交易记录" name="third">交易记录</el-tab-pane>
        </el-tabs>
        <!-- end -->
      </el-card>
    </div>
  </div>
</template>

<script>
import { detail } from "@/api/base/saasClient";
export default {
  name: "saas-clients-detail",
  data() {
    return {
      activeName: "first",
      formData: [],
    };
  },
  methods: {
    detail(id) {
      detail({ id: id }).then((res) => {
        this.formData = res.data.data;
        console.log(this.formData);
      });
    },
  },

  created() {
    var id = this.$route.params.id;
    this.detail(id);
  },
};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.alert {
  margin: 10px 0px 0px 0px;
}
.pagination {
  margin-top: 10px;
  text-align: right;
}
</style>
