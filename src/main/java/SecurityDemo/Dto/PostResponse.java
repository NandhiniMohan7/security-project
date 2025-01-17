package SecurityDemo.Dto;

import java.util.List;

import SecurityDemo.Dto.EmployeeDto;

public class PostResponse {
	private List<EmployeeDto> content;
	private int pageNo;
	private int pageSize;
	private Long totalElements;
	private int totalPages;
	private boolean last;
	public PostResponse() {
		super();
	}
	public PostResponse(List<EmployeeDto> content, int pageNo, int pageSize, Long totalElements, int totalPages,
			boolean last) {
		super();
		this.content = content;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.last = last;
	}
	public List<EmployeeDto> getContent() {
		return content;
	}
	public void setContent(List<EmployeeDto> content) {
		this.content = content;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
	
	

}
