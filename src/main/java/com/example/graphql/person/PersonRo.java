package com.example.graphql.person;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author gaojianqiang
 * @date 2021-05-16
 */
@Data
@AllArgsConstructor
public class PersonRo {
    private String firstName;
    private String lastName;
}
