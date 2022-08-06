package com.dj.yyds.web.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/u/")
public class MyPageController {

    @RequestMapping("toLogin")
    public String toLogin() {
        return "u/login";
    }

    @RequestMapping("toAdd")
    public String toAdd() {
        return "u/add";
    }

    @RequestMapping("toShow")
    public String toShow() {
        return "u/show";
    }

}
