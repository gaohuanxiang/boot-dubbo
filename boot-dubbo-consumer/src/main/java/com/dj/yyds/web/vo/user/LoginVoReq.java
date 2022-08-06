package com.dj.yyds.web.vo.user;

import lombok.Data;

import java.io.Serializable;
@Data
public class LoginVoReq implements Serializable {
    private String userName;
    private String password;
}
