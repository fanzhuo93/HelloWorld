package com.kgc.demo.utils;

import java.util.UUID;

/**
 * @Description TODO
 * @Author 范卓
 * @Date 2020/5/15 12:31
 * @Version 1.0
 **/
public class UUIDUtils {
    public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str=uuid.toString();
        String uuidStr=str.replace("-","").substring(1,10);
        return uuidStr;
    }
}
