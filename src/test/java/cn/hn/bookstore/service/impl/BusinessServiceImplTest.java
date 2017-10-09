package cn.hn.bookstore.service.impl;

import cn.hn.bookstore.po.Category;
import cn.hn.bookstore.service.BusinessService;
import cn.hn.bookstore.test.SpringTest;
import cn.hn.bookstore.util.WebUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by huangning on 2017/10/9.
 */
public class BusinessServiceImplTest extends SpringTest{
    @Autowired
    BusinessService businessService;

    @Test
    @Transactional
    //@Rollback(false)
    public void addCategory() throws Exception {
        Category cate = new Category();
        cate.setDescription("你永远不知道一个人的恶意有多么深,多么的莫名其妙");
        cate.setId(WebUtils.makeUUID());
        cate.setName("恶意1222221");
        businessService.addCategory(cate);

    }

}