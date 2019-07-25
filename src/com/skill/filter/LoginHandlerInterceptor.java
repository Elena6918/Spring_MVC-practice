package com.skill.filter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object arg2, Exception arg3)
            throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object handler, ModelAndView arg3) throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        //if url includes keyword private
        if(requestURI.indexOf("private")>0){
            HttpSession session = request.getSession();
            Object user = session.getAttribute("user");
            if(user!=null){ //user already logged in
                return true;
            }else{
                response.sendRedirect(request.getContextPath()+"/login");
                return false;
            }
        }else{
            return true;
        }
    }
}
