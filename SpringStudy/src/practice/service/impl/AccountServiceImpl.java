package practice.service.impl;


import practice.AccountDao;
import practice.entity.Account;
import practice.service.AccountService;
/*//注解方式实现事务
@Transactional*/
public class AccountServiceImpl implements AccountService {
	
	private AccountDao accountDao;
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public int transferAccounts(Account inAccount, Account outAccount) {
		int inResult  = accountDao.addAccountMoney(inAccount);
		int outResult = accountDao.getAccountMoney(outAccount);
		
		return inResult + outResult;
	}

}
