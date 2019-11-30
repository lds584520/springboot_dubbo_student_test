package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.TeaMapper;
import com.qf.service.ITeaService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lds
 * @date 2019/11/30
 */
@Service
public class TeaServiceImpl implements ITeaService {
    @Autowired
    private TeaMapper teaMapper;
}
