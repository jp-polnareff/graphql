package com.example.graphql.hello;



import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Service;

/**
 * @author gaojianqiang
 * @date 2021-05-16
 */
@Service
public class HelloQueryResolver implements GraphQLQueryResolver {

    public String hello() {
        return "Hello, GraphQL!";
    }

    public String hello2(final String who) {
        return String.format("Hello, %s!", who);
    }
}
