package ssm.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.pojo.Type;
import ssm.service.ITypeService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/admin")//表示后所有的控制器请求都在/admin目录下
public class TypeController {
    @Autowired
    private ITypeService typeService;

    //分页查询
    @RequestMapping("/selectType")
    @ResponseBody
    public HashMap<String,Object> pageSelect(int page, int rows){ //page表示页码   rows表示页大小
        PageInfo<Type> pageInfo = typeService.selectType(page, rows);
        HashMap map=new HashMap();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
    //区域新增
    @RequestMapping("/insertType")
    @ResponseBody
    public int insertType(Type type){
        return typeService.insertType(type);
    }
    //查询单条
    @RequestMapping("/selectOneType")
    @ResponseBody
    public Type selectOneType(int id){
        return typeService.selectOneType(id);
    }
    //修改区域
    @RequestMapping("/updateType")
    @ResponseBody
    public int updateType(Type type){
        return typeService.updateType(type);
    }
    //删除单条
    @RequestMapping("/deleteTypeOne")
    @ResponseBody
    public int deleteTypeOne(int id){
        return typeService.deleteTypeOne(id);
    }
    //删除多条
    @RequestMapping("/deleteTypeBatch")
    @ResponseBody
    public int deleteTypeBatch(String ids){
        String[] arr = ids.split(",");
        List<Integer> list= new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            list.add(Integer.parseInt(arr[i]));
        }
        return typeService.deleteTypeBatch(list);
    }
    //查询所有类型不分页
    @RequestMapping("/selectTypeAll")
    @ResponseBody
    public List<Type> selectTypeAll(){
        return typeService.selectTypeAll();
    }
}
