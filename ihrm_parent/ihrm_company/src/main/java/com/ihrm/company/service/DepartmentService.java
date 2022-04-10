package com.ihrm.company.service;

import java.util.List;

import com.ihrm.common.service.BaseService;
import com.ihrm.common.utils.IdWorker;
import com.ihrm.company.dao.DepartmentDao;
import com.ihrm.domain.company.Department;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class DepartmentService extends BaseService {
    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private IdWorker idWorker;

    public void save(Department department) {
        String id = idWorker.nextId() + "";
        department.setId(id);
        departmentDao.save(department);
    }

    public void update(Department department) {
        Department tmp = departmentDao.findById(department.getId()).get();
        tmp.setName(department.getName());
        tmp.setIntroduce(department.getIntroduce());
        tmp.setCode(department.getCode());
        departmentDao.save(tmp);

    }

    public Department findById(String id) {
        return departmentDao.findById(id).get();
    }

    public List<Department> findAll(String companyId) {
        return departmentDao.findAll(getSpec(companyId));
    }

    public void deleteById(String id) {
        departmentDao.deleteById(id);
    }
}
