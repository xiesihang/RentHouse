package ssm.service;

import com.github.pagehelper.PageInfo;
import ssm.pojo.Type;

import java.util.List;

public interface ITypeService {
    //查询所有类型带分页功能
    PageInfo<Type> selectType(int currPage, int size);

    //区域新增
    int insertType(Type type);

    //查询单条
    Type selectOneType(int id);

    //类型修改
    int updateType(Type type);

    //删除单条
    int deleteTypeOne(int id);

    //删除多条
    int deleteTypeBatch(List<Integer> ids);

    //加载发布类型
    List<Type> selectTypeAll();
}
