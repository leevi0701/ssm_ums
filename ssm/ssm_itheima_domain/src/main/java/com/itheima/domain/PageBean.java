package com.itheima.domain;

import lombok.Data;

import java.util.List;

/**
 * @author li wei
 */
@Data
public class PageBean {
    private Integer currentPage;
    private Integer rows;
    private Integer start;
    private User user;
    private Integer totalCount;
    private Integer totalPage;

}
