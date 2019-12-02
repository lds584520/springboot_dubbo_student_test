package com.qf.service;

import com.qf.entity.Student;

import java.util.List;

/**
 * @author lds
 * @date 2019/11/30
 */
public interface IStuService   {
    List<Student> list();

    int delete(Integer id);

    Student toUpdate(Integer id);

    /*int reset(Student student);*/

    int reset(Student student,String cname);

    int add(Student student);
}
