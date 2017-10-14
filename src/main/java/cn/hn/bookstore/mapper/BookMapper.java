package cn.hn.bookstore.mapper;

import cn.hn.bookstore.po.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    int deleteByPrimaryKey(String id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> queryAllBooks();

    int getTotalRecord(String category_id);

    List<Book> getPageData(@Param("startindex") int startindex, @Param("pagesize") int pagesize, @Param("category_id") String category_id);
}