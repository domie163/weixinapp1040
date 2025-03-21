package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 直播预约：(LiveBooking)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "LiveBooking")
public class LiveBooking implements Serializable {

    // LiveBooking编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "live_booking_id")
    private Integer live_booking_id;

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
    // 价格
    @Basic
    private String price;
    // 供货商用户
    @Basic
    private Integer supplier_user;
    // 供货商名
    @Basic
    private String supplier_name;
    // 用户名称
    @Basic
    private Integer user_name;
    // 预约时间
    @Basic
    private Timestamp time_of_appointment;
    // 直播计划
    @Basic
    private String live_streaming_plan;
    // 直播备注
    @Basic
    private String live_remarks;



    // 审核状态
    @Basic
    private String examine_state;








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
