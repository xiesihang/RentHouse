package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssm.mapper.StreetMapper;
import ssm.mapper.TypeMapper;
import ssm.pojo.Street;
import ssm.pojo.Type;
import ssm.pojo.TypeExample;
import ssm.service.ITypeService;
import java.util.List;

@Service
public class TypeServiceImpl implements ITypeService {
    @Autowired
    private TypeMapper typeMapper;

    //分页查询
    @Override
    public PageInfo<Type> selectType(int currPage, int size) {
        //开启分页
        PageHelper.startPage(currPage,size);
        //查询所有
        List<Type> list=typeMapper.selectByExample(null);
        //获取分页相关信息
        PageInfo info=new PageInfo(list);
        return info;
    }

    //类型新增
    @Override
    public int insertType(Type type) {
        return typeMapper.insertSelective(type);
    }

    //查询单条
    @Override
    public Type selectOneType(int id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    //修改单条
    @Override
    @Transactional
    public int updateType(Type type) {
        return typeMapper.updateByPrimaryKeySelective(type);
    }

    //删除单条
    @Override
    @Transactional
    public int deleteTypeOne(int id) {
        return typeMapper.deleteByPrimaryKey(id);
    }

    //删除多条
    @Override
    public int deleteTypeBatch(List<Integer> ids) {
        TypeExample typeExample = new TypeExample();
        TypeExample.Criteria typeExampleCriteria = typeExample.createCriteria();
        typeExampleCriteria.andIdIn(ids);
        typeMapper.deleteByExample(typeExample);
        return 1;
    }
    //加载发布类型
    public List<Type> selectTypeAll(){
        return typeMapper.selectByExample(null);
    }
}
