package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 商品信息：(ProductInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ProductInformation")
public class ProductInformation implements Serializable {

    // ProductInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_information_id")
    private Integer product_information_id;

    // 商品图
    @Basic
    private String commodity_map;
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
    // 库存
    @Basic
    private String stock;
    // 价格
    @Basic
    private Integer price;
    // 供货商用户
    @Basic
    private Integer supplier_user;
    // 供货商名
    @Basic
    private String supplier_name;
    // 商品介绍
    @Basic
    private String product_introduction;

    // 点击数
    @Basic
    private Integer hits;

    // 点赞数
    @Basic
    private Integer praise_len;

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
