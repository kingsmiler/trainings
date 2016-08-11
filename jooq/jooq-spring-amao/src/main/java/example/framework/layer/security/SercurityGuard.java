package example.framework.layer.security;

import java.util.HashSet;
import java.util.Set;

public interface SercurityGuard {
    Set<SercurityGuard> guards = new HashSet<>();

    /**
     * .
     * 检查参数中是否包含有风险的参数
     *
     * @param args 待检查参数
     * @return 结果  true=可以通过；false=不允许执行
     */
    boolean checkRisk(Object... args);
}
