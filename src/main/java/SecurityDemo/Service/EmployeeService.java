package SecurityDemo.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import SecurityDemo.Dto.EmployeeDto;
import SecurityDemo.Dto.PostResponse;
import SecurityDemo.Entity.Employee;
import SecurityDemo.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	 public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
	        Employee employee = DtoToEntity(employeeDto);
	        employee = employeeRepository.save(employee);
	        return EntityToDto(employee);
	    }

	    public PostResponse getAllEmployees(int pageNo,int pageSize) {
	    	
	    	Pageable pageable = PageRequest.of(pageNo, pageSize);
	        Page<Employee> employees = employeeRepository.findAll(pageable);
	        List<Employee> employee=employees.getContent();
	        List<EmployeeDto> employeeDto=employee.stream().map(n->EntityToDto(n)).collect(Collectors.toList());
	        PostResponse postResponse=new PostResponse();
	        
	                     postResponse.setContent(employeeDto);
	                     postResponse.setPageNo(employees.getNumber());
	                     postResponse.setPageSize(employees.getSize());
	                     postResponse.setTotalElements(employees.getTotalElements());
	                     postResponse.setTotalPages(employees.getTotalPages());
	                     postResponse.setLast(employees.isLast());
	                     
	        
	        return postResponse;
	    }

	    public EmployeeDto getEmployee(Long id) {
	        Employee employee = employeeRepository.findById(id).orElse(null);
	        return EntityToDto(employee);
	    }

	    public EmployeeDto updateEmployee(Long id, EmployeeDto updateEmpDto) {
	        Employee employee = employeeRepository.findById(id).orElse(null);
	        if (employee != null) {
	            employee.setEmpName(updateEmpDto.getEmpName());
	            employee.setEmpId(updateEmpDto.getEmpId());
	            employee.setLocation(updateEmpDto.getLocation());
	            employee = employeeRepository.save(employee);
	            return EntityToDto(employee);
	        }
	        return null; // Handle the case where employee is not found
	    }

	    public String deleteEmployee(Long id) {
	        employeeRepository.deleteById(id);
	        return "Employee deleted successfully";
	    }

	    public Employee DtoToEntity(EmployeeDto employeeDto) {
	        return modelMapper.map(employeeDto, Employee.class);
	    }

	    public EmployeeDto EntityToDto(Employee employee) {
	        return modelMapper.map(employee, EmployeeDto.class);
	    }
	    
	   

}
