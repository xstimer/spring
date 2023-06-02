package com.example.springboot.exception;

import cn.hutool.core.util.StrUtil;
import com.example.springboot.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    public Result exceptionError(Exception e){
        log.error("系统错误",e);
        
        return Result.error("系统错误");
    }
    @ExceptionHandler(value = ServiceException.class)
    public Result serviceError(ServiceException e){
        log.error("业务错误",e);
        String code = e.getCode();
        if(StrUtil.isBlank(code)){
            return Result.error(code,e.getMessage());
        }
        return Result.error(e.getMessage());
    }
}
