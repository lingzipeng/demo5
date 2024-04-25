package com.example.demo.utils;

import lombok.Data;


@Data
public class PageVo {
    /**
     * 页码
     */
    private int pageIndex;

    /**
     * 每页显示条数
     */
    private int pageSize;

}
