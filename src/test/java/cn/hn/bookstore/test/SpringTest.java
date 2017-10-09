package cn.hn.bookstore.test;

import cn.hn.bookstore.po.Category;
import cn.hn.bookstore.service.BusinessService;
import cn.hn.bookstore.util.WebUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by huangning on 2017/10/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
//重要步骤,没有加监听器的画就无法回滚,被网上的好多例子坑了
@TestExecutionListeners(listeners={
        DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class
})
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
@Transactional
public class SpringTest extends AbstractJUnit4SpringContextTests {
    public <T> T getBean(Class<T> type){
        return applicationContext.getBean(type);
    }

    public Object getBean(String beanName){
        return applicationContext.getBean(beanName);
    }
    protected ApplicationContext getContext(){
        return applicationContext;
    }

/*
    @Autowired
    BusinessService businessService;

    @Test
    @Transactional
    //@Rollback(true)
    public void addCategory() throws Exception {
        Category cate = new Category();
        cate.setDescription("你永远不知道一个人的恶意有多么深,多么的莫名其妙");
        cate.setId(WebUtils.makeUUID());
        cate.setName("恶意12220000221");
        businessService.addCategory(cate);

    }*/

}
