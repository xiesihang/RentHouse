package ssm.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.pojo.District;
import ssm.service.IDistrictService;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Controller
@RequestMapping("/admin")//表示后所有的控制器请求都在/admin目录下
public class DistrictController {
    @Autowired
    private IDistrictService districtService;

    //分页查询
    @RequestMapping("/selectDistrict")
    @ResponseBody
    public HashMap<String,Object> pageSelect(int page, int rows){ //page表示页码   rows表示页大小
        PageInfo<District> pageInfo = districtService.selectDistrict(page, rows);
        HashMap map=new HashMap();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
    //区域新增
    @RequestMapping("/insertDistrict")
    @ResponseBody
    public int insertDistrict(District district){
        return districtService.insertDistrict(district);
    }
    //查询单条
    @RequestMapping("/selectOneDistrict")
    @ResponseBody
    public District selectOneDistrict(int id){
        return districtService.selectOneDistrict(id);
    }
    //修改区域
    @RequestMapping("/updateDistrict")
    @ResponseBody
    public int updateDistrict(District district){
        return districtService.updateDistrict(district);
    }
    //删除单条
    @RequestMapping("/deleteDistrictOne")
    @ResponseBody
    public int deleteDistrictOne(int id){
        //删除区域对应的街道
        try{
            return districtService.deleteDistrictOne(id);
        }catch (Exception e){
            try {
                throw new Exception(e.getMessage());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return 0;
    }
    //删除多条
    @RequestMapping("/deleteDistrictBatch")
    @ResponseBody
    public int deleteDistrictBatch(String ids){
        //删除区域对应的街道
        try{
            String[] arr = ids.split(",");
            List<Integer> list= new ArrayList<Integer>();
            for(int i=0;i<arr.length;i++){
                list.add(Integer.parseInt(arr[i]));
            }
            return districtService.deleteDistrictBatch(list);
        }catch (Exception e){
            try {
                throw new Exception(e.getMessage());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return 0;
    }

    //删除详情街道
    @RequestMapping("/deleteDetailsStreetOne")
    @ResponseBody
    public int deleteDetailsStreetOne(int id){
        return districtService.deleteDetailsStreetOne(id);
    }

    //查询所有的区域
    @RequestMapping("/selectDistrictAll")
    @ResponseBody
    public List<District> selectDistrictAll(HttpSession session){
        List<District> list = districtService.selectDistrictAll();
        session.setAttribute("list",list);
        return list;
    }
}
