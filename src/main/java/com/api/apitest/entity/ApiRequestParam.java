package com.api.apitest.entity;

import lombok.Data;

import java.util.List;

/**
 * @author zengxueqi
 * @since 2020/2/3
 */
@Data
public class ApiRequestParam {

    private String param;
    private String url;
    private String method;
    private List<Param> headers;
    private String _token;

}
