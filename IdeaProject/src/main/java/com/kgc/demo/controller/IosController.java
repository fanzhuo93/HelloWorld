package com.kgc.demo.controller;

import com.kgc.demo.service.KnightService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author 范卓
 * @Date 2020/5/14 17:16
 * @Version 1.0
 **/
@Log4j
@RestController
@RequestMapping(value = "/ios")
public class IosController {
    @Autowired
    private KnightService knightService;
    @GetMapping(value = "getAddress")
    @Scheduled(cron = "0/4 * * * * ?" )
    public void getAddr(){
        log.info(knightService.getAddr());
    }
}
