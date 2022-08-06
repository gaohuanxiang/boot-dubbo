package com.dj.yyds.api.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ShowDto implements Serializable {
    private Integer pageNo;
    private Integer pageSize;
    private String userName;
}
