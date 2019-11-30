package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.service.IStuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lds
 * @date 2019/11/30
 */
@Controller
@RequestMapping("/stu")
public class StuController {

    @Reference
    private IStuService stuService;

    @RequestMapping("/list")
    public String list(ModelMap map){
        return "stulist";
    }
}
