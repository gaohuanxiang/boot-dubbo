package com.dj.yyds.api.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class LoginDto implements Serializable {
    private String userName;
    private String password;
}
