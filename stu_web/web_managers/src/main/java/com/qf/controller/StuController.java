package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Classes;
import com.qf.entity.Student;
import com.qf.service.IClsService;
import com.qf.service.IStuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author lds
 * @date 2019/11/30
 */
@Controller
@RequestMapping("/stu")
public class StuController {

    @Reference
    private IStuService stuService;

    @Reference
    private IClsService clsService;
    /**
     * 显示所有学生列表
     * @param map
     * @return
     */
    @RequestMapping("/list")
    public String list(ModelMap map){

        List<Student> list =stuService.list();

        map.addAttribute("stus",list);

        return "stulist";
    }

    /**
     * 删除学生
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public String delete(Integer id){

        stuService.delete(id);

        return "redirect:/stu/list";
    }

    /**
     * 修改并回显
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("/toUpdate")
    public String toUpdate(Integer id, ModelMap map){
        Student stu=stuService.toUpdate(id);

        List<Classes> cls = clsService.list();
        map.addAttribute("stu", stu);
        map.addAttribute("cls",cls);
        return "toUpdate";
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
   /* @RequestMapping("/reset")
    public String reset(Student student){
        stuService.reset(student);
        Classes cls=clsService.queryById(student.getCid());
        //新班级人数+1
        cls.setCnum(cls.getCnum()+1);
        clsService.updateByid(cls);
        return "redirect:/stu/list";
    }*/

   @RequestMapping("/reset")
   public String reset(Student student,String cname){
       stuService.reset(student,cname);
       return "redirect:/stu/list";
   }

    /**
     * 回显班级名称
     * @param model
     * @return
     */
   @RequestMapping("/add")
    public String add(ModelMap model){
       List<Classes> cls = clsService.list();
       model.addAttribute("cls",cls);
       return "stuAdd";
    }

    /**
     * 添加学生
     * @param student
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAdd(Student student){
       stuService.add(student);
       Classes cls=clsService.queryById(student.getCid());
       cls.setCnum(cls.getCnum()+1);
       clsService.updateById(cls);
       return "redirect:/stu/list";
   }

   /* @RequestMapping("/add")
    public String add(Student student){
        stuService.add(student);//先加到学生表里面
        Classes cls = clsService.getById(student.getCid());//根据id获取班级
        cls.setCnum(cls.getCnum()+1);
        clsService.update(cls);//修改班级表的人数
        return "redirect:/stu/list";
    }*/

}
