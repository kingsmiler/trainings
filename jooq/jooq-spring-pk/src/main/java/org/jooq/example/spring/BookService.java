package org.jooq.example.spring;

import org.springframework.transaction.annotation.Transactional;

/**
 * This Book Service (or DAO or Repository) is used by this example to interact
 * with the library's T_BOOK table.
 *
 * @author Lukas Eder
 */
public interface BookService {

    /**
     * Create a new book.
     * <p>
     * The implementation of this method has a bug, which causes this method to
     * fail and roll back the transaction.
     */
    @Transactional
    void create(int id, int authorId, String title);

}
