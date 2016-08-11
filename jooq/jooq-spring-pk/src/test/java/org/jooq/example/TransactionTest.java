/**
 * Copyright (c) 2009-2016, Data Geekery GmbH (http://www.datageekery.com)
 * All rights reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * Other licenses:
 * -----------------------------------------------------------------------------
 * Commercial licenses for this work are available. These replace the above
 * ASL 2.0 and offer limited warranties, support, maintenance, and commercial
 * database integrations.
 * <p>
 * For more information, please visit: http://www.jooq.org/licenses
 */
package org.jooq.example;

import org.jooq.DSLContext;
import org.jooq.example.spring.BookService;
import org.jooq.example.spring.SpringTransactionProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.jooq.example.db.Tables.BOOK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Petri Kainulainen
 * @author Lukas Eder
 *
 * @see <a
 *      href="http://www.petrikainulainen.net/programming/jooq/using-jooq-with-spring-configuration/">http://www.petrikainulainen.net/programming/jooq/using-jooq-with-spring-configuration/</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/jooq-spring.xml"})
//@TransactionConfiguration(transactionManager = "transactionManager")
public class TransactionTest {

    @Autowired
    DSLContext dsl;
    @Autowired
    DataSourceTransactionManager txMgr;
    @Autowired
    SpringTransactionProvider txProvider;
    @Autowired
    BookService books;

    @After
    public void teardown() {

        // Delete all books that were created in any test
        dsl.delete(BOOK).where(BOOK.ID.gt(4)).execute();
    }

    @Test
    public void testExplicitTransactions() {
        boolean rollback = false;

        TransactionStatus tx = txMgr.getTransaction(new DefaultTransactionDefinition());
        try {

            // This is a "bug". The same book is created twice, resulting in a
            // constraint violation exception
            for (int i = 0; i < 2; i++)
                dsl.insertInto(BOOK)
                        .set(BOOK.ID, 5)
                        .set(BOOK.AUTHOR_ID, 1)
                        .set(BOOK.TITLE, "Book 5")
                        .execute();

            Assert.fail();
        }
        // Upon the constraint violation, we explicitly roll back the transaction.
        catch (DataAccessException e) {
            txMgr.rollback(tx);
            rollback = true;
        }

        assertEquals(4, dsl.fetchCount(BOOK));
        assertTrue(rollback);
    }

    @Test
    public void testDeclarativeTransactions() {
        boolean rollback = false;

        try {
            books.create(5, 1, "Book 5");
            Assert.fail();
        } catch (DataAccessException ignore) {
            rollback = true;
        }

        assertEquals(4, dsl.fetchCount(BOOK));
        assertTrue(rollback);
    }

    @Test
    public void testJOOQTransactionsSimple() {
        boolean rollback = false;

        try {
            dsl.transaction(c -> {

                // This is a "bug". The same book is created twice, resulting in a
                // constraint violation exception
                for (int i = 0; i < 2; i++)
                    dsl.insertInto(BOOK)
                            .set(BOOK.ID, 5)
                            .set(BOOK.AUTHOR_ID, 1)
                            .set(BOOK.TITLE, "Book 5")
                            .execute();

                Assert.fail();
            });
        }

        // Upon the constraint violation, the transaction must already have been rolled back
        catch (DataAccessException e) {
            rollback = true;
        }

        assertEquals(4, dsl.fetchCount(BOOK));
        assertTrue(rollback);
    }

    @Test
    public void testjOOQTransactionsNested() {
        AtomicBoolean rollback1 = new AtomicBoolean(false);
        AtomicBoolean rollback2 = new AtomicBoolean(false);

        try {

            // If using Spring transactions, we don't need the c1 reference
            dsl.transaction(c1 -> {

                // The first insertion will work
                dsl.insertInto(BOOK)
                        .set(BOOK.ID, 5)
                        .set(BOOK.AUTHOR_ID, 1)
                        .set(BOOK.TITLE, "Book 5")
                        .execute();

                assertEquals(5, dsl.fetchCount(BOOK));

                try {

                    // Nest transactions using Spring. This should create a savepoint, right here
                    // If using Spring transactions, we don't need the c2 reference
                    dsl.transaction(c2 -> {

                        // The second insertion shouldn't work
                        for (int i = 0; i < 2; i++)
                            dsl.insertInto(BOOK)
                                    .set(BOOK.ID, 6)
                                    .set(BOOK.AUTHOR_ID, 1)
                                    .set(BOOK.TITLE, "Book 6")
                                    .execute();

                        Assert.fail();
                    });
                } catch (DataAccessException e) {
                    rollback1.set(true);
                }

                // We should've rolled back to the savepoint
                assertEquals(5, dsl.fetchCount(BOOK));

                throw new org.jooq.exception.DataAccessException("Rollback");
            });
        }

        // Upon the constraint violation, the transaction must already have been rolled back
        catch (org.jooq.exception.DataAccessException e) {
            assertEquals("Rollback", e.getMessage());
            rollback2.set(true);
        }

        assertEquals(4, dsl.fetchCount(BOOK));
        assertTrue(rollback2.get());
        assertTrue(rollback2.get());
    }
}
