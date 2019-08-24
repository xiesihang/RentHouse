package ssm.front.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.pojo.Type;
import ssm.service.IStreetService;
import ssm.service.ITypeService;

import java.util.List;

@Controller
@RequestMapping("/page")
public class FrontTypeController {
    @Autowired
    private ITypeService typeService;

    @RequestMapping("/selectTypeAll")
    @ResponseBody
    public List<Type> selectTypeAll(){
        return typeService.selectTypeAll();
    }
}
