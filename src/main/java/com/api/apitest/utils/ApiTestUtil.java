package com.api.apitest.utils;

import com.api.apitest.entity.ApiRequestParam;
import com.api.apitest.entity.Param;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.List;

/**
 * 请求方式处理类
 * @author zengxueqi
 * @since 2020/2/3
 */
public class ApiTestUtil {

    /**
     * 模拟Get请求
     * @param apiParam
     * @return java.lang.String
     * @author zengxueqi
     * @since 2020/2/3 12:30 下午
     */
    public static String httpGet(ApiRequestParam apiParam) {
        String res = "";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(apiParam.getUrl());
        //设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(30000).build();
        request.setConfig(requestConfig);
        //设置请求头信息
        List<Param> paramList = apiParam.getHeaders();
        if(!CollectionUtils.isEmpty(paramList)){
            for (Param param : paramList) {
                request.addHeader(param.getName(),param.getValue());
            }
        }
        try {
            CloseableHttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                res = EntityUtils.toString(entity, "utf-8");
            }
        } catch (IOException e) {
        } finally {
            request.releaseConnection();
        }
        return res;
    }

    /**
     * 模拟Post请求
     * @param apiParam
     * @return java.lang.String
     * @author zengxueqi
     * @since 2020/2/3 12:30 下午
     */
    public static String httpPost(ApiRequestParam apiParam) {
        String res = "";
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(apiParam.getUrl());
            httpPost.setHeader("Content-Type","application/json;charset=utf-8");
            StringEntity postingString = new StringEntity(apiParam.getParam(),
                    "utf-8");
            //httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
            httpPost.setEntity(postingString);
            //设置请求头信息
            List<Param> paramList = apiParam.getHeaders();
            if(!CollectionUtils.isEmpty(paramList)){
                for (Param param : paramList) {
                    httpPost.addHeader(param.getName(),param.getValue());
                }
            }
            CloseableHttpResponse response = client.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                res = EntityUtils.toString(entity, "utf-8");
            }
            EntityUtils.consume(entity);
            response.close();
            return res;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

}
