package ssm.service;

import com.github.pagehelper.PageInfo;
import ssm.pojo.District;
import java.util.List;

public interface IDistrictService {
    //查询所有区域带分页功能
    PageInfo<District> selectDistrict(int currPage, int size);

    //区域新增
    int insertDistrict(District district);

    //查询单条
    District selectOneDistrict(int id);

    //区域修改
    int updateDistrict(District district);

    //删除单条区域及区域对应的街道
    int deleteDistrictOne(int id);

    //多项删除
    int deleteDistrictBatch(List<Integer> ids);

    //详情内的删除街道
    int deleteDetailsStreetOne(int id);

    //查询所有的区域
    List<District> selectDistrictAll();
}
