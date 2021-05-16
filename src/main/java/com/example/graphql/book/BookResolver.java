package com.example.graphql.book;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphql.person.Person;
import com.example.graphql.person.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author gaojianqiang
 * @date 2021-05-16
 */
@Service
public class BookResolver implements GraphQLResolver<Book> {
    @Resource
    private PersonService personService;

    public Person person(final Book book) {
        return personService.getPersonById(book.getPersonId());
    }
}
