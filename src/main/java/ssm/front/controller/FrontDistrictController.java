package ssm.front.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.pojo.District;
import ssm.service.IDistrictService;

import java.util.List;

@Controller
@RequestMapping("/page")
public class FrontDistrictController {
    @Autowired
    private IDistrictService districtServices;

    @RequestMapping("/selectDistrictAll")
    @ResponseBody
    public List<District> selectDistrictAll(){
        return districtServices.selectDistrictAll();
    }

}
