package com.project.demo.controller;

import com.project.demo.entity.CancelConfirmation;
import com.project.demo.service.CancelConfirmationService;
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
 * 取消确认：(CancelConfirmation)表控制层
 *
 */
@RestController
@RequestMapping("/cancel_confirmation")
public class CancelConfirmationController extends BaseController<CancelConfirmation, CancelConfirmationService> {

    /**
     * 取消确认对象
     */
    @Autowired
    public CancelConfirmationController(CancelConfirmationService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        Map<String, String> maporder_number = new HashMap<>();
        maporder_number.put("order_number",String.valueOf(paramMap.get("order_number")));
        List listorder_number = service.select(maporder_number, new HashMap<>()).getResultList();
        if (listorder_number.size()>0){
            return error(30000, "字段订单号内容不能重复");
        }
        this.addMap(paramMap);
        String sql = "SELECT MAX(cancel_confirmation_id) AS max FROM "+"`cancel_confirmation`";
        Query select = service.runCountSql(sql);
        Integer max = (Integer) select.getSingleResult();
        sql = "UPDATE `product_information` INNER JOIN `cancel_confirmation` ON product_information.trade_name=cancel_confirmation.trade_name SET product_information.stock= product_information.stock + cancel_confirmation.order_quantity WHERE cancel_confirmation.cancel_confirmation_id="+max;
        select = service.runCountSql(sql);
        select.executeUpdate();
        return success(1);
    }

}
