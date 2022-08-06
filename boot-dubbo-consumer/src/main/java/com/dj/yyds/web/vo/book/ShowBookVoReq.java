package com.dj.yyds.web.vo.book;

import lombok.Data;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ShowBookVoReq {

    private Integer pageNo;
    private Integer pageSize;
    private String bookName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate minTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate maxTime;
}
