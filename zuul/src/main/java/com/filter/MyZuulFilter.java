package com.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by summer on 17-3-31.
 */
public class MyZuulFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyZuulFilter.class);

    //过滤器的类型
    @Override
    public String filterType() {
        return "pre";
    }

    //过滤器的执行顺序
    @Override
    public int filterOrder() {
        return 1;
    }

    //是否要执行
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //打印请求信息
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        MyZuulFilter.LOGGER.info(String.format("send %s request to %s", request.getMethod(), request.getRequestURL().toString()));
        return null;
    }
}
