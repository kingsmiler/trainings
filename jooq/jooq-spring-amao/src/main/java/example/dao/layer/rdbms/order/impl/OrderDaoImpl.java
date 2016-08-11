package example.dao.layer.rdbms.order.impl;

import example.business.layer.order.bo.OrderBo;
import example.business.layer.order.vo.UserWithOrder;
import example.dao.layer.rdbms.base.model.tables.records.OrderRecord;
import example.dao.layer.rdbms.order.OrderDao;
import example.framework.layer.log.LogHelper;
import example.framework.layer.rdbms.transaction.JooqTransactionFactory;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static example.dao.layer.rdbms.base.model.Tables.ORDER;
import static example.dao.layer.rdbms.base.model.Tables.USER;


@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {
    @Autowired
    JooqTransactionFactory jooq;

    @Override
    public int addOne(OrderBo order) {
        OrderRecord orderRecord = jooq.context().newRecord(ORDER);
        orderRecord.from(order);
        int insertRet = orderRecord.insert();
        LogHelper.info("数据库操作返回值：{}", insertRet);
        return orderRecord.getOrderId();
    }

    @Override
    public UserWithOrder getOne(int uid, int orderId) {
        Record record = jooq.context().select(USER.MOBILE, USER.NAME, ORDER.AMOUT, ORDER.STATUS, ORDER.ORDER_TIME)
                .from(USER).innerJoin(ORDER)
                .on(ORDER.UID.eq(USER.UID))
                .where(USER.UID.eq(uid).and(ORDER.ORDER_ID.eq(orderId))).fetchOne();
        if (record == null) {
            return null;
        }
        return record.into(UserWithOrder.class);
    }
}
