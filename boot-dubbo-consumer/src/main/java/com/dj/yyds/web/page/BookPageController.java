package com.dj.yyds.web.page;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/b/")
public class BookPageController {

    @RequestMapping("toAdd")
    private String toAdd() {
        return "b/add";
    }
    @RequestMapping("toShow")
    private String toShow() {
        return "b/show";
    }



}
