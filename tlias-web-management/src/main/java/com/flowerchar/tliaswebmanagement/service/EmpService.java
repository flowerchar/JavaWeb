package com.flowerchar.tliaswebmanagement.service;

import com.flowerchar.tliaswebmanagement.pojo.Emp;
import com.flowerchar.tliaswebmanagement.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void save(Emp emp);

    Emp getByService(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}
