package com.dj.yyds.web;

import api.BookApi;
import api.dto.BookDto;
import api.dto.ShowBookDto;
import com.alibaba.dubbo.config.annotation.Reference;
import com.dj.yyds.api.dto.UserDto;
import com.dj.yyds.config.PageResult;
import com.dj.yyds.config.ResultModel;
import com.dj.yyds.util.DozerUtil;
import com.dj.yyds.web.vo.book.BookAddVoReq;
import com.dj.yyds.web.vo.book.ShowBookVoReq;
import com.dj.yyds.web.vo.book.ShowBookVoResp;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.awt.print.Book;

@RestController
@RequestMapping("/b/")
public class BookController {

    @Reference
    private BookApi bookApi;

    @RequestMapping("add")
    public ResultModel add(BookAddVoReq req, HttpSession session) throws Exception{
        Assert.hasText(req.getBookName(), "书名不能为空");
        Assert.notNull(req.getBookPrice(), "图书价格不能为空");
        Assert.notNull(req.getReleaseTime(), "时间不能为空");
        UserDto user = (UserDto) session.getAttribute("user");
        req.setAuthorId(user.getId());
        BookDto dto = DozerUtil.map(req, BookDto.class);
        bookApi.addBook(dto);
        return ResultModel.success();
    }

    @RequestMapping("show")
    public ResultModel show(ShowBookVoReq req) throws Exception{
        ShowBookDto dto = DozerUtil.map(req, ShowBookDto.class);
        PageResult page = bookApi.showBook(dto);
        return ResultModel.success(PageResult.pageInfo(page.getCurrent(), page.getPages(),
                DozerUtil.mapList(page.getRecords(), ShowBookVoResp.class)));
    }



}
