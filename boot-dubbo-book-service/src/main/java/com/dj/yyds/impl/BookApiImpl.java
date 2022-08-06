package com.dj.yyds.impl;

import api.BookApi;
import api.dto.BookDto;
import api.dto.ShowBookDto;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.yyds.api.UserApi;
import com.dj.yyds.api.dto.UserDto;
import com.dj.yyds.base.BusinessException;
import com.dj.yyds.config.PageResult;
import com.dj.yyds.entity.BookEntity;
import com.dj.yyds.mapper.BookMapper;
import com.dj.yyds.util.DozerUtil;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class BookApiImpl extends ServiceImpl<BookMapper, BookEntity> implements BookApi {

    @Reference
    private UserApi userApi;
    /**
     * 添加图书
     *
     * @param dto
     */
    @Override
    public void addBook(BookDto dto) throws BusinessException{
        BookEntity entity = DozerUtil.map(dto, BookEntity.class);
        super.save(entity);
    }

    /**
     * 展示图书
     *
     * @param dto
     * @return
     */
    @Override
    public PageResult showBook(ShowBookDto dto) throws BusinessException{
        BookEntity bookEntity = DozerUtil.map(dto, BookEntity.class);
        QueryWrapper<BookEntity> wrapper = new QueryWrapper<>();
        if (!dto.getBookName().isEmpty()) {
            wrapper.like("book_name", dto.getBookName());
        }
        if (null != dto.getMinTime()) {
            wrapper.ge("release_time", dto.getMinTime());
        }
        if (null != dto.getMaxTime()) {
            wrapper.le("release_time", dto.getMaxTime());
        }
        IPage<BookEntity> page = super.page(new Page<>(bookEntity.getPageNo(),
                bookEntity.getPageSize()), wrapper);
        List<UserDto> dtoList = userApi.findAll();
        //循环遍历把dtoList 的name属性 给到 page.getRecords()
        //List<String> collect = dtoList.stream().map(UserDto::getUserName).collect(Collectors.toList());

        return PageResult.pageInfo(page.getCurrent(), page.getPages(),
                DozerUtil.mapList(page.getRecords(), BookDto.class));
    }

    /**
     * 根据作者查询图书书量
     *
     * @param userId 作者=用户id
     * @return
     */
    @Override
    public int getCountByAuthorId(Integer userId) {
        return super.count(new QueryWrapper<BookEntity>().eq("author_id", userId));
    }
}
