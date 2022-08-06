package com.dj.yyds.interceptor;

import com.dj.yyds.api.dto.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserDto user = (UserDto) request.getSession().getAttribute("user");
        if (user == null) {
            System.out.println("被拦截");
            response.sendRedirect(request.getContextPath()+"/u/toLogin");
            return false;
        }

        return true;
    }
}
