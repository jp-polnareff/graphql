package com.example.graphql.person;

import com.github.pagehelper.Page;
import com.google.common.collect.Lists;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author gaojianqiang
 * @date 2021-05-16
 */
@Service
public class PersonService {
    private static int INDEX_COUNTER = 5;
    private final Collection<Person> people = new ConcurrentLinkedQueue<>(
            Lists.newArrayList(Person.builder().id(1).firstName("1").lastName("1").build(),
                    Person.builder().id(2).firstName("2").lastName("2").build(),
                    Person.builder().id(3).firstName("3").lastName("3").build(),
                    Person.builder().id(4).firstName("4").lastName("4").build(),
                    Person.builder().id(5).firstName("5").lastName("5").build()));

    public Person createPerson(final String firstName, final String lastName) {
        final Person person = new Person(++INDEX_COUNTER, firstName, lastName);
        people.add(person);
        return person;
    }

    public Person getPersonById(int id) {
        return people.stream().filter(p -> p.getId() == id).findAny().orElse(null);
    }

    public Collection<Person> getPeople(String firstName, String lastName) {
        Stream<Person> stream = people.stream();
        if (Strings.isNotBlank(firstName)) {
            stream = stream.filter(p -> p.getFirstName().equals(firstName));
        }
        if (Strings.isNotBlank(lastName)) {
            stream = stream.filter(p -> p.getLastName().equals(lastName));
        }
        return stream.collect(Collectors.toList());
    }

    public boolean createPersonBatch(List<PersonRo> list) {
        list.forEach(l -> {
            Person p = Person.builder().build();
            BeanUtils.copyProperties(l, p);
            this.people.add(p);
        });
        return true;
    }

    public Page<Person> personPage(int page, int pageSize) {
        Page<Person> result = new Page<>(page, pageSize);
        List<Person> collect = people.stream().skip((page - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
        result.addAll(collect);
        result.setTotal(people.size());
        return result;
    }

}
