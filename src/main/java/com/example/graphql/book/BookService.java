package com.example.graphql.book;

import com.example.graphql.person.Person;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author gaojianqiang
 * @date 2021-05-16
 */
@Service
public class BookService {
    private static int INDEX_COUNTER = 5;
    private final Collection<Book> books = new ConcurrentLinkedQueue<>(
            Lists.newArrayList(Book.builder().id(1).title("1").personId(5).build(),
                    Book.builder().id(2).title("2").personId(4).build(),
                    Book.builder().id(3).title("3").personId(3).build(),
                    Book.builder().id(4).title("5").personId(2).build(),
                    Book.builder().id(5).title("6").personId(1).build()));

    public Book getBookById(int id) {
        return books.stream().filter(b -> b.getId() == 1).findAny().orElse(null);
    }
}
