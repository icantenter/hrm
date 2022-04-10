package com.ihrm.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected String companyId;
    protected String companyName;

    @ModelAttribute
    public void setResAnReq(HttpServletRequest req, HttpServletResponse res) {
        this.request = req;
        this.response = res;
        this.companyId = "1";
        this.companyName = "传智播客";
    }
}
