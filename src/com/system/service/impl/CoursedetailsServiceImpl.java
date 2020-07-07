package com.system.service.impl;

import com.system.mapper.CollegeMapper;
import com.system.mapper.CoursedetailsMapper;
import com.system.po.College;
import com.system.po.CollegeExample;
import com.system.po.CourseExample;
import com.system.po.Coursedetails;
import com.system.po.CoursedetailsExample;
import com.system.po.CoursedetailsExample.Criteria;
import com.system.service.CollegeService;
import com.system.service.CoursedetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jacey on 2017/6/30.
 */
@Service
public class CoursedetailsServiceImpl implements CoursedetailsService {
	
	@Autowired
	private CoursedetailsMapper coursedetailsMapper;

	@Override
	public void insertCoursedetails(Coursedetails coursedetails) {
		coursedetailsMapper.insert(coursedetails);
	}

	@Override
	public void updateCoursedetails(Coursedetails coursedetails) {
		coursedetailsMapper.updateByPrimaryKey(coursedetails);
	}

	@Override
	public Coursedetails getCoursedetailsByID(Integer courseid) {
		CoursedetailsExample coursedetailsExample = new CoursedetailsExample();
        //自定义查询条件
        Criteria createCriteria = coursedetailsExample.createCriteria();
        //根据教师id查课程
        createCriteria.andCourseidEqualTo(courseid);
		List<Coursedetails> selectByExample = coursedetailsMapper.selectByExample(coursedetailsExample);
		Coursedetails coursedetails = null;
		if(selectByExample.size()>0) {
			coursedetails = selectByExample.get(0);
		}
		return coursedetails;
	}

	@Override
	public void deleteCoursedetails(Integer courseid) {
		CoursedetailsExample coursedetailsExample = new CoursedetailsExample();
        //自定义查询条件
        Criteria createCriteria = coursedetailsExample.createCriteria();
        //根据教师id查课程
        createCriteria.andCourseidEqualTo(courseid);
		coursedetailsMapper.deleteByExample(coursedetailsExample);
	}


}
