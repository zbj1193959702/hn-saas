package com.hn.saas.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 自定义异常
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -1019217624933739319L;

    private String message;

    public BusinessException(String message, String... paras) {
        this.message = String.format(message, paras);
    }

    public BusinessException(String message) {
        this.message = message;
    }

    public BusinessException(String message, Throwable throwable) {
        super(message, throwable);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取堆栈字符串
     *
     * @param t
     * @return
     */
    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            t.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }

}
