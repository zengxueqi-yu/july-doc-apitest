package com.api.apitest.controller;

import com.api.apitest.config.ApiResult;
import com.api.apitest.config.Constants;
import com.api.apitest.entity.ApiRequestParam;
import com.api.apitest.utils.ApiTestUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 自动化工具接口
 * @author zengxueqi
 * @since 2020/2/3
 */
@RestController
@RequestMapping("/api")
public class ApiTestController {

    /**
     * 自动化工具方法
     * @param: [apiParam]
     * @return: ApiResult<java.lang.String>
     * @author: zengxueqi
     * @since: 2020/2/25
     */
    @PostMapping("/test")
    public ApiResult<String> apiTest(@RequestBody ApiRequestParam apiParam) {
        System.out.println("===>进来了");
        if(Constants.REQUEST_GET.equals(apiParam.getMethod())){
            return ApiResult.ok(ApiTestUtil.httpGet(apiParam));
        }else{
            return ApiResult.ok(ApiTestUtil.httpPost(apiParam));
        }

    }

}
