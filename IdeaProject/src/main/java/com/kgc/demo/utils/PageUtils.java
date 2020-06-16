package com.kgc.demo.utils;

import lombok.Data;

import java.util.Collection;

@Data
public class PageUtils<T> {
    //当前页
    private int currentPage;
    private int pageNo;
    //每页条数
    private int pageSize = 10;
    //总页数
    private int totalPage;
    //总条数
    private long totalCount;
    private Collection<T> currentList;

    public int getPageNo() {
        return (pageNo - 1) * pageSize;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public long getTotalPage() {
        return totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

}
