package com.qf.service;

import com.qf.entity.Teacher;

import java.util.List;

/**
 * @author lds
 * @date 2019/11/30
 */
public interface ITeaService {
    List<Teacher> getList();

    int delete(Integer id);

    Teacher getTeaById(Integer id);

    int update(Teacher teacher);

    int add(Teacher teacher);
}
