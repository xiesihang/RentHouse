package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssm.mapper.*;
import ssm.pojo.District;
import ssm.pojo.DistrictExample;
import ssm.pojo.StreetExample;
import ssm.service.IDistrictService;
import java.util.List;

@Service
public class DistrictServiceImpl implements IDistrictService{
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private StreetMapper streetMapper;

    //分页查询
    @Override
    public PageInfo<District> selectDistrict(int currPage, int size) {
        //开启分页
        PageHelper.startPage(currPage,size);
        //查询所有
        List<District> list=districtMapper.selectByExample(null);
        //获取分页相关信息
        PageInfo info=new PageInfo(list);
        return info;
    }

    //区域新增
    @Override
    public int insertDistrict(District district) {
        return districtMapper.insertSelective(district);
    }

    //查询单条
    @Override
    public District selectOneDistrict(int id) {
        return districtMapper.selectByPrimaryKey(id);
    }

    //修改区域
    @Override
    public int updateDistrict(District district) {
        return districtMapper.updateByPrimaryKeySelective(district);
    }

    //删除单条区域及对应的街道
    @Override
    @Transactional
        public int deleteDistrictOne(int id) {
        //删除街道
        StreetExample e = new StreetExample();
        StreetExample.Criteria c = e.createCriteria();
        c.andDistrictIdEqualTo(id);
        streetMapper.deleteByExample(e);
        //删除区域
        districtMapper.deleteByPrimaryKey(id);
        return 1;
    }

    //删除多条区域及对应的街道
    @Override
    @Transactional
    public int deleteDistrictBatch(List<Integer> ids) {
        //删除街道
        StreetExample streetExample = new StreetExample();
        StreetExample.Criteria streetExampleCriteria = streetExample.createCriteria();
        streetExampleCriteria.andDistrictIdIn(ids);
        streetMapper.deleteByExample(streetExample);
        //删除区域
        DistrictExample districtExample = new DistrictExample();
        DistrictExample.Criteria districtExampleCriteria = districtExample.createCriteria();
        districtExampleCriteria.andIdIn(ids);
        districtMapper.deleteByExample(districtExample);
        return 1;
    }

    //删除街道
    @Override
    public int deleteDetailsStreetOne(int id) {
        return streetMapper.deleteByPrimaryKey(id);
    }

    //查询区域对应的街道
    @Override
    public List<District> selectDistrictAll() {
        return districtMapper.selectByExample(null);
    }
}
