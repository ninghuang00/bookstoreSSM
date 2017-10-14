package cn.hn.bookstore.service.impl;

import cn.hn.bookstore.mapper.OrderMapper;
import cn.hn.bookstore.po.Cart;
import cn.hn.bookstore.po.Category;
import cn.hn.bookstore.po.Order;
import cn.hn.bookstore.po.User;
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
}