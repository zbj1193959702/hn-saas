package com.hn.saas.filter;

import com.hn.saas.enums.ZuulFilterOrder;
import com.hn.saas.enums.ZuulFilterType;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * create by biji.zhao on 2021/9/1
 */
@Component
public class LoginFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String filterType() {
        return ZuulFilterType.PRE.value;
    }

    @Override
    public int filterOrder() {
        return ZuulFilterOrder.HIGHEST.value;
    }

    @Override
    public boolean shouldFilter() {
        // 该过滤器是否执行，true执行，false不执行
        return true;
    }

    /**
     * 过滤器真正执行的具体代码
     * @throws ZuulException 异常
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        // 获取请求参数token的值 String token = request
        String token = request.getParameter("token");
        if (token == null) {
            logger.warn("此操作需要先登录系统...");
            // 拒绝访问
            context.setSendZuulResponse(false);
            // 设置响应状态码
            context.setResponseStatusCode(200);
            try {
                // 响应结果
                context.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "error";
        }
        logger.info("ok");
        return "success";
    }
}
