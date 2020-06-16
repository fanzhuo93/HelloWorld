package com.kgc.demo.controller;

import com.kgc.demo.service.TaskService;
import com.kgc.demo.service.UsersService;
import com.kgc.demo.utils.PageUtils;
import com.kgc.demo.utils.ReturnResult;
import com.kgc.demo.utils.ReturnResultUtils;
import com.kgc.demo.vo.EmployeeVo;
import com.kgc.demo.vo.FanuserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "增删改查")
@Log4j
@RestController
@RequestMapping(value = "/user")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @ApiOperation(value = "注册用户")
    @PostMapping(value = "/toRegUser")
    public ReturnResult toRegUser(@Validated FanuserVo fanuserVo) throws Exception {
        usersService.insertUsers(fanuserVo);
        return ReturnResultUtils.returnSuccess();
    }

    @ApiOperation(value = "登录", notes = "data false--登录失败")
    @PostMapping(value = "/toLogin")
    public ReturnResult<Boolean> toLogin(@Validated FanuserVo fanuserVo) throws Exception {
        try {
            log.info("准备登录");
            boolean isLogin = usersService.toLogin(fanuserVo);
            log.info("完成登录");
            return ReturnResultUtils.returnSuccess(isLogin);
        } catch (Exception e) {
            log.debug(fanuserVo.getName() + "登录出错", e);
            log.error(fanuserVo.getName() + "登录出错", e);
            return ReturnResultUtils.returnFall(1234, e.getMessage());
        }
    }

    @ApiOperation(value = "查询", notes = "data ture 查询")
    @PostMapping(value = "/find")
    public ReturnResult<FanuserVo> getFanuser(@RequestParam int pageNo, @RequestParam Integer... id) {
        List<FanuserVo> fanuserVoList = usersService.queryUsers(pageNo, id);
        PageUtils pageUtils = new PageUtils();
        pageUtils.setPageNo(pageNo);
        pageUtils.setCurrentList(fanuserVoList);
        pageUtils.setCurrentPage(pageNo);
        return ReturnResultUtils.returnSuccess(pageUtils);
    }


    @ApiOperation(value = "查询员工")
    @GetMapping(value = "/getEmployeePage")//改变数据库内容用post
    public ReturnResult<EmployeeVo> getEmployeePage(@ApiParam(value = "起始页", required = true) @RequestParam int pageNo, @ApiParam(value = "姓名", required = true) @RequestParam(required = false) String name) throws Throwable {
        PageUtils pageUtils = new PageUtils();

        //pageUtils.setPageNo(pageUtils.getPageNo(pageNo));
        pageUtils.setCurrentPage(pageNo);
        pageUtils.setPageNo(pageNo);
        List<EmployeeVo> employeeVoList = usersService.queryEmployee(pageUtils.getPageNo(), pageUtils.getPageSize(), name);
        pageUtils.setCurrentList(employeeVoList);
        pageUtils.setTotalCount(usersService.getEmployeeTotalCount(name));

        return ReturnResultUtils.returnSuccess(pageUtils);
    }

    @ApiOperation("删除用户")
    @PostMapping(value = "/delEmployees")
    public ReturnResult delEmployees(@ApiParam(value = "id", required = true) @RequestParam Integer id) {
        return ReturnResultUtils.returnSuccess(usersService.delEmployee(id));
    }

    @ApiOperation("新增员工")
    @PostMapping(value = "/addEmployee")
    public ReturnResult addEmployee(@Validated EmployeeVo employeeVo) throws Throwable {
        return ReturnResultUtils.returnSuccess(usersService.addEmployee(employeeVo));
    }

    @ApiOperation("修改")
    @PostMapping(value = "/updateEmployee")
    public ReturnResult updateEmployee(@Validated EmployeeVo employeeVo) throws Throwable {
        return ReturnResultUtils.returnSuccess(usersService.updateEmployee(employeeVo));
    }

//    @ApiOperation("写入excel")
//    @GetMapping(value = "/writeExcel")
//    public ReturnResult writeExcel(HttpServletResponse response) throws IOException {
//        usersService.writeExcel(response);
//        return ReturnResultUtils.returnSuccess();
//    }


//    @ApiOperation("写入Java")
//    @PostMapping(value = "/readJava")
//    public ReturnResult writeJava(@RequestParam MultipartFile multipartFile) throws Exception {
//            usersService.readExcel(multipartFile);
//            return ReturnResultUtils.returnSuccess();
//    }
    @Autowired
    private TaskService taskService;
    @GetMapping(value = "/sendEmail")
    public ReturnResult sendEamil() throws InterruptedException {
        TaskService.getAddr();
        return ReturnResultUtils.returnSuccess();
    }

//    @ApiOperation(value = "注册用户")
//    @PostMapping(value = "/toRegUser")
//    public ReturnResult userRegester(@Validated UserVo userVo) throws Exception {
//        usersService.insertUsers(fanuserVo);
//        return ReturnResultUtils.returnSuccess();
//    }

}
