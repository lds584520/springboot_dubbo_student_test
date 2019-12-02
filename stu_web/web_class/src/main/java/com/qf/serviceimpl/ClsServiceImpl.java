package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    public Classes queryById(Integer cid) {
        return clsMapper.selectById(cid);
    }

    @Override
    public List<Classes> list() {
        return clsMapper.selectList(null);
    }

   /* @Override
    public Classes selectByCname(QueryWrapper queryWrapper) {

        return clsMapper.selectOne(queryWrapper);
    }*/

    /**
     * 修改新班级人数
     * @param cls
     * @return
     */
   /* @Override
    public int updateById(Integer cid,Integer cnum) {
        UpdateWrapper updateWrapper=new UpdateWrapper();
        updateWrapper.eq("cnum",cnum);
        return clsMapper.update(cid,updateWrapper);
    }*/
    @Override
    public int updateByid(Classes cls) {
        return clsMapper.updateById(cls);
    }



    /**
     * 修改新班级人数
     * @param cname
     * @return
     */
   /* @Override
    public int updateByCid(Integer id) {
        return 0;
    }*/
    @Override
    public Classes selectByCname(String cname) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.select("cname",cname);
        return clsMapper.selectOne(queryWrapper);
    }

    @Override
    public Classes getById(Integer id) {
        QueryWrapper queryWrapper=new QueryWrapper();
        clsMapper.update(new Classes(),queryWrapper);
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

    /**
     * 修改班级信息
     * @param cls
     * @return
     */
    @Override
    public int updateById(Classes cls) {
        return clsMapper.updateById(cls);
    }


}
