package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.StuMapper;
import com.qf.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lds
 * @date 2019/11/30
 */
@Service
public class StuServiceImpl implements IStuService {

    @Autowired
    private StuMapper stuMapper;
}
