package com.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.system.po.Coursedetails;
import com.system.po.CoursedetailsExample;

public interface CoursedetailsMapper {
    int countByExample(CoursedetailsExample example);

    int deleteByExample(CoursedetailsExample example);

    int deleteByPrimaryKey(Integer courseid);

    int insert(Coursedetails record);

    int insertSelective(Coursedetails record);

    List<Coursedetails> selectByExample(CoursedetailsExample example);

    Coursedetails selectByPrimaryKey(Integer courseid);

    int updateByExampleSelective(@Param("record") Coursedetails record, @Param("example") CoursedetailsExample example);

    int updateByExample(@Param("record") Coursedetails record, @Param("example") CoursedetailsExample example);

    int updateByPrimaryKeySelective(Coursedetails record);

    int updateByPrimaryKey(Coursedetails record);
}