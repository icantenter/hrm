package com.ihrm.domain.company.response;

import java.util.List;

import com.ihrm.domain.company.Company;
import com.ihrm.domain.company.Department;

import lombok.Data;

@Data
public class DeptListResult {
    private String companyId;
    private String companyName;
    private String companyManage;
    private List<Department> depts;

    public DeptListResult(Company company, List<Department> depts) {
        this.companyId = company.getId();
        this.companyName = company.getName();
        this.companyManage = company.getLegalRepresentative();
        this.depts = depts;
    }

}