package com.dj.yyds.web.vo.book;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BookAddVoReq {
    private String bookName;
    private BigDecimal bookPrice;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseTime;
    private Integer authorId;
}
