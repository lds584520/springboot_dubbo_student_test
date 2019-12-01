package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.TeaMapper;
import com.qf.entity.Classes;
import com.qf.entity.Teacher;
import com.qf.service.IClsService;
import com.qf.service.ITeaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author lds
 * @date 2019/11/30
 */
@Service
public class TeaServiceImpl implements ITeaService {
    @Autowired
    private TeaMapper teaMapper;

    @Reference
    private IClsService clsService;

    @Override
    public List<Teacher> getList() {
        List<Teacher> teachers = teaMapper.selectList(null);
        for (Teacher teacher : teachers) {
            Classes byId = clsService.getById(teacher.getCid());
            teacher.setCls(byId);
        }
        return teachers;
    }

    @Override
    public int delete(Integer id) {
        return teaMapper.deleteById(id);
    }

    @Override
    public Teacher getTeaById(Integer id) {
        Teacher teacher = teaMapper.selectById(id);
        Classes byId = clsService.getById(teacher.getCid());
        teacher.setCls(byId);
        return teacher;
    }

    @Override
    public int update(Teacher teacher) {
        return teaMapper.updateById(teacher);
    }

    @Override
    public int add(Teacher teacher) {
        return teaMapper.insert(teacher);
    }
}
