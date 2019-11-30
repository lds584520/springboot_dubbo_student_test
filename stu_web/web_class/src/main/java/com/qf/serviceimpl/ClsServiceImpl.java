package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.ClsMapper;
import com.qf.service.IClsService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lds
 * @date 2019/11/30
 */
@Service
public class ClsServiceImpl implements IClsService {

    @Autowired
    private ClsMapper clsMapper;
}
