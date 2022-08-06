package com.dj.yyds.impl;

import api.BookApi;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.yyds.api.UserApi;
import com.dj.yyds.api.dto.LoginDto;
import com.dj.yyds.api.dto.ShowDto;
import com.dj.yyds.api.dto.UserDto;
import com.dj.yyds.base.BusinessException;
import com.dj.yyds.config.PageResult;
import com.dj.yyds.entity.UserEntity;
import com.dj.yyds.mapper.UserMapper;
import com.dj.yyds.util.DozerUtil;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserApi {

    @Reference
    private BookApi bookApi;

    /**
     * 用户登录
     * @param dto 用户名 密码
     * @return
     * @throws BusinessException
     * @throws Exception
     */
    @Override
    public UserDto login(LoginDto dto) {
        UserEntity userEntity = DozerUtil.map(dto, UserEntity.class);
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", userEntity.getUserName());
        wrapper.eq("password", userEntity.getPassword());
        UserEntity entity = super.getOne(wrapper);
        if (entity == null) {
            throw  new BusinessException("用户名或密码错误");
        }
        UserDto userDto = DozerUtil.map(entity, UserDto.class);
        return userDto;
    }

    /**
     * 用户注册
     *
     * @param dto 用户信息
     * @throws BusinessException
     * @throws Exception
     */
    @Override
    public void add(UserDto dto) throws BusinessException, Exception {
        UserEntity userEntity = DozerUtil.map(dto, UserEntity.class);
        super.save(userEntity);
    }

    /**
     * 展示用户信息
     *
     * @return
     */
    @Override
    public PageResult show(ShowDto dto) {
        UserEntity userEntity = DozerUtil.map(dto, UserEntity.class);
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        if (!userEntity.getUserName().isEmpty()) {
            wrapper.like("user_name", userEntity.getUserName());
        }
        IPage<UserEntity> page = super.page(new Page<>(userEntity.getPageNo(), userEntity.getPageSize()), wrapper);
        return PageResult.pageInfo(page.getCurrent(), page.getPages(),
                DozerUtil.mapList(page.getRecords(), UserDto.class));
    }

    /**
     * 根据id查询用户信息
     *
     * @param userId 用户id
     * @return
     */
    @Override
    public UserDto getByUserid(Integer userId) {
        UserEntity entity = super.getById(userId);
       int count = bookApi.getCountByAuthorId(userId);
        UserDto dto = DozerUtil.map(entity, UserDto.class);
        dto.setBookNumber(count);
        return dto;
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Override
    public List<UserDto> findAll() {
        List<UserEntity> list = super.list();
        return DozerUtil.mapList(list , UserDto.class);
    }


}
