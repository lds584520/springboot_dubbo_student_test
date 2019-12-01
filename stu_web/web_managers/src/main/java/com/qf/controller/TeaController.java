package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Classes;
import com.qf.entity.Teacher;
import com.qf.service.IClsService;
import com.qf.service.ITeaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author lds
 * @date 2019/11/30
 */
@Controller
@RequestMapping("/tea")
public class TeaController {

    @Reference
    private ITeaService teaService;

    @Reference
    private IClsService clsService;

    @RequestMapping("/list")
    public  String list (ModelMap map){
        List<Teacher> list = teaService.getList();
        map.put("tlist",list);
        return "tealist";
    }

    @RequestMapping("/delete")
    public String delete(Integer id,ModelMap map){
        if (teaService.delete(id)>0){
            return "redirect:/tea/list";
        }
        return "redirect:/tea/list";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(Integer id,ModelMap map){
        Teacher tea = teaService.getTeaById(id);
        List<Classes> list = clsService.getList();
        map.put("tea",tea);
        map.put("clist",list);
        return "teaUpdate";
    }

    @RequestMapping("/update")
    public  String update(Teacher teacher){
        teaService.update(teacher);
        return "redirect:/tea/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(ModelMap map){
        List<Classes> list = clsService.getList();
        map.put("clist",list);
        return "teaadd";
    }

    @RequestMapping("/add")
    public String add(Teacher teacher){
        teaService.add(teacher);
        return "redirect:/tea/list";
    }
}
