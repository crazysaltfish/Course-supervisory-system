package com.system.controller;

import com.system.exception.CustomException;
import com.system.po.*;
import com.system.service.CourseService;
import com.system.service.CoursedetailsService;
import com.system.service.SelectedCourseService;
import com.system.service.StudentService;
import com.system.service.TeacherService;

import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

/**
 * Created by Jacey on 2017/7/5.
 */
@Controller
@RequestMapping(value = "student")
public class StudentController {

    @Resource(name = "courseServiceImpl")
    private CourseService courseService;

    @Resource(name = "studentServiceImpl")
    private StudentService studentService;
    

    @Resource(name = "selectedCourseServiceImpl")
    private SelectedCourseService selectedCourseService;
    
    @Resource(name = "teacherServiceImpl")
    private TeacherService teacherService;
    @Resource(name = "coursedetailsServiceImpl")
    private CoursedetailsService coursedetailsService;

    @RequestMapping(value = "/showCourse")
    public String stuCourseShow(Model model, Integer page) throws Exception {

        List<CourseCustom> list = null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(courseService.getCountCouse());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = courseService.findByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            list = courseService.findByPaging(page);
        }

        model.addAttribute("courseList", list);
        model.addAttribute("pagingVO", pagingVO);

        return "student/showCourse";
    }
    
    //hub20180509
    @RequestMapping(value = "/showCourse_wx")
    public void stuCourseShow_wx(HttpServletRequest request,HttpServletResponse response) throws Exception {
    	System.out.println("进入");
    	String parameter = request.getParameter("pagenum");
    	Integer page= Integer.parseInt(parameter);
    	System.out.println();
        List<CourseCustom> list = null;
        //页码对象
        PagingVO pagingVO = new PagingVO();
        //设置总页数
        pagingVO.setTotalCount(courseService.getCountCouse());
        if (page == null || page == 0) {
            pagingVO.setToPageNo(1);
            list = courseService.findByPaging(1);
        } else {
            pagingVO.setToPageNo(page);
            list = courseService.findByPaging(page);
        }

        JSONObject jo = new JSONObject();
        jo.put("courseList", list);
        jo.put("pagingVO", pagingVO);
        System.out.println("发送数据");
        response.getWriter().write(jo.toString());
    }
    
    //hub-学生的个人信息
    @RequestMapping(value = "/studentself")
    public String studentself(Model model, HttpServletRequest request,HttpServletResponse response) throws Exception {
    	
    	//hub-获取到当前登陆账号的用户
    	String username = "";
    	Cookie[] userCookie = request.getCookies();
		for(Cookie cookie : userCookie){
	        if(cookie.getName().equals("username")){
	            username = cookie.getValue();
	        }
	    }
    	
    	StudentCustom student = studentService.findById(Integer.parseInt(username));
    	
    	model.addAttribute("student", student);
    	
    	return "student/showSelf";
    }
    
    //hub-搜索课程
    @RequestMapping(value = "/selectCourse", method = {RequestMethod.POST})
    private String selectCourse(String findByName, Model model) throws Exception {

        List<CourseCustom> list = courseService.findByName(findByName);
        model.addAttribute("courseList", list);
        return "student/showCourse";
    }
    
    // 选课操作
    @RequestMapping(value = "/stuSelectedCourse")
    public String stuSelectedCourse(int id) throws Exception {
        //获取当前用户名
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();

        SelectedCourseCustom selectedCourseCustom = new SelectedCourseCustom();
        selectedCourseCustom.setCourseid(id);
        selectedCourseCustom.setStudentid(Integer.parseInt(username));

        SelectedCourseCustom s = selectedCourseService.findOne(selectedCourseCustom);

        if (s == null) {
            selectedCourseService.save(selectedCourseCustom);
        } else {
            throw new CustomException("该门课程你已经选了，不能再选");
        }

        return "redirect:/student/selectedCourse";
    }

    // 退课操作
    @RequestMapping(value = "/outCourse")
    public String outCourse(int id) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();

        SelectedCourseCustom selectedCourseCustom = new SelectedCourseCustom();
        selectedCourseCustom.setCourseid(id);
        selectedCourseCustom.setStudentid(Integer.parseInt(username));

        selectedCourseService.remove(selectedCourseCustom);

        return "redirect:/student/selectedCourse";
    }

    // 已选课程
    @RequestMapping(value = "/selectedCourse")
    public String selectedCourse(Model model) throws Exception {
        //获取当前用户名
        Subject subject = SecurityUtils.getSubject();
        StudentCustom studentCustom = studentService.findStudentAndSelectCourseListByName((String) subject.getPrincipal());

        List<SelectedCourseCustom> list = studentCustom.getSelectedCourseList();

        model.addAttribute("selectedCourseList", list);

        return "student/selectCourse";
    }

    // 已修课程
    @RequestMapping(value = "/overCourse")
    public String overCourse(Model model) throws Exception {

        //获取当前用户名
        Subject subject = SecurityUtils.getSubject();
        StudentCustom studentCustom = studentService.findStudentAndSelectCourseListByName((String) subject.getPrincipal());

        List<SelectedCourseCustom> list = studentCustom.getSelectedCourseList();

        model.addAttribute("selectedCourseList", list);

        return "student/overCourse";
    }

    //修改密码
    @RequestMapping(value = "/passwordRest")
    public String passwordRest() throws Exception {
        return "student/passwordRest";
    }

    // 显示课程的详情
    @RequestMapping("showCourseDetails")
    public String showCourseDetails(Model model,HttpServletRequest request) throws Exception {
    	String courseid = request.getParameter("courseid");
    	System.out.println("courseid:"+courseid);
    	Integer courseid1 = Integer.parseInt(courseid);
    	//获取当前用户名
    	Coursedetails coursedetailsByID = coursedetailsService.getCoursedetailsByID(courseid1);
    	model.addAttribute("coursedetails", coursedetailsByID);
    	//根据ID拿到课程
    	CourseCustom findById = courseService.findById(courseid1);
    	model.addAttribute("coursename", findById.getCoursename());
    	//根据teacherid拿到teachername
    	String teachername = teacherService.findById(findById.getTeacherid()).getUsername();
    	model.addAttribute("teachername", teachername);
    	
    	return "student/showCourseDetails";
    }
    

}
