package com.system.controller;

import com.system.po.CourseCustom;
import com.system.po.Coursedetails;
import com.system.po.PagingVO;
import com.system.po.Userlogin;
import com.system.service.CollegeService;
import com.system.service.CourseService;
import com.system.service.CoursedetailsService;
import com.system.service.TeacherService;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Jacey on 2017/6/30.
 */
@Controller
public class LoginController {
	
	@Resource(name = "teacherServiceImpl")
    private TeacherService teacherService;

    @Resource(name = "courseServiceImpl")
    private CourseService courseService;

    @Resource(name = "collegeServiceImpl")
    private CollegeService collegeService;
    
    @Resource(name = "coursedetailsServiceImpl")
    private CoursedetailsService coursedetailsService;

    //登录跳转
    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String loginUI() throws Exception {
    	System.out.println("进入get登陆");
        return "../../login";
    }

    //登录表单处理
    @RequestMapping(value = "login", method = {RequestMethod.POST})
    public String login(Userlogin userlogin,HttpServletRequest request,HttpServletResponse response) throws Exception {

    	//Shiro实现登录
        UsernamePasswordToken token = new UsernamePasswordToken(userlogin.getUsername(),
                userlogin.getPassword());
        Subject subject = SecurityUtils.getSubject();


        //如果获取不到用户名就是登录失败，但登录失败的话，会直接抛出异常
        subject.login(token);

        //hub-保存到cookie
        //用户名和密码验证成功后，将用户名存在cookie里面，以后调用，注意要用response加入到浏览器中
        Cookie cookie = new Cookie("username", userlogin.getUsername()); 
        response.addCookie(cookie);
        
        if (subject.hasRole("admin")) {
            return "redirect:/admin/showStudent";
        } else if (subject.hasRole("teacher")) {
            return "redirect:/teacher/showCourse";
        } else if (subject.hasRole("student")) {
            return "redirect:/student/showCourse";
        }

        return "/login";
    }
    @RequestMapping(value = "logout")
    public String logout() throws Exception {
    	System.out.println("注销");
    	return "../../login";
    }
    
    //hub-游客登陆
    @RequestMapping(value = "tourist")
    public String tourist(Model model, Integer page) throws Exception {
    	//初次登陆
    	page=0;
    	
    	//游客可以查看所有的课程
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

        return "tourist/tourist_showCourse";
    	
    }
    
    // hub-游客课程信息显示
    @RequestMapping("/tourist_showCourse")
    public String tourist_showCourse(Model model, Integer page) throws Exception {

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

        return "tourist/tourist_showCourse";
    }
    
    // 显示课程的详情
    @RequestMapping("showCourseDetails_tourist")
    public String showCourseDetails_tourist(Model model,HttpServletRequest request) throws Exception {
    	String courseid = request.getParameter("courseid");
    	System.out.println("courseidtourist1:"+courseid);
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
    	
    	System.out.println("courseidtourist2:");
    	return "tourist/showCourseDetails";
    }
}
