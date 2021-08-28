package practice.transaction;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * 转账案例的测试类
 * @author Doctor邓
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-transaction.xml")
public class TestTransacation {
	@Resource(name="accountService")
	private AccountService accountService;
	
	@Test
	public void test1(){
		accountService.transfer("aaa", "bbb", 200.00);
	}
}
