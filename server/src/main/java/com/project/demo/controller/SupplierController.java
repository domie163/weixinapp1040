package com.project.demo.controller;

import com.project.demo.entity.Supplier;
import com.project.demo.service.SupplierService;
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
 * 供货商：(Supplier)表控制层
 *
 */
@RestController
@RequestMapping("/supplier")
public class SupplierController extends BaseController<Supplier, SupplierService> {

    /**
     * 供货商对象
     */
    @Autowired
    public SupplierController(SupplierService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        Map<String, String> mapsupplier_user = new HashMap<>();
        mapsupplier_user.put("supplier_user",String.valueOf(paramMap.get("supplier_user")));
        List listsupplier_user = service.select(mapsupplier_user, new HashMap<>()).getResultList();
        if (listsupplier_user.size()>0){
            return error(30000, "字段供货商用户内容不能重复");
        }
        this.addMap(paramMap);
        return success(1);
    }

}
