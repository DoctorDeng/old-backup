package practice.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import practice.entity.Person;

/**
 * 练习Spring的自动拆箱装箱
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/springTest")
public class SpringTest {
	/**
	 * 通过和表单中name设置成相同的名称的类的属性，把该类的对象作为参数，即可注入到该对象中
	 * @param person
	 * @return
	 */
	@RequestMapping("/getPerson")
	public String getPerson(Person person){
		System.out.println(person.toString());
		return "devanning";
	}
	/**
	 * 通过Model可以返回多个值
	 * @param person
	 * @param model
	 * @return
	 */
	@RequestMapping("/getPersonByModel")
	public String getPersonByModel(Person person,Model model){
		model.addAttribute("newPerson",person);
		model.addAttribute("hello","我是Model版Hello");
		return "devanning";
	}
	/**
	 * 通过ModelAndView来向前台传输数据
	 * @param person
	 * @return
	 */
	@RequestMapping("/getPersonByModelView")
	public ModelAndView getPersonByModelView(Person person){
		ModelAndView mv = new ModelAndView();
		mv.addObject("person",person);
		mv.addObject("hello","我是ModelAndView版 hello");
		
		mv.setViewName("devanning");
		return mv;
	}
	/**
	 * 通过request对象获取前台参数
	 * @param request
	 * @return
	 */
	@RequestMapping("/inputPersonToServlet")
	public String  inputPersonToServlet(HttpServletRequest request) {
		String name = request.getParameter("name");
		String age  = request.getParameter("age");
		String sex  = request.getParameter("sex");
		
		Person person = new Person();
		person.setName(name);
		person.setAge(Integer.parseInt(age));
		person.setSex(sex);
		System.out.println(person.toString());
		return "devanning";
	}
	/**
	 * 通过方法参数来获取表单数据
	 * @param name
	 * @param age
	 * @param sex
	 * @return
	 */
	@RequestMapping("/inputPersonByParameter")
	public String inputPersonByParameter(String name, String age, String sex){
		Person person = new Person();
		person.setName(name);
		person.setAge(Integer.parseInt(age));
		person.setSex(sex);
		System.out.println(person.toString());
		return "devanning";
	}
	/**
	 * 使用注解指定表单中提交的参数名称注入给自定方法参数
	 * @param name
	 * @param age
	 * @param sex
	 * @return
	 */
	@RequestMapping("/inputPersonAnnotation")
	public String inputPersonAnnotation(@RequestParam("username")String name,String age, String sex) {
		Person person = new Person();
		person.setName(name);
		person.setAge(Integer.parseInt(age));
		person.setSex(sex);
		System.out.println(person.toString());
		return "devanning";
	}
	/**
	 * 测试SpringMVC和Ajax交互
	 * @param name
	 * @param age
	 * @param out
	 * @return
	 */
	@RequestMapping("/ajaxTest") 
	public String ajaxTest(String name,String age,PrintWriter out) {
		System.out.println("姓名:"+name+"=="+"年龄:"+age);
		/**
		 * 输出从前台页面传输过来的值
		 */
		out.print("姓名:"+name+"=="+"年龄:"+age);
		out.flush();
		out.close();
		return "";
	}
	
	@RequestMapping("resetTest/{id}")
	/**
	 * 使用 @PathVariable 映射路径变量
	 * @param id
	 * @param model
	 * @return
	 */
	public String resetTest(@PathVariable()String id,Model model){
		System.out.println(id);
		if("1".equals(id)) {
			model.addAttribute("name","文章一");
		} else if("2".equals(id)) {
			model.addAttribute("name","文章二");
		} else if("3".equals(id)) {
			model.addAttribute("name","文章三");
		} 
		return "testReset";
	}
	/**
	 * 测试文件上传
	 * @return
	 */
	@SuppressWarnings("finally")
	@RequestMapping("/testUploadFile")
	public String testUploadFile(@RequestParam("file")MultipartFile file, HttpServletRequest request){
		/**
		 * 获取当前项目根路径
		 * request.getServletContext().getRealPath("") 获取当前运行文件的据对路径
		 */
		String path = request.getServletContext().getRealPath("/");
		System.out.println(path);
		System.out.println(request.getServletContext().getRealPath(""));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date date = new Date();
		/**
		 * 获得格式化的当前日期
		 */
		String nowDate = sdf.format(date);
		/**
		 * 获取原文件的文件名
		 */
		String fileName = file.getOriginalFilename();
		
		String[] temps = fileName.split("\\.");
		/**
		 * 获取文件后缀
		 */
		String fileType = temps[1];
		try {
			/**
			 * 将文件传输到指定位置
			 * file.getOriginalFilename():获取文件原文件文件名
			 */
			file.transferTo(new File(path+"/"+nowDate+"."+fileType));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			return "success";
		}
	}
	
   public static void main(String[] args) {
	 final String test = "aa.a.txt";
	 System.out.println(test.indexOf("."));
   }
}