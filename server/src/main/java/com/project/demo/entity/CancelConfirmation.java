package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 取消确认：(CancelConfirmation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "CancelConfirmation")
public class CancelConfirmation implements Serializable {

    // CancelConfirmation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cancel_confirmation_id")
    private Integer cancel_confirmation_id;

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
    // 价格
    @Basic
    private String price;
    // 订购数量
    @Basic
    private String order_quantity;
    // 订购金额
    @Basic
    private String order_amount;
    // 总金额
    @Basic
    private String total_amount;
    // 用户名称
    @Basic
    private Integer user_name;
    // 取消原因
    @Basic
    private String reason_for_cancellation;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
