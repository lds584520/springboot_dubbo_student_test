package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.dao.StuMapper;
import com.qf.entity.Classes;
import com.qf.entity.Student;
import com.qf.service.IClsService;
import com.qf.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author dj
 * @date 2019/11/30
 */
@Service
public class StuServiceImpl implements IStuService {

    @Autowired
    private StuMapper stuMapper;

    @Reference
    private IClsService clsService;

    /**
     * 显示学生列表
     * @return
     */
    @Override
    public List<Student> list() {

        List<Student> list=stuMapper.selectList(null);

        for(Student student:list) {
            Integer cid=student.getCid();

            Classes cls=clsService.queryById(cid);

            student.setClasses(cls);
        }
        return list;
    }

    /**
     * 删除学生
     * @param id
     * @return
     */
    @Override
    public int delete(Integer id) {

        return stuMapper.deleteById(id);
    }

    @Override
    public Student toUpdate(Integer id) {

        Student student=stuMapper.selectById(id);

        Classes cls=clsService.queryById(id);

        student.setClasses(cls);

        return student;
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    /*@Override
    public int reset(Student student) {
        return stuMapper.updateById(student);
    }*/

    /**
     * 修改学生信息 且班级人数的变动
     * @param student
     * @param cname
     * @return
     */
    @Override
    public int reset(Student student, String cname) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("cname",cname);
        Classes cls=clsService.selectByCname(queryWrapper);//根据前台传入的cname 查找对象
        if(student.getCid()==cls.getId()){//如果cid相等
            return stuMapper.updateById(student);//直接修改
        }else {//如果班级id不相等
            Classes cls2=new Classes();//
            Integer cid=student.getCid();//原班级id
            Classes cls1=clsService.queryById(cid);//根据原cid查找班级对象
            cls2.setCnum(cls1.getCnum()-1);
            clsService.updateById(cls2);//修改原班级人数-1
            cls.setCnum(cls.getCnum()+1);
            student.setCid(cls.getId());//重新赋值 cid
            clsService.updateById(cls);//修改新班级人数+1
            return stuMapper.updateById(student);
        }
    }

    @Override
    public int add(Student student) {

        return stuMapper.updateById(student);


    }
}
