package com.dj.yyds.web.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index/")
public class IndexController {

    @RequestMapping("toIndex")
    public String toIndex() {
        return "index/index";
    }

    @RequestMapping("left")
    public String left() {
        return "index/left";
    }

    @RequestMapping("right")
    public String right() throws Exception {
        return "index/right";
    }

    @RequestMapping("top")
    public String top() throws Exception {
        return "index/top";
    }

}
