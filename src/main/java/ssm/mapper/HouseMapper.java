package ssm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import ssm.pojo.*;
import ssm.service.IHouseService;
import ssm.util.HouseConditions;

public interface HouseMapper {
    int countByExample(HouseExample example);

    int deleteByExample(HouseExample example);

    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") House record, @Param("example") HouseExample example);

    int updateByExample(@Param("record") House record, @Param("example") HouseExample example);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    List<Info> selectInfo(Integer userid);

    List<Info> selectDel(Integer userid);

    HouseUpdateInfo selectOne(String id);

    List<HouseInfo> selectHouse(Integer isPass);

    List<HouseInfo> search(HouseConditions conditions);

    List<HouseInfo> selectHouseAudit(HouseConditions conditions);

    List<HouseInfo> selectHouseApproved(HouseConditions conditions);
}