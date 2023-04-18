package com.flowerchar.tliaswebmanagement.service.impl;

import com.flowerchar.tliaswebmanagement.mapper.DeptMapper;
import com.flowerchar.tliaswebmanagement.mapper.EmpMapper;
import com.flowerchar.tliaswebmanagement.pojo.Dept;
import com.flowerchar.tliaswebmanagement.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        deptMapper.deleteById(id);

        empMapper.deleteByDeptId(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }
}
