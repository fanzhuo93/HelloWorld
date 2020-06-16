package com.kgc.demo.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ReturnResult<T> implements Serializable {
    //code 状态码
    private Integer code;
    private String message;
    private T data;

}
