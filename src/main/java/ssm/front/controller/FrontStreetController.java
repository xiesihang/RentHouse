package ssm.front.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.pojo.Street;
import ssm.service.IStreetService;

import java.util.List;

@Controller
@RequestMapping("/page")
public class FrontStreetController {
    @Autowired
    private IStreetService streetService;

    @RequestMapping("/selectStreetByDistrictId")
    @ResponseBody
    public List<Street> selectStreetByDistrictId(Integer id){
        return streetService.selectStreetByDistrictId(id);
    }
}
