package com.dj.yyds.web.vo.user;

import lombok.Data;

@Data
public class ShowVoReq {
    private Integer pageNo;
    private Integer pageSize;
    private String userName;
}
