package com.dj.yyds.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.yyds.entity.BookEntity;
import org.apache.ibatis.annotations.Param;

public interface BookMapper extends BaseMapper<BookEntity> {
}
