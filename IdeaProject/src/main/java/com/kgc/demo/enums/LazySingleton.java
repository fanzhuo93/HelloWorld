package com.kgc.demo.enums;

/**
 * @Description TODO
 * @Author 范卓
 * @Date 2020/5/14 16:29
 * @Version 1.0
 **/
public class LazySingleton {
    private static LazySingleton lazySingleton = null;

    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            LazySingleton lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
