package com.dj.yyds.api;

import com.dj.yyds.api.dto.LoginDto;
import com.dj.yyds.api.dto.ShowDto;
import com.dj.yyds.api.dto.UserDto;
import com.dj.yyds.base.BusinessException;
import com.dj.yyds.config.PageResult;

import java.util.List;

public interface UserApi {
    /**
     * 用户登录
     * @param dto 用户名 密码
     * @return
     * @throws BusinessException
     * @throws Exception
     */
    UserDto login(LoginDto dto) throws BusinessException, Exception;

    /**
     * 用户注册
     * @param dto  用户信息
     * @throws BusinessException
     * @throws Exception
     */
    void add(UserDto dto) throws BusinessException, Exception;

    /**
     * 展示用户信息
     * @return
     */
    PageResult show(ShowDto dto);

    /**
     *  根据id查询用户信息
     * @param userId 用户id
     * @return
     */
    UserDto getByUserid(Integer userId);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<UserDto> findAll();
}
