package cn.hn.bookstore.service.impl;

import cn.hn.bookstore.po.Book;
import cn.hn.bookstore.test.SpringTest;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by huangning on 2017/10/9.
 */

public class BookServiceTest extends SpringTest {
    Logger logger = Logger.getLogger("hn");

    @Autowired
    private ApplicationContext context;
    @Test
    @Transactional
    public void queryBookById() throws Exception {
        BookService service = (BookService) context.getBean("bookService");
        service.springTest();
        Book book = service.queryBookById("93eecd7d-a8df-4690-b607-697320f9d5b6");
        logger.info("\n book name is " + book.getName() + " description is " + book.getDescription() + "\n price is " + book.getPrice()
         + " author is " + book.getAuthor());


    }

}