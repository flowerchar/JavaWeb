package com.flowerchar.tliaswebmanagement.service;

import com.flowerchar.tliaswebmanagement.pojo.Dept;
import com.flowerchar.tliaswebmanagement.pojo.PageBean;

import java.util.List;

public interface DeptService {

     List<Dept> list();

     void delete(Integer id);

     void add(Dept dept);
}
