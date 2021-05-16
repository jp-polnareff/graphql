package com.example.graphql.person;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.Collection;

import com.example.graphql.PageResult;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;

/**
 * @author gaojianqiang
 * @date 2021-05-16
 */
@Service
public class PersonQueryResolver implements GraphQLQueryResolver {

    private final PersonService personService;

    public PersonQueryResolver(final PersonService personService) {
        this.personService = personService;
    }

    public Collection<Person> people(String firstName, String lastName) {
        return personService.getPeople(firstName, lastName);
    }

    public PageResult<Person> personPage(int page, int pageSize) {
        Page<Person> people = personService.personPage(page, pageSize);
        return PageResult.<Person>builder()
                .items(people.getResult())
                .pageNo(page)
                .pageSize(pageSize)
                .totalCount(people.getTotal())
                .build();
    }
}
