package com.system.service;

import com.system.po.Coursedetails;

import java.util.List;

/**
 * CourseService课程信息.
 */
public interface CoursedetailsService {
    
	//插入一条记录
	void insertCoursedetails(Coursedetails coursedetails);
	
	//更新一条记录
	void updateCoursedetails(Coursedetails coursedetails);
	
	//获取一条记录
	Coursedetails getCoursedetailsByID(Integer courseid);
	
	//删除一条记录
	void deleteCoursedetails(Integer courseid);
	
	
}
