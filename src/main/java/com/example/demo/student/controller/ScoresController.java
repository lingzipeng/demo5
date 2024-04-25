package com.example.demo.student.controller;

import com.example.demo.base.BaseResult;
import com.example.demo.exception.BadRequestException;
import com.example.demo.student.domain.Scores;
import com.example.demo.student.service.IScoresService;
import com.example.demo.student.service.dto.ScoresQueryCriteria;
import com.example.demo.student.vo.EchartsSeriesModel;
import com.example.demo.student.vo.RegisterScoresModel;
import com.example.demo.utils.PageVo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**功能描述：成绩管理前端控制器
 */
@RestController
@RequestMapping("scores")
public class ScoresController {

    private final IScoresService scoresService;

    public ScoresController(IScoresService scoresService) {
        this.scoresService = scoresService;
    }

    /**
     * 获取成绩列表数据
     * @param queryCriteria
     * @param pageVo
     * @return
     */
    @GetMapping
    public ResponseEntity<Object> getList(ScoresQueryCriteria queryCriteria, PageVo pageVo){
        Pageable pageable = PageRequest.of(pageVo.getPageIndex()-1,pageVo.getPageSize(), Sort.Direction.DESC, "id");
        return new ResponseEntity<>(scoresService.getList(queryCriteria,pageable), HttpStatus.OK);
    }

    /**
     * 登记班级学科成绩
     * @param scoresModel
     * @return
     */
    @PostMapping
    public BaseResult registerScores(@RequestBody RegisterScoresModel scoresModel){
        scoresService.registerScores(scoresModel);
        return BaseResult.success("登记成功");
    }

    /**
     * 更新成绩
     * @param scores
     * @return
     */
    @PutMapping
    public BaseResult editScores(@RequestBody Scores scores){
        scoresService.editScores(scores);
        return BaseResult.success("更新成功");
    }

    /**
     * 根据ID删除成绩信息
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public BaseResult delete(@PathVariable Long id){
        if(null==id){
            throw new BadRequestException("删除信息失败");
        }
        scoresService.deleteById(id);
        return BaseResult.success("删除成功");
    }

    /**
     * 统计班级学科
     * @param courseId
     * @param gradeClassId
     * @return
     */
    @GetMapping("getScoreCensus")
    public BaseResult getScoreCensus(@RequestParam("courseId")Long courseId,
                                     @RequestParam("gradeClassId")Long gradeClassId){
      List<EchartsSeriesModel> list=  scoresService.getScoreCensus(courseId,gradeClassId);
        return BaseResult.success(list);
    }

    /**
     * 班级学科成绩对比
     * @param courseId
     * @return
     */
    @GetMapping("getScoresContrastCensus")
    public BaseResult getScoresContrastCensus(@RequestParam("courseId")Long courseId){
        return BaseResult.success(scoresService.getScoresContrastCensus(courseId));
    }

    /**
     * 统计每个学生总分成绩
     * @return
     */
    @GetMapping("allScoresCensus")
    public BaseResult allScoresCensus(){
        return BaseResult.success(scoresService.allScoresCensus());
    }



}
