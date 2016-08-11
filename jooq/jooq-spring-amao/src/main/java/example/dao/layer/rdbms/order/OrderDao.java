package example.dao.layer.rdbms.order;

import example.business.layer.order.bo.OrderBo;
import example.business.layer.order.vo.UserWithOrder;


public interface OrderDao {
    int addOne(OrderBo order);

    UserWithOrder getOne(int uid, int orderId);
}
