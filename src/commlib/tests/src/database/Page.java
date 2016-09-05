package src.database;

public class Page {
	private int startPage=1;
	private int endPage=1;
	private int pageSize=3;
	private int total=1;
	private int previous=1;
	private int current = 1;
	private int next=1;
	
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
	public int getPrevious() {
		return previous;
	}
	public int getCurrent() {
		return current<1?1:current;
	}
	public int getNext() {
		return next;
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
	public void setPrevious(int previous) {
		this.previous = previous;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public void setNext(int next) {
		this.next = next;
	}
}
