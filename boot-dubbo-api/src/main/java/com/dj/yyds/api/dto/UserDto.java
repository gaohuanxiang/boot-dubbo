package com.dj.yyds.api.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class UserDto implements Serializable {
    private Integer id;
    private String userName;
    private String password;
    private String nickName;
    private Integer bookNumber;
}
