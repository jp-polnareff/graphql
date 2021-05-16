package com.example.graphql.book;

import com.example.graphql.person.Person;
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
public class Book {
    private int id;
    private String title;
    private int personId;
}
