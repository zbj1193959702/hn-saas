package com.hn.saas.enums;

/**
 * 过滤器的类型 枚举
 */
public enum ZuulFilterType {
    PRE("pre", "在请求路由之前执行"),
    ROUTE("route", "在请求路由时调用"),
    POST("post", "请求路由之后调用， 也就是在route和errror过滤器之后调用"),
    ERROR("error", "处理请求发生错误时调用"),
    ;
    public final String value;
    public final String desc;

    ZuulFilterType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

}
