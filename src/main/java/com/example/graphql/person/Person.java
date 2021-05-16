package com.example.graphql.person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author gaojianqiang
 * @date 2021-05-16
 */
@Data
@AllArgsConstructor
@Builder
public class Person {
    private int id;
    private String firstName;
    private String lastName;
}
