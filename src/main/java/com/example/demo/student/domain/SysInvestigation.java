package com.example.demo.student.domain;

import com.example.demo.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "s_investigation")
@org.hibernate.annotations.Table(appliesTo = "s_investigation",comment="调查问卷信息表")
public class SysInvestigation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 角色名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 角色评分
     */
    @Column(name = "rating")
    private String rating;
}
