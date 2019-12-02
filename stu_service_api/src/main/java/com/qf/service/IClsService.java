package com.qf.service;

import com.qf.entity.Classes;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;

/**
 * @author lds
 * @date 2019/11/30
 */
public interface IClsService {
    Classes queryById(Integer cid);

    List<Classes> list();

    Classes selectByCname(QueryWrapper queryWrapper);

    int updateById(Classes cls);


    Classes getById(Integer id);
    List<Classes> getList();

    int delete(Integer id);

    int update(Classes classes);

    int add(Classes classes);

    int updateByid(Classes cls);


}
