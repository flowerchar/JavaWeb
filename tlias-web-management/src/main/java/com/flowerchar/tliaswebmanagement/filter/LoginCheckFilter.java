package com.flowerchar.tliaswebmanagement.filter;


import com.alibaba.fastjson.JSONObject;
import com.flowerchar.tliaswebmanagement.pojo.Result;
import com.flowerchar.tliaswebmanagement.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String url = httpServletRequest.getRequestURL().toString();
        log.info("请求的url：{}",url);

        if (url.contains("login")){
            log.info("登陆操作，放行");
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        String jwt = httpServletRequest.getHeader("token");

        if (!StringUtils.hasLength(jwt)){
            log.info("token为空，返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            String notlogin = JSONObject.toJSONString(error);
            httpServletResponse.getWriter().write(notlogin);
            return;
        }

        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            String notlogin = JSONObject.toJSONString(error);
            httpServletResponse.getWriter().write(notlogin);
            return;
        }

        log.info("令牌合法，放行");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
