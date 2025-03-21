package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 供货商：(Supplier)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "Supplier")
public class Supplier implements Serializable {

    // Supplier编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Integer supplier_id;

    // 供货商用户
    @Basic
    private String supplier_user;
    // 供货商名
    @Basic
    private String supplier_name;












    // 用户编号
    @Id
    @Column(name = "user_id")
    private Integer userId;


    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
