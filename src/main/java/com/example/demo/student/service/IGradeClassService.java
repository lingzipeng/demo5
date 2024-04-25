package com.example.demo.student.service;


import com.example.demo.student.domain.GradeClass;
import com.example.demo.student.service.dto.GradeClassQueryCriteria;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**功能描述：班级信息业务接口
 */
public interface IGradeClassService {

    /**
     * 获取班级列表数据
     * @param queryCriteria
     * @param pageable
     * @return
     */
    Object getList(GradeClassQueryCriteria queryCriteria, Pageable pageable);

    /**
     * 添加班级信息
     * @param gradeClass
     * @return
     */
    boolean addGradeClass(GradeClass gradeClass);

    /**
     * 根据ID获取班级信息
     * @param id
     * @return
     */
    GradeClass getById(Long id);

    /**
     * 更新班级信息
     * @param gradeClass
     */
    void editGradeClass(GradeClass gradeClass);

    /**
     * 根据ID删除班级信息
     * @param id
     */
    void deleteById(Long id);

    /**
     * 获取所有班级信息
     * @param gradeClassQueryCriteria
     * @return
     */
    List<GradeClass> queryAll(GradeClassQueryCriteria gradeClassQueryCriteria);

    /**
     * 统计班级数量
     * @return
     */
    long getCount();
}
