package com.example.demo.student.controller;



import com.example.demo.base.BaseResult;
import com.example.demo.exception.BadRequestException;
import com.example.demo.student.domain.SysInvestigation;
import com.example.demo.student.service.IInvestigationService;
import com.example.demo.student.service.dto.InvestigationQueryCriteria;
import com.example.demo.utils.PageVo;
import com.example.demo.utils.ResultVo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**功能描述：调查问卷
 */
@RestController
@RequestMapping("investigation")
public class InvestigationController {

    private final IInvestigationService investigationService;

    public InvestigationController(IInvestigationService investigationService) {
        this.investigationService = investigationService;
    }

    /**
     * 获取列表数据
     * @param queryCriteria
     * @param pageVo
     * @return
     */
    @GetMapping
    public ResponseEntity<Object> getList(InvestigationQueryCriteria queryCriteria, PageVo pageVo){
        Pageable pageable = PageRequest.of(pageVo.getPageIndex()-1,pageVo.getPageSize(), Sort.Direction.DESC, "id");
        return new ResponseEntity<>(investigationService.getList(queryCriteria,pageable), HttpStatus.OK);
    }

    /**
     * 添加信息
     * @param sysInvestigation
     * @return
     */
    @PostMapping
    public BaseResult addInvestigation(@RequestBody SysInvestigation sysInvestigation){
        boolean result= investigationService.addInvestigation(sysInvestigation);
        if(result){
            return BaseResult.success("添加成功");
        }else {
            return BaseResult.fail("添加失败");
        }
    }

    /**
     * 根据ID获取详情信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public BaseResult detail(@PathVariable Long id){
        if(null==id){
            throw new BadRequestException("获取信息失败");
        }
        SysInvestigation dbSysInvestigation = investigationService.getById(id);
        return BaseResult.success(dbSysInvestigation);
    }

    /**
     * 更新信息
     * @param sysInvestigation
     * @return
     */
    @PutMapping
    public BaseResult editInvestigation(@RequestBody SysInvestigation sysInvestigation){
        investigationService.editInvestigation(sysInvestigation);
        return BaseResult.success("更新成功");
    }

    /**
     * 根据ID删除信息
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public BaseResult delete(@PathVariable Long id){
        if(null==id){
            throw new BadRequestException("删除信息失败");
        }
        investigationService.deleteById(id);
        return BaseResult.success("删除成功");
    }

    /**
     * 获取所有信息
     * @param
     * @return
     */
    @GetMapping(value = "/all")
    public BaseResult getAll(){
        List<SysInvestigation> list =  investigationService.queryAll();
        List<ResultVo> result = list.stream().map(temp -> {
            ResultVo obj = new ResultVo();
            obj.setName(temp.getName());
            obj.setId(temp.getId());
            return obj;
        }).collect(Collectors.toList());
        return BaseResult.success(result);
    }
}
