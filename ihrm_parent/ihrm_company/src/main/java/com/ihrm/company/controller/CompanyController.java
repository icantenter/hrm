package com.ihrm.company.controller;

import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.company.service.CompanyService;
import com.ihrm.domain.company.Company;
import exception.CommonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//
@CrossOrigin
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

//    添加
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Company company) {
        companyService.add(company);
        return new Result(ResultCode.SUCCESS);
    }

//    更新
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable("id") String id, @RequestBody Company company) {
        company.setId(id);
        companyService.update(company);
        return new Result(ResultCode.SUCCESS);
    }

//    删除
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable("id") String id) {
        companyService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

//    查找
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable("id") String id) {
        Company company = companyService.findById(id);
        Result res = new Result(ResultCode.SUCCESS);
        res.setData(company);
        return res;
    }
//    查询所有
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){

        List<Company> data = companyService.findAll();
        Result res = new Result(ResultCode.SUCCESS);
        res.setData(data);
        return res;

    }
}
