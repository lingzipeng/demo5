package com.example.demo.student.service.impl;



import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.example.demo.student.domain.SysInvestigation;
import com.example.demo.student.repository.SysInvestigationRepository;
import com.example.demo.student.service.IInvestigationService;
import com.example.demo.student.service.dto.InvestigationQueryCriteria;
import com.example.demo.utils.PageUtil;
import com.example.demo.utils.QueryHelp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**功能描述：系统角色接口实现类
 */
@Service
@Transactional(readOnly = true)
public class SysInvestigationServiceImpl implements IInvestigationService {

    private final SysInvestigationRepository sysInvestigationRepository;

    public SysInvestigationServiceImpl(SysInvestigationRepository sysInvestigationRepository) {
        this.sysInvestigationRepository = sysInvestigationRepository;
    }

    /**
     * 获取角色列表数据
     * @param queryCriteria
     * @param pageable
     * @return
     */
    @Override
    public Object getList(InvestigationQueryCriteria queryCriteria, Pageable pageable) {
        Page<SysInvestigation> page = sysInvestigationRepository.findAll((root, query, criteriaBuilder) -> QueryHelp.getPredicate(root,queryCriteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page);
    }

    /**
     * 新增角色信息
     * @param sysInvestigation
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addInvestigation(SysInvestigation sysInvestigation) {
        SysInvestigation dbSysInvestigation = sysInvestigationRepository.save(sysInvestigation);
        return dbSysInvestigation.getId()!=null;
    }

    /**
     * 根据ID获取角色信息
     * @param id
     * @return
     */
    @Override
    public SysInvestigation getById(Long id) {
        return sysInvestigationRepository.findById(id).orElseGet(SysInvestigation::new);
    }


    /**
     * 更新角色信息
     * @param sysInvestigation
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void editInvestigation(SysInvestigation sysInvestigation) {
        SysInvestigation dbSysInvestigation = sysInvestigationRepository.getReferenceById(sysInvestigation.getId());
        BeanUtil.copyProperties(sysInvestigation,dbSysInvestigation, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        sysInvestigationRepository.save(dbSysInvestigation);
    }

    /**
     * 根据ID删除角色信息
     * @param id
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        sysInvestigationRepository.deleteById(id);
    }

    /**
     * 获取所有角色
     * @return
     */
    @Override
    public List<SysInvestigation> queryAll() {
        return sysInvestigationRepository.findAll();
    }
}
