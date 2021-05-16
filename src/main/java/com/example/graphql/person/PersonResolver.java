package com.example.graphql.person;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Service;

/**
 * @author gaojianqiang
 * @date 2021-05-16
 */
@Service
public class PersonResolver implements GraphQLResolver<Person> {

    public String fullName(final Person person) {
        return person.getFirstName() + " " + person.getLastName();
    }
}