package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.mapper.DistrictMapper;
import ssm.mapper.StreetMapper;
import ssm.pojo.District;
import ssm.pojo.Street;
import ssm.pojo.StreetExample;
import ssm.service.IStreetService;

import java.util.List;

@Service
public class StreetServiceImpl implements IStreetService{
    @Autowired
    private StreetMapper streetMapper;
    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public PageInfo<Street> selectStreet(int currPage, int size) {
        //开启分页
        PageHelper.startPage(currPage,size);
        //查询所有
        List<Street> list=streetMapper.selectByExample(null);
        //获取分页相关信息
        PageInfo info=new PageInfo(list);
        return info;
    }

    //查询区域对应的街道
    @Override
    public PageInfo<Street> streetDetails(int currPage, int size,int did) {
        //开启分页
        PageHelper.startPage(currPage,size);

        //查询所有
        StreetExample streetExample=new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(did);
        List<Street> list = streetMapper.selectByExample(streetExample);

        //获取分页相关信息
        PageInfo info=new PageInfo(list);
        return info;
    }
    //街道新增
    @Override
    public int insertStreet(Street street) {
        return streetMapper.insertSelective(street);
    }

    //查询单条
    @Override
    public Street selectOneStreet(int id) {
        return streetMapper.selectByPrimaryKey(id);
    }

    //修改街道
    @Override
    public int updateStreet(Street street) {
        return streetMapper.updateByPrimaryKeySelective(street);
    }

    //删除单条
    @Override
    public int deleteStreetOne(int id) {
        return streetMapper.deleteByPrimaryKey(id);
    }

    //删除多条
    @Override
    public int deleteStreetBatch(List<Integer> list) {
        System.out.println(list);
        StreetExample example=new StreetExample();
        StreetExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(list);
        streetMapper.deleteByExample(example);
        return 1;
    }

    //发布页面根据区域id获取区域下对应的街道
    @Override
    public List<Street> selectStreetByDistrictId(Integer id) {
        StreetExample example=new StreetExample();
        StreetExample.Criteria criteria = example.createCriteria();
        criteria.andDistrictIdEqualTo(id);
        return streetMapper.selectByExample(example);
    }

    @Override
    public List<District> insertBySelectDistrictAll() {
        return districtMapper.selectByExample(null);
    }
}
