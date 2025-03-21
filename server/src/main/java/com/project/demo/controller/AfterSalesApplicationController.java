package com.project.demo.controller;

import com.project.demo.entity.AfterSalesApplication;
import com.project.demo.service.AfterSalesApplicationService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;


/**
 * 售后申请：(AfterSalesApplication)表控制层
 *
 */
@RestController
@RequestMapping("/after_sales_application")
public class AfterSalesApplicationController extends BaseController<AfterSalesApplication, AfterSalesApplicationService> {

    /**
     * 售后申请对象
     */
    @Autowired
    public AfterSalesApplicationController(AfterSalesApplicationService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
