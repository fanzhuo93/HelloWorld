package com.kgc.demo.param;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@ApiModel(value = "用户信息")
public class UsersInfo {
    @ApiModelProperty(value = "账号", required = true)
    @ExcelProperty(value = "姓名", index = 0)
    private String name;
    @ApiModelProperty(value = "身份证号", required = true)
    @ExcelProperty(value = "身份证", index = 1)
    private long idCard;
    @ApiModelProperty(value = "邮箱", required = true)
    @ExcelProperty(value = "邮箱", index = 2)
    private String email;
    @ApiModelProperty(value = "手机号", required = true)
    @ExcelProperty(value = "手机号", index = 3)
    private Date phone;

}
