package SecurityDemo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employeedetails")
public class Employee {
	
	 @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
	    @Column(name="empid",nullable=false)
		private int empId;
	    @Column(nullable=false)
		private String empName;
	    @Column(nullable=false)
		private String location;
	    
	    public Employee() 
		{
		
		}
		public Employee(Long id, int empId, String empName, String location)
		{
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
