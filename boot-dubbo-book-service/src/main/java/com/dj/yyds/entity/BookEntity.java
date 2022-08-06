package com.dj.yyds.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@TableName("book")
public class BookEntity {
   @TableId(type = IdType.AUTO)
   private  Integer id;
   private String bookName;
   private BigDecimal bookPrice;
   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
   private LocalDate releaseTime;
   private Integer authorId;
   @TableField(exist = false)
   private Integer pageNo;
   @TableField(exist = false)
   private Integer pageSize;
   @TableField(exist = false)
   private String userName;
}
