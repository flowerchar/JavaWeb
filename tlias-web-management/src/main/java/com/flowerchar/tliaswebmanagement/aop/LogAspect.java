package com.flowerchar.tliaswebmanagement.aop;


import com.alibaba.fastjson.JSONObject;
import com.flowerchar.tliaswebmanagement.mapper.OperateLogMapper;
import com.flowerchar.tliaswebmanagement.pojo.OperateLog;
import com.flowerchar.tliaswebmanagement.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class LogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;
    @Autowired
    private HttpServletRequest request;

    @Around("@annotation(com.flowerchar.tliaswebmanagement.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {

        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        Integer operateUser = (Integer)claims.get("id");


        LocalDateTime operateTime = LocalDateTime.now();

        String className = joinPoint.getTarget().getClass().getName();

        String methodName = joinPoint.getSignature().getName();

        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);

        long begin = System.currentTimeMillis();
        Object res = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long costTime = end - begin;

        String returnValue = JSONObject.toJSONString(res);
        OperateLog operateLog = new OperateLog(null, operateUser, operateTime, className, methodName, methodParams, returnValue, costTime);
        operateLogMapper.insert(operateLog);

        log.info("AOP操作：{}", operateLog);
        return res;
    }
}
