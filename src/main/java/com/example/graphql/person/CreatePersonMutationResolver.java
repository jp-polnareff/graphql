package com.example.graphql.person;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gaojianqiang
 * @date 2021-05-16
 */
@Service
public class CreatePersonMutationResolver implements GraphQLMutationResolver {

    @Resource
    private PersonService personService;

    public Person createPerson(final String firstName, final String lastName) {
        return personService.createPerson(firstName, lastName);
    }

    public boolean createPersonBatch(List<PersonRo> list) {
        return personService.createPersonBatch(list);
    }
}