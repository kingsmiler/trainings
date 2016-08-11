package example.business.layer.user.service;

public interface UserService {
    /**
     * 更新用户的订单量
     *
     * @param userId   用户Id
     * @param orderNum 需要增加的订单数
     * @return 处理结果
     */
    int updateOrderSum(int userId, int orderNum);

}
