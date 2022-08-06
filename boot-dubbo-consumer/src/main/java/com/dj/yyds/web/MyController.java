package com.dj.yyds.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dj.yyds.api.HelloApi;
import com.dj.yyds.api.UserApi;
import com.dj.yyds.api.dto.LoginDto;
import com.dj.yyds.api.dto.ShowDto;
import com.dj.yyds.api.dto.UserDto;
import com.dj.yyds.config.PageResult;
import com.dj.yyds.config.ResultModel;
import com.dj.yyds.util.DozerUtil;
import com.dj.yyds.web.vo.user.AddVoReq;
import com.dj.yyds.web.vo.user.LoginVoReq;
import com.dj.yyds.web.vo.user.ShowVoReq;
import com.dj.yyds.web.vo.user.ShowVoResp;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/u/")
public class MyController {

    @Reference
    private HelloApi helloApi;

    @Reference
    private UserApi userApi;

    @GetMapping("/hello")
    public String hello(String name) {
        return helloApi.helloGhx(name);
    }

    @RequestMapping("login")
    public ResultModel login(LoginVoReq req, HttpSession session) throws Exception {
        Assert.hasText(req.getUserName(), "用户名或密码不能为空");
        Assert.hasText(req.getPassword(), "用户名或密码不能为空");
        LoginDto dto = DozerUtil.map(req, LoginDto.class);
        UserDto dto1 = userApi.login(dto);
        session.setAttribute("user", dto1);
        return ResultModel.success();
    }

    @RequestMapping("add")
    public ResultModel add(AddVoReq req) throws Exception {
        UserDto dto = DozerUtil.map(req, UserDto.class);
        userApi.add(dto);
        return ResultModel.success();
    }

    @RequestMapping("show")
    public ResultModel show(ShowVoReq req) throws Exception{
        ShowDto dto = DozerUtil.map(req, ShowDto.class);
        PageResult page = userApi.show(dto);
        return ResultModel.success(PageResult.pageInfo(page.getCurrent(), page.getPages(), DozerUtil.mapList(page.getRecords(), ShowVoResp.class)));
    }

    @GetMapping("/show/{userId}")
    public ResultModel show(@PathVariable Integer userId) throws Exception{
      UserDto userDto = userApi.getByUserid(userId);
      return ResultModel.success(DozerUtil.map(userDto, ShowVoResp.class));
    }
}
