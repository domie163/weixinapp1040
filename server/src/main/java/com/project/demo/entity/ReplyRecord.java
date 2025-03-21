package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 回复记录：(ReplyRecord)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ReplyRecord")
public class ReplyRecord implements Serializable {

    // ReplyRecord编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_record_id")
    private Integer reply_record_id;

    // 供货商用户
    @Basic
    private Integer supplier_user;
    // 供货商名
    @Basic
    private String supplier_name;
    // 用户名称
    @Basic
    private Integer user_name;
    // 咨询主题
    @Basic
    private String consultation_topic;
    // 回复内容
    @Basic
    private String reply_content;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
