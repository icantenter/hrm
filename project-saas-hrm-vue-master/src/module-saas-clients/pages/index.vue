<template>
  <div class="dashboard-container">
    <div class="app-container">
      <el-card shadow="never">
        <!-- 数据 -->

        <el-table :data="dataList" style="width: 100%" max-height="250">
          <el-table-column fixed type="index" label="序号" width="50">
          </el-table-column>

          <el-table-column
            fixed
            prop="name"
            label="企业名称"
            width="150"
          ></el-table-column>
          <el-table-column
            fixed
            prop="version"
            label="版本"
            width="150"
          ></el-table-column>
          <el-table-column
            fixed
            prop="companyPhone"
            label="联系电话"
            width="150"
          ></el-table-column>
          <el-table-column
            fixed
            prop="legalRepresentative"
            label="联系人"
            width="150"
          ></el-table-column>
          <el-table-column
            fixed
            prop="expirationDate"
            label="截止时间"
            width="150"
          ></el-table-column>
          <el-table-column
            fixed
            prop="companyArea"
            label="所在地区"
            width="150"
          ></el-table-column>
          <el-table-column fixed prop="state" label="状态" width="150">
            <template slot-scope="scope">
              <el-switch
                v-model="scope.row.state"
                disabled
                inactive-value="0"
                active-value="1"
                active-color="#13ce66"
                inactive-color="#ff4949"
              >
              </el-switch>
            </template>
          </el-table-column>

          <el-table-column fixed="right" label="操作" width="120">
            <template slot-scope="scope">
              <router-link :to="'/saas-clients/details/' + scope.row.id"
                >查看</router-link
              >
            </template>
          </el-table-column>
        </el-table>

        <!-- end -->
      </el-card>
    </div>
  </div>
</template>

<script>
import { list } from "@/api/base/saasClient";
export default {
  name: "saas-clients-index",
  data() {
    return {
      dataList: [],
    };
  },
  methods: {
    getList() {
      list().then((res) => {
        this.dataList = res.data.data;
        console.log(this.dataList);
      });
    },
  },

  created() {
    this.getList();
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
