package ssm.service;

import com.github.pagehelper.PageInfo;
import ssm.pojo.District;
import ssm.pojo.Street;

import java.util.List;

public interface IStreetService {
    //查询所有街道带分页功能
    PageInfo<Street> selectStreet(int currPage, int size);

    //详情查询区域对应的街道带分页功能
    PageInfo<Street> streetDetails(int currPage, int size,int did);

    //街道新增
    int insertStreet(Street street);

    //查询单条
    Street selectOneStreet(int id);

    //街道修改
    int updateStreet(Street street);

    //删除单条
    int deleteStreetOne(int id);

    //删除多条
    int deleteStreetBatch(List<Integer> list);

    //发布页面根据区域id获取区域下对应的街道
    List<Street> selectStreetByDistrictId(Integer id);

    //查询所有的区域
    List<District> insertBySelectDistrictAll();
}
