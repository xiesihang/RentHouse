package ssm.front.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.pojo.Users;
import ssm.service.IUsersService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/page")
public class FrontUsersController {
    @Autowired
    private IUsersService usersService;

    //注册(新增)
    @RequestMapping("/regUsers")
    public String regUsers(Users users){
        int i = usersService.regUsers(users);
        if(i>0){
            return "login";  //登入页面
        }else {
            return "regs";   //注册页面
        }
    }
    //验证用户名是否存在
    @RequestMapping("/checkUsersName")
    @ResponseBody
    public String checkUsersName(String name){
        String msg;
        String color;
        String json;
        if(name.trim().equals("")){
            msg="\"用户名不能为空\"";
            color="\"red\"";
            json="{\"msg\":"+msg+","+"\"color\":"+color+"}";
            return json;
        }else {
            int i = usersService.checkUsersName(name);
            if(i==1){
                msg="\"用户名已存在\"";
                color="\"red\"";
                json="{\"msg\":"+msg+","+"\"color\":"+color+"}";
                return json;
            }else{
                msg="\"通过\"";
                color="\"green\"";
                json="{\"msg\":"+msg+","+"\"color\":"+color+"}";
                return json;
            }
        }
    }
    //用户验证登入
    @RequestMapping("/login")
    @ResponseBody
    public String login(String name, String password,HttpSession session){
        List<Users> list = usersService.login(name, password);
        if(list.size()==0){
            return "0";
        }else {
            session.setAttribute("user",list.get(0));
            //设置保存的时间
            session.setMaxInactiveInterval(600);  //秒
            return "1";
        }
    }
}
