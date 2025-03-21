package com.project.demo.controller;

import com.project.demo.entity.AfterSalesResults;
import com.project.demo.service.AfterSalesResultsService;
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
 * 售后结果：(AfterSalesResults)表控制层
 *
 */
@RestController
@RequestMapping("/after_sales_results")
public class AfterSalesResultsController extends BaseController<AfterSalesResults, AfterSalesResultsService> {

    /**
     * 售后结果对象
     */
    @Autowired
    public AfterSalesResultsController(AfterSalesResultsService service) {
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
