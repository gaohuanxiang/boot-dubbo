package com.dj.yyds.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dj.yyds.api.HelloApi;

@Service
public class HelloApiImpl  implements HelloApi {

    @Override
    public String helloGhx(String name) {
        return name+ "正在测试";
    }

}
