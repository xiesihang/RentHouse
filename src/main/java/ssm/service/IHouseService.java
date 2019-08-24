package ssm.service;

import com.github.pagehelper.PageInfo;
import ssm.pojo.*;
import ssm.util.HouseConditions;

import java.util.List;


public interface IHouseService {
    //发布租房信息
    int insertHouse(House house);

    //查询用户发布的出租房信息
    PageInfo<Info> selectInfo(Page page, Integer userid);

    //查询用户删除的出租房信息
    PageInfo<Info> selectDel(Page page, Integer userid);

    //查单条出租房信息
    HouseUpdateInfo selectOne(String id);

    //修改出租房信息
    int updateHouse(House house);

    //逻辑删除出租房
    int deleteHouse(String id,Integer isdel);

    //查询审核或未审核出租房
    PageInfo<HouseInfo> selectHouse(int page, int rows, Integer isPass);

    //审核通过出租房信息(未审核-已审核)
    int passAuditHouse(String id);

    //取消审核过的出租房信息(已审核-未审核)
    int cancelApprovedHouse(String id);

    //条件查询出租房信息
    PageInfo<HouseInfo> search(HouseConditions conditions);

    //查询已审核出租房信息(带条件)
    PageInfo<HouseInfo> selectHouseApproved(HouseConditions conditions);

    //查询未审核出租房信息(带条件)
    PageInfo<HouseInfo> selectHouseAudit(HouseConditions conditions);
}
