package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 售后申请：(AfterSalesApplication)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "AfterSalesApplication")
public class AfterSalesApplication implements Serializable {

    // AfterSalesApplication编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "after_sales_application_id")
    private Integer after_sales_application_id;

    // 订单号
    @Basic
    private String order_number;
    // 商品名称
    @Basic
    private String trade_name;
    // 商品类型
    @Basic
    private String product_type;
    // 供货商用户
    @Basic
    private Integer supplier_user;
    // 供货商名
    @Basic
    private String supplier_name;
    // 售后数量
    @Basic
    private Integer after_sales_quantity;
    // 用户名称
    @Basic
    private Integer user_name;
    // 收货人
    @Basic
    private String consignee;
    // 收货电话
    @Basic
    private String receiving_phone_number;
    // 收货地址
    @Basic
    private String shipping_address;
    // 售后问题
    @Basic
    private String after_sales_issues;
    // 问题描述
    @Basic
    private String problem_description;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
