package com.example.demo.student.service;


import com.example.demo.student.domain.SysInvestigation;
import com.example.demo.student.service.dto.InvestigationQueryCriteria;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**功能描述：系统角色接口
 */
public interface IInvestigationService {
    /**
     * 获取角色列表数据
     * @param queryCriteria
     * @param pageable
     * @return
     */
    Object getList(InvestigationQueryCriteria queryCriteria, Pageable pageable);

    /**
     * 添加角色信息
     * @param sysInvestigation
     * @return
     */
    boolean addInvestigation(SysInvestigation sysInvestigation);

    /**
     * 根据ID获取角色详情信息
     * @param id
     * @return
     */
    SysInvestigation getById(Long id);

    /**
     * 更新角色信息
     * @param sysInvestigation
     */
    void editInvestigation(SysInvestigation sysInvestigation);

    /**
     * 删除角色信息
     * @param id
     */
    void deleteById(Long id);

    /**
     * 获取所有角色
     * @return
     */
    List<SysInvestigation> queryAll();
}
