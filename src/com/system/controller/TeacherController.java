package com.system.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.system.po.CourseCustom;
import com.system.po.Coursedetails;
import com.system.po.SelectedCourseCustom;
import com.system.po.TeacherCustom;
import com.system.service.CourseService;
import com.system.service.CoursedetailsService;
import com.system.service.SelectedCourseService;
import com.system.service.TeacherService;

/**
 * Created by Jacey on 2017/7/6.
 */

@Controller
@RequestMapping(value = "teacher")
public class TeacherController {

    @Resource(name = "teacherServiceImpl")
    private TeacherService teacherService;

    @Resource(name = "courseServiceImpl")
    private CourseService courseService;

    @Resource(name = "selectedCourseServiceImpl")
    private SelectedCourseService selectedCourseService;
    
    @Resource(name = "coursedetailsServiceImpl")
    private CoursedetailsService coursedetailsService;

    // 显示我的课程
    @RequestMapping(value = "/showCourse")
    public String stuCourseShow(Model model) throws Exception {

        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();

        List<CourseCustom> list = courseService.findByTeacherID(Integer.parseInt(username));
        model.addAttribute("courseList", list);

        return "teacher/showCourse";
    }

    // 显示成绩
    @RequestMapping(value = "/gradeCourse")
    public String gradeCourse(Integer id, Model model) throws Exception {
        if (id == null) {
            return "";
        }
        List<SelectedCourseCustom> list = selectedCourseService.findByCourseID(id);
        model.addAttribute("selectedCourseList", list);
        return "teacher/showGrade";
    }
    
    // hub-显示老师的个人信息
    @RequestMapping(value = "/teacherself")
    public String teacherself(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception {
    	
    	//hub-获取到当前登陆账号的用户
    	String username = "";
    	Cookie[] userCookie = request.getCookies();
		for(Cookie cookie : userCookie){
	        if(cookie.getName().equals("username")){
	            username = cookie.getValue();
	        }
	    }
		TeacherCustom teacher = teacherService.findById(Integer.parseInt(username));
    	model.addAttribute("teacher", teacher);
    	return "teacher/showSelf";
    }

    // 打分
    @RequestMapping(value = "/mark", method = {RequestMethod.GET})
    public String markUI(SelectedCourseCustom scc, Model model) throws Exception {

        SelectedCourseCustom selectedCourseCustom = selectedCourseService.findOne(scc);

        model.addAttribute("selectedCourse", selectedCourseCustom);

        return "teacher/mark";
    }

    // 打分
    @RequestMapping(value = "/mark", method = {RequestMethod.POST})
    public String mark(SelectedCourseCustom scc) throws Exception {

        selectedCourseService.updataOne(scc);

        return "redirect:/teacher/gradeCourse?id="+scc.getCourseid();
    }

    //修改密码
    @RequestMapping(value = "/passwordRest")
    public String passwordRest() throws Exception {
        return "teacher/passwordRest";
    }
    
    // 显示课程的详情
    @RequestMapping("showCourseDetails_teacher")
    public String showCourseDetails_teacher(Model model,HttpServletRequest request) throws Exception {
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
    	
    	return "teacher/showCourseDetails";
    }
    
    //上传图片
    @RequestMapping("/uploadimage")
	public void uploadImage(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取web项目的全路径
		String strDirPath = request.getSession().getServletContext().getRealPath("/");
		//创建临时目录
		String tmpPath = strDirPath+"/temp";
		File tmpFile = new File(tmpPath);
		String savePath = tmpPath;
		System.out.println("目录为："+savePath);
		if (!tmpFile.exists()) {
		     //创建临时目录
		     tmpFile.mkdir();
		}
		
		FileItem file = null;
//        InputStream in = null;
        ByteArrayOutputStream swapStream1 = null;

	    //1、创建一个DiskFileItemFactory工厂  
	    DiskFileItemFactory factory = new DiskFileItemFactory();  
	    //设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
	    factory.setSizeThreshold(1024*100);//设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB
	    //设置上传时生成的临时文件的保存目录
	    factory.setRepository(tmpFile);
	    //2、创建一个文件上传解析器  
	    ServletFileUpload upload = new ServletFileUpload(factory);

	    //解决上传文件名的中文乱码  
	    upload.setHeaderEncoding("UTF-8");   
	    
	    //3、判断提交上来的数据是否是上传表单的数据
	    if(!ServletFileUpload.isMultipartContent(request)){
	    	System.out.println("是表单数据");
		    //按照传统方式获取数据
		    return;
	    }
	    //设置上传单个文件的大小的最大值，目前是设置为1024*1024字节，也就是1MB
	    upload.setFileSizeMax(1024*1024);
	    String filename = "";
	    
	    // 1. 得到 FileItem 的集合 items  
	    List<FileItem> items = upload.parseRequest(request);
	    //logger.info("items:{}", items.size());
	    // 2. 遍历 items:  
	    for (FileItem item : items) {  
	        //String name = item.getFieldName();  
	        System.out.println("文件类型："+item.getContentType());
	        //logger.info("fieldName:{}", name);
	        // 若是一个一般的表单域, 打印信息  
	        
	      //如果fileitem中封装的是普通输入项的数据
            if(item.isFormField()){
            	System.out.println("普通输入数据");
                String name = item.getFieldName();
                //解决普通输入项的数据的中文乱码问题
                String value = item.getString("UTF-8");
                //value = new String(value.getBytes("iso8859-1"),"UTF-8");
                System.out.println(name + "=" + value);
            }else{//如果fileitem中封装的是上传文件
            	System.out.println("上传文件数据");
                //得到上传的文件名称，
                filename = item.getName();
                System.out.println("文件名称："+filename);
                if(filename==null || filename.trim().equals("")){
                    continue;
                }
                //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                filename = filename.substring(filename.lastIndexOf("\\")+1);
                //得到上传文件的扩展名
                String fileExtName = filename.substring(filename.lastIndexOf(".")+1);
                //如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
                System.out.println("上传的文件的扩展名是："+fileExtName);
                //获取item中的上传文件的输入流
                InputStream in = item.getInputStream();
                //得到文件保存的名称
                String saveFilename = makeFileName(filename);
                //得到文件的保存目录
                String realSavePath = makePath(saveFilename, savePath);
                //创建一个文件输出流
                FileOutputStream out = new FileOutputStream(realSavePath + "\\" + saveFilename);
                //创建一个缓冲区
                byte buffer[] = new byte[1024];
                //判断输入流中的数据是否已经读完的标识
                int len = 0;
                //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                while((len=in.read(buffer))>0){
                    //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                    out.write(buffer, 0, len);
                }
                //关闭输入流
                in.close();
                //关闭输出流
                out.close();
                //删除处理文件上传时生成的临时文件
                //item.delete();
                System.out.println("文件上传成功！");
            }	             
	    }
	    
	   
	    //上传成功后，还要将上传的文件名保存在数据库,image传递过来1，2，3
	    String parameter = request.getParameter("image");
	    String courseid = request.getParameter("courseid");
	    Coursedetails coursedetails = new Coursedetails();
	    coursedetails.setCourseid(Integer.parseInt(courseid));
	    if("1".equals(parameter)) {
	    	coursedetails.setFile1(filename);
	    }else if("2".equals(parameter)) {
	    	coursedetails.setFile2(filename);
	    }else if("3".equals(parameter)){
	    	coursedetails.setFile3(filename);
	    }
	    coursedetailsService.updateCoursedetails(coursedetails);
	    
        PrintWriter out = response.getWriter();  
        out.write("文件上传成功");  
	}
    /**
     * @Method: makeFileName
     * @Description: 生成上传文件的文件名，文件名以：uuid+"_"+文件的原始名称
     * @Anthor:孤傲苍狼
     * @param filename 文件的原始名称
     * @return uuid+"_"+文件的原始名称
     */ 
     private String makeFileName(String filename){  //2.jpg
         //为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
         return UUID.randomUUID().toString() + "_" + filename;
     }
     
     /**
      * 为防止一个目录下面出现太多文件，要使用hash算法打散存储
     * @Method: makePath
     * @Description: 
     * @Anthor:孤傲苍狼
     *
     * @param filename 文件名，要根据文件名生成存储目录
     * @param savePath 文件存储路径
     * @return 新的存储目录
     */ 
     private String makePath(String filename,String savePath){
         //得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
         int hashcode = filename.hashCode();
         int dir1 = hashcode&0xf;  //0--15
         int dir2 = (hashcode&0xf0)>>4;  //0-15
         //构造新的保存目录
         String dir = savePath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
         //File既可以代表文件也可以代表目录
         File file = new File(dir);
         //如果目录不存在
         if(!file.exists()){
             //创建目录
             file.mkdirs();
         }
         return dir;
     }
}
