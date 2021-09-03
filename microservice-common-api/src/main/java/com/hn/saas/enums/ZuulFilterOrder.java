package com.hn.saas.enums;

/**
 * 过滤器的顺序
 * int值来定义过滤器的执行顺序，数值
 *          越小优先级越高
 */
public enum ZuulFilterOrder {
    HIGHEST(1),
    ;
    public final Integer value;

    ZuulFilterOrder(Integer value) {
        this.value = value;
    }

}
