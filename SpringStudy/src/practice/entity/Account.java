package practice.entity;

public class Account {
	//账户ID
	private int accountId;
	//学生ID
	private int studentId;
	//钱金额
	private int money;
	
	public Account(){}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", studentId=" + studentId + ", money=" + money + "]";
	}

	public Account(int accountId, int studentId, int money) {
		super();
		this.accountId = accountId;
		this.studentId = studentId;
		this.money = money;
	}

	public Account(int studentId, int money) {
		super();
		this.studentId = studentId;
		this.money = money;
	}
	
}
