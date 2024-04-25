package com.example.demo.student.service.dto;


import com.example.demo.annotation.EnableXuedenQuery;
import lombok.Data;

/**功能描述：课程查询条件
 */
@Data
public class CourseQueryCriteria {

    /**
     * 根据课程编号、课程名称模糊查询
     */
    @EnableXuedenQuery(blurry = "courseno,coursename")
    private String searchValue;
}
