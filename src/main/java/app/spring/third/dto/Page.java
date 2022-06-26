package app.spring.third.dto;

public class Page {
	//페이징처리 정보 dto
	private String findkey; //검색키
	private String findvalue; //검색값
	
	private int curPage = 1; //현재페이지
	private int perPage = 10; //한페이지당 게시물 수
	private int perBlock = 10; //페이지블럭의 수
	
	private int totPage; //전체페이지 수
	private int startNum; //게시물의 시작번호
	private int endNum; //게시물의 끝번호
	private int startPage; //페이지블럭의 시작페이지
	private int endPage; //페이지블럭의 마지막페이지
	
	
	public Page() {
		super();
	}
	
	
	
	public Page(String findkey, String findvalue, int curPage, int perPage, int perBlock, int totPage, int startNum,
			int endNum, int startPage, int endPage) {
		super();
		this.findkey = findkey;
		this.findvalue = findvalue;
		this.curPage = curPage;
		this.perPage = perPage;
		this.perBlock = perBlock;
		this.totPage = totPage;
		this.startNum = startNum;
		this.endNum = endNum;
		this.startPage = startPage;
		this.endPage = endPage;
	}



	public String getFindkey() {
		return findkey;
	}
	public void setFindkey(String findkey) {
		this.findkey = findkey;
	}
	public String getFindvalue() {
		return findvalue;
	}
	public void setFindvalue(String findvalue) {
		this.findvalue = findvalue;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getPerBlock() {
		return perBlock;
	}
	public void setPerBlock(int perBlock) {
		this.perBlock = perBlock;
	}
	public int getTotPage() {
		return totPage;
	}
	public void setTotPage(int totPage) {
		this.totPage = totPage;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	@Override
	public String toString() {
		return "Page [findkey=" + findkey + ", findvalue=" + findvalue + ", curPage=" + curPage + ", perPage=" + perPage
				+ ", perBlock=" + perBlock + ", totPage=" + totPage + ", startNum=" + startNum + ", endNum=" + endNum
				+ ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
	
	
	
}
