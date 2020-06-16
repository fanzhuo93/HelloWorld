package com.kgc.demo.service;

import com.kgc.demo.utils.AssertUtils;
import lombok.extern.log4j.Log4j;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import static org.junit.Assert.*;

@Log4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersServiceTest {


    @Before
    public void init() {
        log.info("-------开始测试-------");
    }

    @After
    public void after() {
        log.info("-------结束测试-------");
    }

    @Test
    public void test() {
        //断言
        Assert.assertSame("数量相等","500","500");
        //Assert.assertNotSame("数量不对",500,500);

        log.info("-------test---------");
    }

    @Test
    @Ignore
    public void tests() {
        log.info("-------test---------");
    }

}