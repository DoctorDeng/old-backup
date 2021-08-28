package test.practice;

public class MyMain {
	public static void main(String[] args) {
		System.out.println("加载配置信息");
		System.out.println("通过加载配置信息加载一个代理工厂Map");
		System.out.println("这个Map存放的是接口Class对应的代理工厂");
		
		SqlSession sqlSession = new SqlSession();
		MyInterface myInterface = sqlSession.getMapper(MyInterface.class);
		String name = myInterface.getNameById(1);
		System.out.println("查找到的名字是:" + name);
	}
}
