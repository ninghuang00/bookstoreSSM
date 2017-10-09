package cn.hn.bookstore.service.impl;

import cn.hn.bookstore.mapper.BookMapper;
import cn.hn.bookstore.po.Book;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by huangning on 2017/10/8.
 */

public class BookService {
    @Autowired
    private BookMapper bookMapper;
    public Book queryBookById(String bookId){
        return bookMapper.selectByPrimaryKey(bookId);
    }

    public void springTest(){
        System.out.println("spring test successful!");
    }
}
