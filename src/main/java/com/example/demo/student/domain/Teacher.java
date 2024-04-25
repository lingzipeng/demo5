package com.example.demo.student.domain;

import com.example.demo.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

/**功能描述：教师信息实体类
 */
@Data
@Entity
@Table(name = "s_teacher")
@org.hibernate.annotations.Table(appliesTo = "s_teacher",comment="教师信息表")
public class Teacher extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 教师工号
     */
    @Column(name = "teach_no")
    private String teachno;

    /**
     * 教师姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 教师性别
     */
    @Column(name = "sex")
    private String sex;

    /**
     * 手机号
     */
    @Column(name = "phone")
    private String phone;

    /**
     * QQ号
     */
    @Column(name = "qq")
    private String qq;


    /**
     * 教授科目
     */
    @OneToOne
    @JoinColumn(name = "course_id",referencedColumnName="id")
    private Course course;

}
