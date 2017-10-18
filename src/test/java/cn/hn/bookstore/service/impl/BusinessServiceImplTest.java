package cn.hn.bookstore.service.impl;

import cn.hn.bookstore.mapper.BookMapper;
import cn.hn.bookstore.mapper.OrderMapper;
import cn.hn.bookstore.po.*;
import cn.hn.bookstore.service.BusinessService;
import cn.hn.bookstore.test.SpringTest;
import cn.hn.bookstore.util.WebUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by huangning on 2017/10/9.
 */
public class BusinessServiceImplTest extends SpringTest{
    @Autowired
    BusinessService businessService;
    @Autowired
    SqlSessionFactory sqlSessionFactory;


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

    @Test
    public void getAllCategory() throws Exception {
        List<Category> list = new ArrayList<>();
        list = businessService.getAllCategory();
        System.out.println();
    }

    @Test
    public void addOrder() throws Exception {
        User user = new User();
        user.setAddress("ddd ");
        user.setEmail("fff");
        user.setId("5ea47e45-8517-400e-b605-22a3e6a05236");
        user.setUsername("ddd");
        user.setPassword("fsfsf");
        user.setPhonenumber("1214124");
        Order order = new Order();
        order.setId(WebUtils.makeUUID());
        order.setOrderitems(null);
        order.setOrdertime(new Date(System.currentTimeMillis()));
        order.setPrice(20);
        order.setUser(user);
        order.setState(false);
        Cart cart = new Cart();
        businessService.addOrder(cart,user);
        System.out.println();


    }

    @Test
    public void listOrder() throws Exception {
        List<Order> orders = businessService.listOrder("true");
        System.out.println();
    }

    @Test
    public void findOrder() throws Exception {
        Order order = businessService.findOrder("51807f4e-ff08-404c-b5d2-1778c4ad05c8");

        System.out.println();
        User user = order.getUser();
        System.out.println();
    }

    @Test
    public void queryAllCategories() throws Exception {
        List<Category> list = businessService.getAllCategory();
        System.out.println();
    }
    @Autowired
    private BookMapper bookMapper;
    @Test
    public void getTotalRecord() throws Exception {
        bookMapper.getTotalRecord(null);
        System.out.println();
    }


    @Test
    public void getPage() throws Exception {
        Page page = businessService.getPageData(null,null);
        System.out.println();
    }
    /*@Test
    public void findOrder2() throws Exception {

        //获取SQLSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //指定mapper接口类型,mybatis通过动态代理的方式实现mapper接口
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.queryOrder("51807f4e-ff08-404c-b5d2-1778c4ad05c8");
        System.out.println();
        User user = order.getUser();
        System.out.println();
    }*/
}