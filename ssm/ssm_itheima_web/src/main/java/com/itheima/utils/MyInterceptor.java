package com.itheima.utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.handler.Handler;
import java.io.IOException;

/**
 * @author: liwei
 * @Date: 2018-12-17
 */
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
       if(handler instanceof DefaultServletHttpRequestHandler) {
           return true;
       }
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("user") != null) {
            return true;
        } else {

            try {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
