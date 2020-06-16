package com.kgc.demo.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BusClick {

    @ExcelProperty(value = "姓名", index = 0)
    private String name;

    @ExcelProperty(value = "身份证", index = 1)
    private long idCard;

    @ExcelProperty(value = "邮箱", index = 2)
    private String email;

    @ExcelProperty(value = "手机号", index = 3)
    private Date phone;
}
