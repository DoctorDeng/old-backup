package practice.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import practice.AccountDao;
import practice.entity.Account;

public class AccountDaoImpl implements AccountDao {
	//等同于jdbc或mybatis
	private JdbcTemplate jdbcTemplate;
	//注入要提供set方法
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public int addAccountMoney(Account account) {
		String sql = "update account set money = money + ? where studentId = ?";
		Object[] params = new Object[]{account.getMoney(),account.getStudentId()};
		return jdbcTemplate.update(sql,params);
	}
	@Override
	public int getAccountMoney(Account account) {
		String sql = "update account2 set money = money - ? where studentId = ?";
		Object[] params = new Object[]{account.getMoney(),account.getStudentId()};
		return jdbcTemplate.update(sql,params);
	}
	
}
