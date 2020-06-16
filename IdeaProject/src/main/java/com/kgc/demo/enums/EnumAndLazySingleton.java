package com.kgc.demo.enums;

/**
 * @Description TODO
 * @Author 范卓
 * @Date 2020/5/14 16:42
 * @Version 1.0
 **/
public class EnumAndLazySingleton {
    private enum EnumSingleton {
        INSTANCE;
        private static EnumAndLazySingleton instance = null;

        private EnumAndLazySingleton getInstace() {
            if (instance == null) {
                instance = new EnumAndLazySingleton();
            }
            return instance;
        }

        public static EnumAndLazySingleton getInstance() {
            return EnumSingleton.INSTANCE.getInstace();
        }
    }
}
