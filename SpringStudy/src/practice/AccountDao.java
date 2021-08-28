package practice;

import practice.entity.Account;

public interface AccountDao {
/*	public int insertAccount(Account account);
	public int updateAccount(Account account);
	public int deleteAccount(Account account);*/
	/**
	 * 存入指定账户金额
	 * @param account 
	 * @return
	 */
	public int addAccountMoney(Account account);
	/**
	 * 取出指定账户金额
	 * @param account
	 * @return
	 */
	public int getAccountMoney(Account account);
}
