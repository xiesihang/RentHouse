package ssm.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.pojo.District;
import ssm.pojo.Street;
import ssm.service.IStreetService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/admin")//表示后所有的控制器请求都在/admin目录下
public class StreetController {
    @Autowired
    private IStreetService streetService;

    @RequestMapping("/selectStreet")
    @ResponseBody
    public HashMap<String,Object> selectStreet(int page, int rows){ //page表示页码   rows表示页大小
        PageInfo<Street> pageInfo = streetService.selectStreet(page, rows);
        HashMap map=new HashMap();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
    //查询详情街道
    @RequestMapping("/streetDetails")
    @ResponseBody
    public HashMap<String,Object> StreetDetails(int page, int rows,int did){
        PageInfo<Street> pageInfo = streetService.streetDetails(page, rows,did);
        HashMap<String,Object> map=new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
    //街道新增
    @RequestMapping("/insertStreet")
    @ResponseBody
    public int insertStreet(Street street){
        return streetService.insertStreet(street);
    }
    //查询单条
    @RequestMapping("/selectOneStreet")
    @ResponseBody
    public Street selectOneStreet(int id){
        return streetService.selectOneStreet(id);
    }
    //修改街道
    @RequestMapping("/updateStreet")
    @ResponseBody
    public int updateStreet(Street street){
        return streetService.updateStreet(street);
    }
    //删除单条
    @RequestMapping("/deleteStreetOne")
    @ResponseBody
    public int deleteStreetOne(int id){
        return streetService.deleteStreetOne(id);
    }
    //删除多条
    @RequestMapping("/deleteStreetBatch")
    @ResponseBody
    public int deleteStreetBatch(String ids){
        String[] arr = ids.split(",");
        List<Integer> list= new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            list.add(Integer.parseInt(arr[i]));
        }
        return streetService.deleteStreetBatch(list);
    }
    //查询所有的街道
    @RequestMapping("/insertBySelectDistrictAll")
    @ResponseBody
    public List<District> insertBySelectDistrictAll(){
        return streetService.insertBySelectDistrictAll();
    }
    //根据区域id查询下拉框街道
    @RequestMapping("/selectStreetByDistrictId")
    @ResponseBody
    public List<Street> selectStreetByDistrictId(Integer id){
        return streetService.selectStreetByDistrictId(id);
    }
}
