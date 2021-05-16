package com.example.graphql;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author gaojianqiang
 * @date 2021-05-16
 */
@Data
@AllArgsConstructor
@Builder
public class PageResult<T> {
    private List<T> items;
    private int pageNo;
    private int pageSize;
    private long totalCount;
}
