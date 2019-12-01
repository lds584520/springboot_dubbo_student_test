package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Classes;
import com.qf.service.IClsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
        List<Classes> list = clsService.getList();
        modelMap.put("clist",list);
        return "clslist";
    }

    @RequestMapping("/delete")
    public String list(Integer id){
        clsService.delete(id);
        return "redirect:/cls/list";
    }
    @RequestMapping("/toUpdate")
    public  String toUpdate(Integer id,ModelMap map){
        Classes cls=clsService.getById(id);
        map.put("cls",cls);
        return "clsUpdate";
    }

    @RequestMapping("/update")
    public String update(Classes classes){
        clsService.update(classes);
        return "redirect:/cls/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "clsadd";
    }

    @RequestMapping("/add")
    public String add(Classes classes){
        clsService.add(classes);
        return "redirect:/cls/list";
    }
}
