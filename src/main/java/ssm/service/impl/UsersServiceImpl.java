package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.mapper.*;
import ssm.pojo.Users;
import ssm.pojo.UsersExample;
import ssm.service.IUsersService;
import ssm.util.MD5Utils;
import ssm.util.UsersConditions;

import java.util.List;

@Service
public class UsersServiceImpl implements IUsersService{
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public PageInfo<Users> selectUsers(UsersConditions conditions) {
        //开启分页
        PageHelper.startPage(conditions.getPage(),conditions.getRows());
        //添加搜索条件
        UsersExample example=new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andIsadminEqualTo(1);
        if(conditions.getName()!=null&&!conditions.getName().equals("")){
            criteria.andNameLike("%"+conditions.getName()+"%");
        }
        if(conditions.getTelephone()!=null&&!conditions.getTelephone().equals("")){
            criteria.andTelephoneLike("%"+conditions.getTelephone()+"%");
        }
        //查询所有用户(带条件)
        List<Users> list=usersMapper.selectByExample(example);
        //获取分页相关信息
        PageInfo info=new PageInfo(list);
        return info;
    }

    //用户新增
    @Override
    public int insertUsers(Users users) {
        return usersMapper.insertSelective(users);
    }

    //查询单条
    @Override
    public Users selectOneUsers(int id) {
        return usersMapper.selectByPrimaryKey(id);
    }

    //修改单条
    @Override
    public int updateUsers(Users users) {
        return usersMapper.updateByPrimaryKeySelective(users);
    }

    //删除多条
    @Override
    public int deleteUsersBatch(List<Integer> ids) {
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return 1;
    }

    //删除单条
    @Override
    public int deleteUsersOne(int id) {
        return usersMapper.deleteByPrimaryKey(id);
    }

    //用户注册
    @Override
    public int regUsers(Users users) {
        //设置注册用户
        users.setIsadmin(0);
        //密码加密
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        return usersMapper.insertSelective(users);
    }

    //用户名检查是否重名
    @Override
    public int checkUsersName(String name) {
        UsersExample example=new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        int count = usersMapper.countByExample(example);
        return count;
    }

    //用户验证登入
    @Override
    public List<Users> login(String name, String password) {
        UsersExample example=new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name).andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        return usersMapper.selectByExample(example);
    }
}
