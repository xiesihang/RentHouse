package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.mapper.HouseMapper;
import ssm.pojo.*;
import ssm.service.IHouseService;
import ssm.util.HouseConditions;

import java.util.List;

@Service
public class HouseServiceImpl implements IHouseService{
    @Autowired
    private HouseMapper houseMapper;

    //发布租房信息
    @Override
    public int insertHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    //查询用户发布的出租房信息
    @Override
    public PageInfo<Info> selectInfo(Page page, Integer userid) {
        PageHelper.startPage(page.getCurrPage(),3);
        List<Info> list = houseMapper.selectInfo(userid);
        PageInfo info=new PageInfo(list);
        return info;
    }

    //查询用户删除的出租房信息
    @Override
    public PageInfo<Info> selectDel(Page page, Integer userid) {
        PageHelper.startPage(page.getCurrPage(),page.getRows());
        List<Info> list = houseMapper.selectDel(userid);
        PageInfo delInfo=new PageInfo(list);
        return delInfo;
    }

    //查询单条出租房信息
    @Override
    public HouseUpdateInfo selectOne(String id) {
        return houseMapper.selectOne(id);
    }

    //修改出租房信息
    @Override
    public int updateHouse(House house) {
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    //删除出租房(逻辑删除)
    @Override
    public int deleteHouse(String id, Integer isdel) {
        House house=new House();
        house.setId(id);
        house.setIsdel(1);
        return houseMapper.updateByPrimaryKeySelective(house);

    }

    //查询已审核或未审核出租房信息
    @Override
    @ResponseBody
    public PageInfo<HouseInfo> selectHouse(int page, int rows,Integer isPass) {
        PageHelper.startPage(page,rows);
        List<HouseInfo> list = houseMapper.selectHouse(isPass);
        PageInfo<HouseInfo> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    //审核通过出租房信息(未审核-已审核)
    @Override
    public int passAuditHouse(String id) {
        House house=new House();
        house.setIspass(1);
        house.setId(id);
        return houseMapper.updateByPrimaryKeySelective(house);
    }
    //取消审核过的出租房信息(已审核-未审核)
    @Override
    public int cancelApprovedHouse(String id) {
        House house=new House();
        house.setIspass(0);
        house.setId(id);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    //条件查询出租房信息
    @Override
    public PageInfo<HouseInfo> search(HouseConditions conditions) {
        PageHelper.startPage(conditions.getPage(),conditions.getRows());
        List<HouseInfo> list = houseMapper.search(conditions);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }
    //查询已审核出租房信息(带条件)
    @Override
    public PageInfo<HouseInfo> selectHouseApproved(HouseConditions conditions) {
        PageHelper.startPage(conditions.getPage(),conditions.getRows());
        List<HouseInfo> list = houseMapper.selectHouseApproved(conditions);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }
    //查询未审核出租房信息(带条件)
    @Override
    public PageInfo<HouseInfo> selectHouseAudit(HouseConditions conditions) {
        PageHelper.startPage(conditions.getPage(),conditions.getRows());
        List<HouseInfo> list = houseMapper.selectHouseAudit(conditions);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }
}
