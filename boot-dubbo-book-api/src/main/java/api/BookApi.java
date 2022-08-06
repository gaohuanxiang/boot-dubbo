package api;

import api.dto.BookDto;
import api.dto.ShowBookDto;
import com.dj.yyds.config.PageResult;

public interface BookApi {

    /**
     * 添加图书
     * @param dto
     */
    void addBook(BookDto dto);

    /**
     * 展示图书
     * @param dto
     * @return
     */
    PageResult showBook(ShowBookDto dto);

    /**
     * 根据作者查询图书书量
     * @param userId 作者=用户id
     * @return
     */
    int getCountByAuthorId(Integer userId);
}
