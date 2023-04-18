package com.flowerchar.tliaswebmanagement.controller;

import com.flowerchar.tliaswebmanagement.pojo.Dept;
import com.flowerchar.tliaswebmanagement.pojo.PageBean;
import com.flowerchar.tliaswebmanagement.pojo.Result;
import com.flowerchar.tliaswebmanagement.anno.Log;

import com.flowerchar.tliaswebmanagement.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping()
    public Result list(){
        log.info("-------------");

        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门");
        deptService.delete(id);
        return Result.success();
    }

    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.warn(dept.toString());
        log.info("新增部门");
        deptService.add(dept);
        return Result.success();
    }
}
