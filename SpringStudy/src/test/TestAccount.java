package test;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import practice.entity.Account;
import practice.service.AccountService;

public class TestAccount {
	
	private static ApplicationContext context = null;
	private static Logger log = Logger.getLogger(TestHelloWorld.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if (context == null) {
			context = new ClassPathXmlApplicationContext("spring-config.xml");
		}
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAccount() {
		log.info("=====测试转账开始======");
		AccountService accountService = (AccountService) context.getBean("accountService");
		
		Account inAccount = new Account(1,50);
		Account outAccount = new Account(2,50);
		
		int result = accountService.transferAccounts(inAccount, outAccount);
		if (result==2) {
			log.info("===转账成功");
		} else {
			log.info("===转账失败");
		}
	}

}
