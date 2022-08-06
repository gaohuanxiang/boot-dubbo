package com.dj.yyds.web.vo.book;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ShowBookVoResp {
    private  Integer id;
    private String bookName;
    private BigDecimal bookPrice;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate releaseTime;
    private Integer authorId;
    private String userName;
}
