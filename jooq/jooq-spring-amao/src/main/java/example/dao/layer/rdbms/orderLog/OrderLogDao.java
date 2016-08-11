package example.dao.layer.rdbms.orderLog;

import example.business.layer.order.enums.Status;

public interface OrderLogDao {
    int add(int orderId, Status status);
}
