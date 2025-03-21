package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 预约订单：(AppointmentOrder)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "AppointmentOrder")
public class AppointmentOrder implements Serializable {

    // AppointmentOrder编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_order_id")
    private Integer appointment_order_id;

    // 订单号
    @Basic
    private String order_number;
    // 商品名称
    @Basic
    private String trade_name;
    // 商品类型
    @Basic
    private String product_type;
    // 商品参数
    @Basic
    private String product_parameters;
    // 规格
    @Basic
    private String specifications;
    // 供货商用户
    @Basic
    private Integer supplier_user;
    // 供货商名
    @Basic
    private String supplier_name;
    // 价格
    @Basic
    private String price;
    // 订购数量
    @Basic
    private Integer order_quantity;
    // 订购金额
    @Basic
    private String order_amount;
    // 是否鉴定
    @Basic
    private String whether_to_identify;
    // 鉴定费用
    @Basic
    private String appraisal_fees;
    // 总金额
    @Basic
    private String total_amount;
    // 用户名称
    @Basic
    private Integer user_name;
    // 取货方式
    @Basic
    private String pickup_method;
    // 收货人
    @Basic
    private String consignee;
    // 收货电话
    @Basic
    private String receiving_phone_number;
    // 收货地址
    @Basic
    private String shipping_address;



    // 审核状态
    @Basic
    private String examine_state;

    // 支付状态
    @Basic
    private String pay_state;

    // 支付类型: 微信、支付宝、网银
    @Basic
    private String pay_type;







    // 审核回复
    @Basic
    private String examine_reply;



    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
