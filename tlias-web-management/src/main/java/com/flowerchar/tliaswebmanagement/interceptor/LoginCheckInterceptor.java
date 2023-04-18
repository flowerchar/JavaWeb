package com.flowerchar.tliaswebmanagement.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.flowerchar.tliaswebmanagement.pojo.Result;
import com.flowerchar.tliaswebmanagement.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        String url = httpServletRequest.getRequestURL().toString();
        log.info("请求的url：{}",url);

        if (url.contains("login")){
            log.info("登陆操作，放行");
            return true;
        }

        String jwt = httpServletRequest.getHeader("token");

        if (!StringUtils.hasLength(jwt)){
            log.info("token为空，返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            String notlogin = JSONObject.toJSONString(error);
            httpServletResponse.getWriter().write(notlogin);
            return false;
        }

        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            String notlogin = JSONObject.toJSONString(error);
            httpServletResponse.getWriter().write(notlogin);
            return false;
        }

        log.info("令牌合法，放行");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle.............");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
