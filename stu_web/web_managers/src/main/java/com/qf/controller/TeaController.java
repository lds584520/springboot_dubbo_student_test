package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.service.ITeaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lds
 * @date 2019/11/30
 */
@Controller
@RequestMapping("/tea")
public class TeaController {

    @Reference
    private ITeaService teaService;

    @RequestMapping("list")
    public  String list (ModelMap map){
        return "tealist";
    }

}
