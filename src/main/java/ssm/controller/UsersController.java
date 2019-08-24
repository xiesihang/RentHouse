package ssm.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.pojo.Users;
import ssm.service.IUsersService;
import ssm.util.UsersConditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/admin")//表示后所有的控制器请求都在/admin目录下
public class UsersController {
    @Autowired
    private IUsersService usersService;

    @RequestMapping("/selectUsers")
    @ResponseBody
    public HashMap<String,Object> selectUsers(UsersConditions conditions){ //page表示页码   rows表示页大小
        PageInfo<Users> pageInfo = usersService.selectUsers(conditions);
        HashMap map=new HashMap();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
    //区域新增
    @RequestMapping("/insertUsers")
    @ResponseBody
    public int insertUsers(Users users){
        return usersService.insertUsers(users);
    }
    //查询单条
    @RequestMapping("/selectOneUsers")
    @ResponseBody
    public Users selectOneUsers(int id){
        return usersService.selectOneUsers(id);
    }
    //修改区域
    @RequestMapping("/updateUsers")
    @ResponseBody
    public int updateUsers(Users users){
        return usersService.updateUsers(users);
    }
    //删除多条
    @RequestMapping("/deleteUsersBatch")
    @ResponseBody
    public int deleteUsersBatch(String ids){
        //删除区域对应的街道
        try{
            String[] arr = ids.split(",");
            List<Integer> list= new ArrayList<Integer>();
            for(int i=0;i<arr.length;i++){
                list.add(Integer.parseInt(arr[i]));
            }
            return usersService.deleteUsersBatch(list);
        }catch (Exception e){
            try {
                throw new Exception(e.getMessage());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return 0;
    }
    //删除用户
    @RequestMapping("/deleteUsersOne")
    @ResponseBody
    public int deleteUsersOne(int id) {
        return usersService.deleteUsersOne(id);
    }
}
