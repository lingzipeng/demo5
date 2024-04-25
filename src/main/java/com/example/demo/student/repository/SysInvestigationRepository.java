package com.example.demo.student.repository;

import com.example.demo.student.domain.SysInvestigation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 系统角色信息持久层
 */
public interface SysInvestigationRepository extends JpaRepository<SysInvestigation, Long>, JpaSpecificationExecutor<SysInvestigation> {
}