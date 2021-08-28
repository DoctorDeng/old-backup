package dao.impl;

import java.util.List;
import java.util.Map;

import bean.Bill;
import dao.BillDao;
import util.DBHelper;

public class BillDaoImpl implements BillDao{

	@Override
	public List<Bill> findAll() {
		return null;
	}

	@Override
	public Bill findOne(int billId) {
		return null;
	}

	@Override
	public boolean add(Bill bill) {
		return false;
	}

	@Override
	public boolean del(int billId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Bill bill) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 多表查询，查询出所有的账单表单数据
	 * @return   返回一个与表单数据对应的表单bean
	 */
	public  List<Map<String,Object>> findBillForm() {
		String sql = "SELECT bi.billId,cu.customerName, cu.idNumber, loginAccount,"
		+" (SELECT sum(TIMESTAMPDIFF(SECOND ,loginInTime,loginOutTime)) FROM oslogin WHERE osid in (SELECT osId FROM billdetail WHERE billId = bi.billId)) as totalTime,"
		+" bi.payWay,bi.payStatus "
						+"FROM bill as bi "
						+"INNER JOIN customer as cu ON bi.customerId = cu.customerId "
						+"INNER JOIN bussiness as ad On bi.customerId = ad.customerId";
		List<Map<String,Object>> list = DBHelper.find(sql, null);
	
		return list;
	}
	/**
	 * 获取指定长度的账单数据
	 * @param index      开始位置
	 * @param pageSize   长度
	 * @return           返回一个与表单数据对应的表单bean的集合
	 */
	public List<Map<String,Object>> findBillFormPage(int index, int pageSize) {
		String sql = "SELECT bi.billId,cu.customerName, cu.idNumber, loginAccount,"
				+" (SELECT sum(TIMESTAMPDIFF(SECOND ,loginInTime,loginOutTime)) FROM oslogin WHERE osid in (SELECT osId FROM billdetail WHERE billId = bi.billId)) as totalTime,"
				+" bi.payWay,bi.payStatus "
				+" FROM bill as bi "
				+" INNER JOIN customer as cu ON bi.customerId = cu.customerId "
				+" INNER JOIN bussiness as ad On bi.customerId = ad.customerId "
				+" LIMIT " + index+ "," +pageSize;
				List<Map<String,Object>> list = DBHelper.find(sql, null);
			
				return list;
	}
	/**
	 * 通过条件来查找用户账单表单数据
	 * @param sqlCondition    查询的条件
	 * @return                用户账单表单信息集合
	 */
	public List<Map<String,Object>> findBillFormBycondition(String sqlCondition) {
		String sql = "SELECT bi.billId,cu.customerName, cu.idNumber, loginAccount,"
				+" (SELECT sum(TIMESTAMPDIFF(SECOND ,loginInTime,loginOutTime)) FROM oslogin WHERE osid in (SELECT osId FROM billdetail WHERE billId = bi.billId)) as totalTime,"
				+" bi.payWay,bi.payStatus "
				+" FROM bill as bi "
				+" INNER JOIN customer as cu ON bi.customerId = cu.customerId "
				+" INNER JOIN bussiness as ad On bi.customerId = ad.customerId " + sqlCondition;
				List<Map<String,Object>> list = DBHelper.find(sql, null);
				return list;
	}
	/**
	 * 多表操作，查找客户（Customer）每个账号的账单记录
	 * @param billId   		     客户账单ID
	 * @return         	                返回客户每个账号的账单记录
	 */
	public List<Map<String,Object>> findBillDetailForm(int billId) {
		String sql = "SELECT bd.billDetailId,os.osAccount,os.serverIp,"
				+"bu.loginAccount,ta.tariffName,os.osId ,ta.tariff,ta.timeTariff,ta.timeLong,ta.tariffType,"
				+"(SELECT sum(TIMESTAMPDIFF(SECOND ,loginInTime,loginOutTime)) FROM oslogin WHERE osid = os.osId) as totalTime "
				+"FROM billDetail as bd "
				+"INNER JOIN bill as bi "
				+"ON bi.billId = bd.billId "
				+"INNER JOIN os "
				+"ON os.osId = bd.osId "
				+"INNER JOIN bussiness as bu "
				+"ON bi.customerId = bu.customerId "
				+"INNER JOIN tariff as ta "
				+"ON ta.tariffId = os.tariffId  "
				+"WHERE bd.billId = " + billId;
		
		List<Map<String,Object>> list = DBHelper.find(sql, null);
		
		return list;
	}
	/**
	 * 获取账单表单数据的总长度
	 * @return
	 */
	public int getBillFormSize() {
		String sql = "SELECT cu.customerId,count(*) as count FROM bill as bi "
					+"INNER JOIN customer as cu ON bi.customerId = cu.customerId "
					+"INNER JOIN bussiness as ad On bi.customerId = ad.customerId ";
		
		List<Map<String,Object>> list = DBHelper.find(sql, null);	
		if (list.size()<1) {
			return 0;
		}
		return Integer.parseInt(list.get(0).get("count").toString());
	}
	
	public static void main(String[] args) {
		BillDaoImpl billDao = new BillDaoImpl();
		/*System.out.println(billDao.findBillForm());*/
		/*Object obj = billDao.findBillDetailForm(2).get(2).get("totalTime");
		if (obj.toString() == null) {
			System.out.println(1);
		}
		if ("".equals(obj.toString())) {
			System.out.println(2);
		}*/
		/*System.out.println(billDao.findBillFormPage(0, 10).size());*/
		System.out.println(billDao.getBillFormSize());
	}
	

}
