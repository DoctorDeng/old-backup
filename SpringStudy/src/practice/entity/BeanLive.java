package practice.entity;

public class BeanLive {
	//测试Bean的初始化方法
	public  void init() {
		System.out.println("Bean初始化了");
	}
	//测试Bean的销毁方法
	public void destroy() {
		System.out.println("Bean被销毁了");
	}
}
