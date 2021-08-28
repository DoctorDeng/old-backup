package practice.aopTest;
/**
 * 被切入类
 * @author Doctor邓
 *
 */
public class TestAspect {
	public String doSome() {
		System.out.println("=====正在执行=====");
		return "哈哈哈";
	}
	
	public void doSomeAround(String name,int age) {
		System.out.println("参数是:===name:->"+name+"===age->"+age+"====");
	}
}
