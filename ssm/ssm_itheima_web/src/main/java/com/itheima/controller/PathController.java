package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: liwei
 * @Date: 2018-12-17
 */
@Controller
@RequestMapping("/path")
public class PathController {

    @RequestMapping("/pathName/{name}")
    public String path(@PathVariable("name") String pname){
        return pname;
    }

}
