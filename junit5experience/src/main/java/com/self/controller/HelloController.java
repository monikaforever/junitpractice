package com.self.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.self.service.HelloService;

/**
 * @author 张琪
 * @version 1.0
 * @date 2021/4/13 15:45
 * @describe
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/{name}")
    public String hello(@PathVariable String name){
        return helloService.hello(name);
    }

}
