package com.api.apitest.boot;

import com.api.apitest.config.ApiResult;
import com.api.apitest.config.Constants;
import com.api.apitest.entity.ApiRequestParam;
import com.api.apitest.utils.ApiTestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * July Doc的Spring Web入口
 * @author zengxueqi
 * @date 2017-03-09 15:36
 */
@RequestMapping("julydoc")
public class JulyDocSpringController {

    private Logger logger = LoggerFactory.getLogger(JulyDocSpringController.class);

    /**
     * Api请求测试
     * @param apiParam
     * @return com.api.apitest.config.ApiResult<java.lang.String>
     * @author zengxueqi
     * @since 2020/3/28
     */
    @PostMapping("/test")
    @ResponseBody
    public ApiResult<String> apiTest(@RequestBody ApiRequestParam apiParam) {
        if(Constants.REQUEST_GET.equals(apiParam.getMethod())){
            return ApiResult.ok(ApiTestUtil.httpGet(apiParam));
        }else if(Constants.REQUEST_POST.equals(apiParam.getMethod())){
            return ApiResult.ok(ApiTestUtil.httpPost(apiParam));
        }
        return ApiResult.fail("没有找到" + apiParam.getMethod() + "请求方式！");
    }

}
