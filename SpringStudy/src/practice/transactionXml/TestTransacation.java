package practice.transactionXml;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * 转账案例的测试类,使用Spring的声明式事务
 * @author Doctor邓
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-transaction-xml.xml")
public class TestTransacation {
	/**
	 * 注入代理类：因为代理类进行增强的操作
	 */
	//@Resource(name="accountService")
	@Resource(name="accountServiceProxy")
	private AccountService accountService;
	
	@Test
	public void test1(){
		accountService.transfer("aaa", "bbb", 200.00);
	}
}
