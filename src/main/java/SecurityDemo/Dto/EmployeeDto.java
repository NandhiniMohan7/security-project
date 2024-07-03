package SecurityDemo.Dto;

public class EmployeeDto {
	private Long id;
	private int empId;
	private String empName;
	private String location;
	public EmployeeDto() {
		super();
	}
	public EmployeeDto(Long id, int empId, String empName, String location) {
		super();
		this.id = id;
		this.empId = empId;
		this.empName = empName;
		this.location = location;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
