package com.flowerchar.tliaswebmanagement.controller;

import com.flowerchar.tliaswebmanagement.anno.Log;
import com.flowerchar.tliaswebmanagement.pojo.Emp;
import com.flowerchar.tliaswebmanagement.pojo.PageBean;
import com.flowerchar.tliaswebmanagement.pojo.Result;
import com.flowerchar.tliaswebmanagement.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end){
        log.info("分页查询开始");
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    @Log
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除操作：ids：{}",ids);
        empService.delete(ids);
        return Result.success();
    }

    @Log
    @PostMapping("")
    public Result save(@RequestBody Emp emp){
        log.info("新增员工：{}", emp);
        empService.save(emp);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("ID查询员工：{}",id);
        Emp emp = empService.getByService(id);
        return Result.success(emp);
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("更新员工信息：{}",emp);
        empService.update(emp);
        return Result.success();
    }
}
