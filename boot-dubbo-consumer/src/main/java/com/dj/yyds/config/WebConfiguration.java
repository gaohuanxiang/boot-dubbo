package com.dj.yyds.config;

import com.dj.yyds.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@ServletComponentScan("com.dj.yyds.interceptor")
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor = registry.addInterceptor(myInterceptor);
        //拦截请求
        interceptor.addPathPatterns("/**");
        //放行
        interceptor.excludePathPatterns("/u/toLogin");
        interceptor.excludePathPatterns("/u/login");
        interceptor.excludePathPatterns("/res/**");
    }
}
