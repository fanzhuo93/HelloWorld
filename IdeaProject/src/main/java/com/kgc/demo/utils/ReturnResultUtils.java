package com.kgc.demo.utils;

public class ReturnResultUtils {
    private final static Integer SUCCESS_CODE = 1;
    private final static String SUCCESS_MESSAGE = "success";

    /**
     * 带返回值的
     *
     * @param data
     * @return
     */
    public static ReturnResult returnSuccess(Object data) {
        ReturnResult returnResult = new ReturnResult();
        returnResult.setCode(SUCCESS_CODE);
        returnResult.setMessage(SUCCESS_MESSAGE);
        returnResult.setData(data);
        return returnResult;
    }

    /**
     * 不带返回值的
     *
     * @return
     */
    public static ReturnResult returnSuccess() {
        return returnSuccess(null);
    }

    public static ReturnResult returnFall(Integer code, String msg) {
        ReturnResult returnResult = new ReturnResult();
        returnResult.setCode(code);
        returnResult.setMessage(msg);
        return returnResult;
    }
}
