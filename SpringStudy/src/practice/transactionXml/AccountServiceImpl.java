package practice.transactionXml;

import org.springframework.transaction.annotation.Transactional;

/**
 * 转账业务案例实现类
 * @author Doctor邓
 *
 */
public class AccountServiceImpl implements AccountService {
	//注入转账的DAO的类
	private AccountDao accountDao;
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void transfer(String out, String in, Double money) {
		accountDao.outMoney(out, money);
		//int i = 1/0;
		accountDao.inMoney(in, money);
	}
}
