package ssm.front.controller;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import ssm.pojo.*;
import ssm.service.IHouseService;
import ssm.util.HouseConditions;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static java.awt.SystemColor.info;

@Controller
@RequestMapping("/page")
public class FrontHouseController {
    @Autowired
    private IHouseService houseService;

    @RequestMapping("/insertHouse")
    public String insertHouse(HttpSession session, House house, @RequestParam(value = "pic",required = false) CommonsMultipartFile pic){
        try {
            //上传图片
            String path="D:\\images\\";
            String newPath = System.currentTimeMillis() + ""+UUID.randomUUID()+pic.getOriginalFilename();
            File file=new File(path+newPath);
            pic.transferTo(file);
            //设置表单没有的参数
            Users users = (Users) session.getAttribute("user");
            house.setUserId(users.getId());
            house.setPath(newPath);
            house.setId(System.currentTimeMillis()+"");
            int i = houseService.insertHouse(house);
            if(i==1){
                return "redirect:selectInfo";
            }else{
                return "fabu";
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    //查询用户发布的出租房信息
    @RequestMapping("/selectInfo")
    public String selectInfo(Page page, HttpSession session, Model model){
        Users user = (Users) session.getAttribute("user");
        PageInfo<Info> info = houseService.selectInfo(page,user.getId());
        model.addAttribute("info",info);
        return "guanli";
    }
    //查询用户删除的出租房信息
    @RequestMapping("/selectDel")
    public String selectDel(Page page, HttpSession session, Model model){
        Users user = (Users) session.getAttribute("user");
        PageInfo<Info> delInfo = houseService.selectInfo(page,user.getId());
        model.addAttribute("delInfo",delInfo);
        return "guanli";
    }
    //查询单条出租房信息
    @RequestMapping("/selectOne")
    public String selectOne(String id,Model model){
        HouseUpdateInfo house = houseService.selectOne(id);
        model.addAttribute("house",house);
        return "update";
    }
    //修改出租房信息
    @RequestMapping("/updateHouse")
    public String updateHouse(String oldPath,House house,Model model,@RequestParam(value = "pic",required = false) CommonsMultipartFile pic){
        String filename = pic.getOriginalFilename();
        if(filename.equals("")){
            //更新数据(不修改图片)
            int i = houseService.updateHouse(house);
            model.addAttribute("result",i);
        }else{
            try {
                //上传图片(修改图片)
                String path="D:\\images\\";
                String newPath = System.currentTimeMillis() + ""+UUID.randomUUID()+pic.getOriginalFilename();
                File file=new File(path+newPath);
                pic.transferTo(file);
                house.setPath(newPath);
                int i = houseService.updateHouse(house);
                model.addAttribute("result",i);
                //删除旧图片
                File oldImg=new File(path+oldPath);
                oldImg.delete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:selectInfo";
    }

    //逻辑删除出租房
    @RequestMapping("/deleteHouse")
    @ResponseBody
    public int deleteHouse(String id){
        return houseService.deleteHouse(id,1);
    }
    //条件查询出租房信息
    @RequestMapping("/search")
    public String search(HouseConditions conditions,Model model){
        PageInfo<HouseInfo> info = houseService.search(conditions);
        model.addAttribute("info",info);
        model.addAttribute("conditions",conditions);
        return "list";
    }
}
