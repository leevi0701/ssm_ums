package com.itheima.myException;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: liwei
 * @Date: 2018-12-17
 */
/*
public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        // 获取到异常对象
        CustomException ce = null;
        if (e instanceof CustomException) {
            ce = (CustomException) e;
        } else {
            ce = new CustomException("系统正在维护....");
        }
        // 创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg", ce.getMessage());
        mv.setViewName("error");
        return mv;
    }

}*/
