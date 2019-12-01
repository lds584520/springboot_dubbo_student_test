package com.qf.service;

import com.qf.entity.Classes;

import java.util.List;

/**
 * @author lds
 * @date 2019/11/30
 */
public interface IClsService {
    Classes getById(Integer id);
    List<Classes> getList();

    int delete(Integer id);

    int update(Classes classes);

    int add(Classes classes);
}
