package com.dj.yyds.web.vo.user;

import lombok.Data;

@Data
public class UpdateVoReq {
    private Integer id;
    private String userName;
    private String password;
    private String nickName;
}
