package com.flowerchar.tliaswebmanagement.controller;


import com.flowerchar.tliaswebmanagement.pojo.Emp;
import com.flowerchar.tliaswebmanagement.pojo.PageBean;
import com.flowerchar.tliaswebmanagement.pojo.Result;
import com.flowerchar.tliaswebmanagement.service.EmpService;
import com.flowerchar.tliaswebmanagement.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Slf4j
@RestController
public class LoginController{

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登陆：{}",emp);
        Emp e = empService.login(emp);

        if (e!=null){
            HashMap<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("name",e.getName());
            claims.put("username", e.getUsername());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或者密码错误");
    }
}
