package cn.hn.bookstore.mapper;

import cn.hn.bookstore.po.Order;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by huangning on 2017/10/10.
 */
public interface OrderMapper {

    /*void insertOrder( @Param("id") String id,@Param("date") Date ordertime,@Param("price") double price,
                      @Param("state") boolean state,@Param("user_id") String user_id);*/

    void insertOrder(Order order);

    List<Order> queryOrders(boolean state);

    Order queryOrder(String orderid);

    void updateOrderState(@Param("id") String orderid, @Param("state") Boolean state);
}
