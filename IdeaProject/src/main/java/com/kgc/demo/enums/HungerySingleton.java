package com.kgc.demo.enums;

/**
 * @Description TODO
 * @Author 范卓
 * @Date 2020/5/14 16:28
 * @Version 1.0
 **/
public class HungerySingleton {
    private static HungerySingleton hungerySingleton=new HungerySingleton();
private static HungerySingleton getInstance(){
    return hungerySingleton;
}
}
