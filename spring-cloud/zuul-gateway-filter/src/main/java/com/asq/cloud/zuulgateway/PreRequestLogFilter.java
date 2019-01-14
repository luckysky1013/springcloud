package com.asq.cloud.zuulgateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuj
 * @version 1.0
 * @date 2019/1/14 9:47
 * @description TODO
 * 自定义Zuul 过滤器
 **/
public class PreRequestLogFilter extends ZuulFilter {

    private static final Logger looger= LoggerFactory.getLogger(PreRequestLogFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        looger.info(String.format("send %s request to %s ",request.getMethod(),request.getRequestURL().toString()));
        return null;
    }
}
