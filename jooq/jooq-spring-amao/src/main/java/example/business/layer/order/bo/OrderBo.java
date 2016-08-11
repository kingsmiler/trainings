package example.business.layer.order.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderBo {
    int uid;
    long amout;
    int status;
    long order_time;
    String remark;
}
