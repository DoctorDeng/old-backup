package vip.doctordeng.bbs.common.page;

import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName:  Page
 * @Description:TODO 通用的分页类
 * @author: DoctorDeng
 * @date:   2017年4月3日 上午11:00:26   
 * @param <T>
 */
public class Page<T> {
	// 当前页
	private int currPage  = 1;
	// 页面大小
	private int pageSize  = 10;
	// 总页数
	private int totalPage = 1;
	// 首页
	private int indexPage = 1;
	// 尾页
	private int endPage   = 1;
	// 上一页
	private int previousPage = 1;
	// 下一页
	private int nextPage = 1;
	// 数据总条数
	private int totalData = 1;
	//导航页码数
	private int navigateTotalPage=8; 
	//所有导航页号
	private int[] navigatePages;  
	// 页面存储数据,适用于多条数据
	private List<T> resultList;
	//页面存储数据,适用于单条数据
	private T result;
	// 查询数据
	private Map queryData;
	// 数据库查询时的起始位置
	private int sqlStart;

	public Page(int totalData, int currPage, int pageSize) {
		init(totalData, currPage, pageSize);
	}
	
	public Page(int totalData, int currPage) {
		init(totalData, currPage, this.pageSize);
	}
	/**
	 * 初始化页面上一下、下一页、页面导航条、首页、尾页等相关信息
	 * @Title: init   
	 * @Description: TODO
	 * @param: @param totalData
	 * @param: @param pageSize
	 * @param: @param currPage      
	 * @return: void      
	 * @throws
	 */
	private void init(int totalData, int currPage, int pageSize) {
		if (pageSize > 1) {
			this.pageSize  = pageSize;
		}
		this.totalData = totalData;
		this.totalPage = (this.totalData - 1)/this.pageSize + 1;
		this.indexPage = 1;
		this.endPage   = totalPage;
		// 校正输入错误
		if (currPage < 1) {
			this.currPage = 1;
		}else if (currPage > this.totalPage) {
			this.currPage = this.totalPage;
		}else{
			this.currPage = currPage;
		}
		this.sqlStart = (this.currPage - 1) * this.pageSize;
		initNavigatePage();
		initOtherPage();
	}
	/**
	 * 
	 * @Title: initNavigatePage   
	 * @Description: TODO 初始化导航页
	 * @param:       
	 * @return: void      
	 */
	private void initNavigatePage(){
		// 当总页数小于或等于导航页码数时
		if (this.totalPage <= navigateTotalPage) {
			navigatePages = new int[this.totalPage];
			for (int i = 0; i < this.totalPage; i ++) {
				navigatePages[i] = i + 1;
			}
			return;
		}
		
		navigatePages = new int[navigateTotalPage];
		int startNum  = this.currPage - navigateTotalPage/2;
		int endNum    = this.currPage + navigateTotalPage/2;
		
		if (startNum < 1) {
			startNum = 1;
			for (int i = 0; i < navigateTotalPage; i++) {
				navigatePages[i] = startNum ++;
			}
			return;
		}
		
		if (endNum > totalPage) {
			endNum = totalPage;
			for (int i = navigateTotalPage - 1; i >= 0; i--) {
				navigatePages[i] = endNum--;
			}
			return;
		}
		
		for (int i = 0; i < navigateTotalPage; i++) {
			navigatePages[i] = startNum++;
		}
	}
	/**
	 * 初始化上一页、下一页数据
	 * @Title: initOtherPage   
	 * @Description: TODO
	 * @return: void      
	 */
	private void initOtherPage() {
		if (this.currPage != 1 && this.totalPage > 1) {
			this.previousPage = this.currPage - 1;
		}
		if (this.currPage < this.totalPage && this.totalPage >= 2) {
			this.nextPage = this.currPage + 1;
		}
		if (this.currPage == this.totalPage) {
			this.nextPage = this.totalPage;
		}
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getIndexPage() {
		return indexPage;
	}
	public void setIndexPage(int indexPage) {
		this.indexPage = indexPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getPreviousPage() {
		return previousPage;
	}
	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getTotalData() {
		return totalData;
	}
	public void setTotalData(int totalData) {
		this.totalData = totalData;
	}
	public int getNavigateTotalPage() {
		return navigateTotalPage;
	}
	public void setNavigateTotalPage(int navigateTotalPage) {
		this.navigateTotalPage = navigateTotalPage;
	}
	public int[] getNavigatePages() {
		return navigatePages;
	}
	public void setNavigatePages(int[] navigatePages) {
		this.navigatePages = navigatePages;
	}
	public Map getQueryData() {
		return queryData;
	}
	public void setQueryData(Map queryData) {
		this.queryData = queryData;
	}


	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public int getSqlStart() {
		return sqlStart;
	}

	public void setSqlStart(int sqlStart) {
		this.sqlStart = sqlStart;
	}
}