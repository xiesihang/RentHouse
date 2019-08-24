package ssm.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.pojo.HouseInfo;
import ssm.service.IHouseService;
import ssm.util.HouseConditions;

import java.util.HashMap;

@Controller
@RequestMapping("/admin")
public class HouseController {
    @Autowired
    private IHouseService houseService;

    //查询已审核出租房信息(带条件)
    @RequestMapping("/selectHouseApproved")
    @ResponseBody
    public HashMap<String,Object> selectHouseApproved(HouseConditions conditions){
        PageInfo<HouseInfo> pageInfo = houseService.selectHouseApproved(conditions);
        HashMap map=new HashMap();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
    //查询未审核出租房信息(带条件)
    @RequestMapping("/selectHouseAudit")
    @ResponseBody
    public HashMap<String,Object> selectHouseAudit(HouseConditions conditions){
        PageInfo<HouseInfo> pageInfo = houseService.selectHouseAudit(conditions);
        HashMap map=new HashMap();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
    //审核通过出租房信息(未审核-已审核)
    @RequestMapping("/passAuditHouse")
    @ResponseBody
    public int passAuditHouse(String id){
       return houseService.passAuditHouse(id);
    }
    //取消审核过的出租房信息(已审核-未审核)
    @RequestMapping("/cancelApprovedHouse")
    @ResponseBody
    public int cancelApprovedHouse(String id){
        return houseService.cancelApprovedHouse(id);
    }
}
