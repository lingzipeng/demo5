package com.example.demo.student.vo;

import lombok.Data;


@Data
public class RegisterScoresModel {

    /**
     * 班级ID
     */
    private Long gradeClassId;

    /**
     * 课程ID
     */
    private Long courseId;
}
