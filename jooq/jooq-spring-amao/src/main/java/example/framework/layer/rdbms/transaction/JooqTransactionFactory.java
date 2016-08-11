package example.framework.layer.rdbms.transaction;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultExecuteListenerProvider;

public class JooqTransactionFactory {

    private Configuration config;
    private DSLContext context;
//    private ConnectionProvider connectionProvider;

    public JooqTransactionFactory(SpringTransactionConnectionProvider springTransactionConnectionProvider, SpringTransactionProvider springTransactionProvider, SpringExceptionTranslationExecuteListener springExceptionTranslationExecuteListener) {
//        connectionProvider = springTransactionConnectionProvider;

        if (config == null) {
            config = new DefaultConfiguration().
                    //set(new MockConnection(new JDBCacheProvider(springTransactionConnectionProvider))).
                            set(springTransactionConnectionProvider).
                            set(SQLDialect.MYSQL).
                            set(springTransactionProvider).
                            set(new DefaultExecuteListenerProvider(springExceptionTranslationExecuteListener));
        }
    }

    public DSLContext context() {
        if (context == null) {
            context = DSL.using(config);
//            context = DSL.using(new MockConnection(new JDBCacheProvider(connectionProvider.acquire())), SQLDialect.MYSQL);
        }
        return context;
    }
}
