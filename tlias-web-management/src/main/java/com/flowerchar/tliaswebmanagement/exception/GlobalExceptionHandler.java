package com.flowerchar.tliaswebmanagement.exception;

import com.flowerchar.tliaswebmanagement.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result ex(Exception exception){
        exception.printStackTrace();
        return Result.error("操作失败，请联系管理员");
    }
}
