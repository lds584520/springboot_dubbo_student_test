package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.service.IClsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lds
 * @date 2019/11/30
 */
@Controller
@RequestMapping("/cls")
public class ClsController {

    @Reference
    private IClsService clsService;

    @RequestMapping("/list")
    public String list(ModelMap modelMap){
        return "clslist";
    }

}
