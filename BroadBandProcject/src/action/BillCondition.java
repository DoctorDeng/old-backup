package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.viewBean.BillFormBean;
import service.BillService;

/**
 * Servlet implementation class BillTest
 */
@WebServlet("/BillTest")
public class BillCondition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillCondition() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BillService billService = new BillService();
		String idNumber = request.getParameter("idNumber");
		String loginAccount = request.getParameter("loginAccount");
		String customerName = request.getParameter("customerName");
		
		List<BillFormBean> manyBillFrom = new ArrayList<>();
		List<BillFormBean> billList = billService.getBillFormByCondition(idNumber, loginAccount, customerName);
		if(billList.size() >7) {
			for (int i=0; i<7;i ++) {
				manyBillFrom.add(billList.get(i));
			}
			PrintWriter out = response.getWriter();
			for(BillFormBean billForm :manyBillFrom) {
				out.println("<tr>");
				out.println("<td>" +billForm.getBillId()+"</td>");
				out.println("<td>" +billForm.getCustomerName()+"</td>");
				out.println("<td>" +billForm.getIdNumber()+"</td>");
				out.println("<td>" +billForm.getLoginAccount()+"</td>");
				out.println("<td>" +billForm.getTimeLong()+"</td>");
				out.println("<td>" +billForm.getPayWay()+"</td>");
				out.println("<td>" +(billForm.getPayStatus()=="1"?"已支付":"未支付")+"</td>");
				out.println("<td><a href=\""+request.getContextPath()+"/BillAction?operation=showDetailBill&billId=" +billForm.getBillId()+"\" title=\"账单明细\">明细</a></td>");
				out.print("</tr>");
			}
			out.flush();
			out.close();
			
		} else {
			PrintWriter out = response.getWriter();
			if (billList.size() == 0) {
				out.println("<tr>");
				out.println("<td>没有搜索到!</td>");
				out.println("<td>没有搜索到!</td>");
				out.println("<td>没有搜索到!</td>");
				out.println("<td>没有搜索到!</td>");
				out.println("<td>没有搜索到!</td>");
				out.println("<td>没有搜索到!</td>");
				out.println("<td>没有搜索到!</td>");
				out.println("<td>没有搜索到!</td>");
				out.print("</tr>");
			}
			for(BillFormBean billForm :billList) {
				out.println("<tr>");
				out.println("<td>" +billForm.getBillId()+"</td>");
				out.println("<td>" +billForm.getCustomerName()+"</td>");
				out.println("<td>" +billForm.getIdNumber()+"</td>");
				out.println("<td>" +billForm.getLoginAccount()+"</td>");
				out.println("<td>" +billForm.getTimeLong()+"</td>");
				out.println("<td>" +billForm.getPayWay()+"</td>");
				out.println("<td>" +(billForm.getPayStatus()=="1"?"已支付":"未支付")+"</td>");
				out.println("<td><a href=\""+request.getContextPath()+"/BillAction?operation=showDetailBill&billId=" +billForm.getBillId()+"\" title=\"账单明细\">明细</a></td>");
				out.print("</tr>");
			}
			out.flush();
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
