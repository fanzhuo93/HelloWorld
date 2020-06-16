package com.kgc.demo.service;

import com.google.common.collect.Lists;
import com.kgc.demo.dto.Employee;
import com.kgc.demo.dto.EmployeeExample;
import com.kgc.demo.dto.Fanuser;
import com.kgc.demo.dto.FanuserExample;
import com.kgc.demo.mapper.EmployeeMapper;
import com.kgc.demo.mapper.FanuserMapper;
import com.kgc.demo.mapper.GoodsMapper;
import com.kgc.demo.mapper.UserMapper;
import com.kgc.demo.utils.MD5Utils;
import com.kgc.demo.vo.EmployeeVo;
import com.kgc.demo.vo.FanuserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Service
public class UsersService {
    @Autowired
    private FanuserMapper fanuserMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    public boolean insertUsers(FanuserVo fanuserVo) throws Exception {
        Fanuser fanuser = new Fanuser();
        if (!ObjectUtils.isEmpty(fanuserVo)) {
            fanuserVo.setPassword(MD5Utils.getMD5Str(fanuserVo.getPassword()));
            BeanUtils.copyProperties(fanuserVo, fanuser);
        }

        try {
            fanuserMapper.insertSelective(fanuser);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
     *登录
     * */
    public boolean toLogin(FanuserVo fanuserVo) throws Exception {
        FanuserExample fanuserExample = new FanuserExample();
        if (!ObjectUtils.isEmpty(fanuserVo)) {
            fanuserExample.createCriteria().andNameEqualTo(fanuserVo.getName());
            List<Fanuser> fanuserList = fanuserMapper.selectByExample(fanuserExample);
            if (fanuserList.size() == 1 && MD5Utils.getMD5Str(fanuserVo.getPassword()).equals(fanuserList.get(0).getPassword()))
                return true;
        }
        return false;
    }

    //查询用户
    public List<FanuserVo> queryUsers(@RequestParam int pageNo, @RequestParam Integer... id) {
        FanuserExample fanuserExample = new FanuserExample();
        fanuserExample.createCriteria().andIdIn(Arrays.asList(id));
        List<Fanuser> fanusersDtos = fanuserMapper.selectByExample(fanuserExample);
        List<FanuserVo> fanuserVos = Lists.newArrayList();
        fanusersDtos.forEach(fanuser -> {
            FanuserVo fanuserVo = new FanuserVo();
            BeanUtils.copyProperties(fanuser, fanuserVo);
            fanuserVos.add(fanuserVo);
        });
        return fanuserVos;
    }

    //查询用户
        public List<EmployeeVo> queryEmployee(int pageNo, int pageSize, String name) {
            EmployeeExample employeeExample = new EmployeeExample();
    //        fanuserExample.createCriteria().andIdIn(Arrays.asList(id));
            employeeExample.createCriteria().andNameLike("%" + name + "%");
            List<Employee> employeesDtos = employeeMapper.selectByExample(employeeExample);
            List<EmployeeVo> employeeVos = Lists.newArrayList();
            employeesDtos.forEach(employeesDto -> {
                EmployeeVo employeeVo = new EmployeeVo();
                BeanUtils.copyProperties(employeesDto, employeeVo);
                employeeVos.add(employeeVo);
            });
            return employeeVos;
        }

    public long getEmployeeTotalCount(String name) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andNameLike("%" + name + "%");
        long totalCount = employeeMapper.countByExample(employeeExample);
        return totalCount;
    }

    //删除
    public int delEmployee(Integer id) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andIdIn(Arrays.asList(id));
        int del = employeeMapper.deleteByExample(employeeExample);
        return del;
    }

    //增加
    public int addEmployee(EmployeeVo employeeVo) {
        Employee employee = new Employee();
        if (!ObjectUtils.isEmpty(employee)) {
            BeanUtils.copyProperties(employeeVo, employee);
        }
        return employeeMapper.insertSelective(employee);
    }

    //修改
    public int updateEmployee(EmployeeVo employeeVo) {
        Employee employee = new Employee();
        if (!ObjectUtils.isEmpty(employeeVo)) {
            BeanUtils.copyProperties(employeeVo, employee);
        }
        return employeeMapper.updateByPrimaryKey(employee);
    }

    //导出
//    public void writeExcel(HttpServletResponse response) {
//        EmployeeExample employeeExample = new EmployeeExample();
//        List<Integer> values = Lists.newArrayList();
//        values.add(1);
//        values.add(2);
//        values.add(3);
//        values.add(4);
//        employeeExample.createCriteria().andIdIn(values);
//        List<Employee> employeeList = employeeMapper.selectByExample(employeeExample);
//        ExcelUtil.writeExcel(response, employeeList, "test", "test", Employee.class);
//    }


    //导入
//    public void readExcel(MultipartFile multipartFile) throws Exception {
//        Employee employee = new Employee();
//        List<Object> objects = ExcelUtil.readExcel(multipartFile, employee, 1, 1);
//        for (int i = 0; i < objects.size(); i++) {
//            BeanUtils.copyProperties(objects.get(i), employee);
//            employeeMapper.insertSelective(employee);
//        }
//    }

    //注册用户
//    public boolean insertGoodsInfo(UserVo userVo) throws Exception {
//        User user=new User();
//            if (!ObjectUtils.isEmpty(userVo)) {
//            goods.setGoodsid(UUIDUtils.getUUID(goodsVo.getGoodsid()));
//            BeanUtils.copyProperties(goodsVo, goods);
//        }
//        try {
//            goodsMapper.insertSelective(goods);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return false;
//    }

    //插入用户信息

}
