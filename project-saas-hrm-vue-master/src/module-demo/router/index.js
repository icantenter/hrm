/*
 * @Author: itcast 
 * @Description: xxx业务模块 
 * @Date: 2018-04-13 16:13:27 
 * @Last Modified by: hans.taozhiwei
 * @Last Modified time: 2018-09-03 11:12:47
 */

import Layout from '@/module-dashboard/pages/layout'
const _import = require('@/router/import_' + process.env.NODE_ENV)

export default [
  {
    root: true,
    path: '/saas-demo',
    component: Layout,
    redirect: 'noredirect',
    name: 'saas-demo',
    meta: {
      title: '公司业务模块管理',
      icon: 'component'
    },
    children: [
      {
        path: 'index',
        component: _import('demo/pages/index'),
        name: 'saas-demo-index',
        meta: { title: '公司业务模块', icon: 'component', noCache: true }
      }
    ]
  }
]
