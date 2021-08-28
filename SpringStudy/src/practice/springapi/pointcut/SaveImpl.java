package practice.springapi.pointcut;

public class SaveImpl implements Save {

	@Override
	public String save() {
		System.out.println("正在存入东西！");
		return "1000$";
	}
}
