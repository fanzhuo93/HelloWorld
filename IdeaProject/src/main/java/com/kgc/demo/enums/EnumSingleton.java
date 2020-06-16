package com.kgc.demo.enums;

/**
 * @Description TODO
 * @Author 范卓
 * @Date 2020/5/14 16:30
 * @Version 1.0
 **/
public enum  EnumSingleton {
    INSTANCE;
    public static EnumSingleton getInstance() {
        return INSTANCE;
    }


}
