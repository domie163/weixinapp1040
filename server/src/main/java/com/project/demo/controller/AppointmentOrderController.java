package com.project.demo.controller;

import com.project.demo.entity.AppointmentOrder;
import com.project.demo.service.AppointmentOrderService;
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
 * 预约订单：(AppointmentOrder)表控制层
 *
 */
@RestController
@RequestMapping("/appointment_order")
public class AppointmentOrderController extends BaseController<AppointmentOrder, AppointmentOrderService> {

    /**
     * 预约订单对象
     */
    @Autowired
    public AppointmentOrderController(AppointmentOrderService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        String sql = "SELECT MAX(appointment_order_id) AS max FROM "+"`appointment_order`";
        Query select = service.runCountSql(sql);
        Integer max = (Integer) select.getSingleResult();
        sql = ("SELECT count(*) count FROM `product_information` INNER JOIN `appointment_order` ON product_information.trade_name=appointment_order.trade_name WHERE product_information.stock < appointment_order.order_quantity AND appointment_order.appointment_order_id="+max).replaceAll("&#60;","<");
        select = service.runCountSql(sql);
        Integer count = Integer.valueOf(String.valueOf(select.getSingleResult()));
        if(count>0){
            sql = "delete from "+"appointment_order"+" WHERE "+"appointment_order_id"+" ="+max;
            select = service.runCountSql(sql);
            select.executeUpdate();
            return error(30000,"库存不足！");
        }
        sql = "UPDATE `product_information` INNER JOIN `appointment_order` ON product_information.trade_name=appointment_order.trade_name SET product_information.stock= product_information.stock - appointment_order.order_quantity WHERE appointment_order.appointment_order_id="+max;
        select = service.runCountSql(sql);
        select.executeUpdate();
        return success(1);
    }

}
