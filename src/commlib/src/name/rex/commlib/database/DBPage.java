package name.rex.commlib.database;

public class DBPage {
	
	private int pageSize = 10;
	private int current = 1;
	
	private int startPage;
	private int endPage;	
	
	private int total;
	
	public int getStartPage() {
		return startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public int getTotal() {
		return total;
	}
	
	public int getCurrent() {
		return current<1?1:current;
	}
	
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public void setCurrent(int current) {
		this.current = current;
	}
}