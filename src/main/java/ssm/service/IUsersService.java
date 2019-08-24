package ssm.service;

import com.github.pagehelper.PageInfo;
import ssm.pojo.Users;
import ssm.util.UsersConditions;

import java.util.List;

public interface IUsersService {
    //查询所有用户带分页功能
    PageInfo<Users> selectUsers(UsersConditions conditions);

    //用户新增
    int insertUsers(Users users);

    //查询单条
    Users selectOneUsers(int id);

    //修改用户
    int updateUsers(Users users);

    //删除多条
    int deleteUsersBatch(List<Integer> ids);

    //删除单条
    int deleteUsersOne(int id);

    //用户注册
    int regUsers(Users users);

    //用户名检查是否重名
    int checkUsersName(String name);

    //用户验证登入
    List<Users> login(String name,String password);
}
