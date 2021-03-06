package practice.transactionXml;
/**
 * 转账案例Dao层接口
 * @author Doctor邓
 *
 */
public interface AccountDao {
	/**
	 * 
	 * @param out   :转出账号
	 * @param money :转账金额
	 */
	public void outMoney(String out,Double money);
	/**
	 * 
	 * @param in    :转入账号
	 * @param money :转账金额
	 */
	public void inMoney(String in,Double money);
}
