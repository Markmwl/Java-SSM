package com.mark.Common.Result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"currentPage","currentPageCount","pages","total","data"})
public class PageResult<T> {
    /**
     * 当前页数
     */
    private Integer currentPage;
    /**
     * 当前条数
     */
    private Integer currentPageCount;
    /**
     * 总页数
     */
    private Integer pages;
    /**
     * 总条数
     */
    private Integer total;

    /**
     * 数据
     */
    private T Data;

    /**
     * 分页查询
     * @param currentPage 当前页数
     * @param currentPageCount 当前条数
     * @param total 总条数
     * @param pages 总页数
     * @param data 数据源
     */
    public PageResult(Integer currentPage, Integer currentPageCount, Integer total, Integer pages,T data) {
        this.currentPage = currentPage;
        this.currentPageCount = currentPageCount;
        this.total = total;
        this.pages = pages;
        Data = data;
    }
}
