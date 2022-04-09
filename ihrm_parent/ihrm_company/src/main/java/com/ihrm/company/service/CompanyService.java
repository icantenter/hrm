package com.ihrm.company.service;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.company.dao.CompanyDao;
import com.ihrm.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private IdWorker idWorker;

    // 配置idwork
    public void add(Company company) {
        String id = idWorker.nextId() + "";
        company.setId(id);
        company.setAuditState("1"); // 0 unaudited, 1 audited
        company.setState(1); // 0 inactive, 1 active
        companyDao.save(company);
    }

    public void update(Company company) {
        Company tmp = companyDao.findById(company.getId()).get();
        tmp.setName(company.getName());
        tmp.setCompanyPhone(company.getCompanyPhone());
        companyDao.save(tmp);
    }

    public void deleteById(String id) {
        companyDao.deleteById(id);
    }

    public Company findById(String id) {
        return companyDao.findById(id).get();
    }

    public List<Company> findAll() {
        return companyDao.findAll();
    }

}
