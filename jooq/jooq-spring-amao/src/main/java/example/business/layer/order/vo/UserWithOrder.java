package example.business.layer.order.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Data
public class UserWithOrder {
    int uid;
    String name;
    String mobile;
    long amout;
    int status;
    long order_time;
}
