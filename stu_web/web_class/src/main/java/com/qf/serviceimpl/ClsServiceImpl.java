package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.ClsMapper;
import com.qf.entity.Classes;
import com.qf.service.IClsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author lds
 * @date 2019/11/30
 */
@Service
public class ClsServiceImpl implements IClsService {

    @Autowired
    private ClsMapper clsMapper;

    @Override
    public Classes getById(Integer id) {
        return clsMapper.selectById(id);
    }

    @Override
    public List<Classes> getList() {
        return clsMapper.selectList(null);
    }

    @Override
    public int delete(Integer id) {
        return clsMapper.deleteById(id);
    }

    @Override
    public int update(Classes classes) {
        return clsMapper.updateById(classes);
    }

    @Override
    public int add(Classes classes) {
        return clsMapper.insert(classes);
    }
}
