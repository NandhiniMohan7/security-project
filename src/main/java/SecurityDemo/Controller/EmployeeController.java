package SecurityDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import SecurityDemo.Dto.EmployeeDto;
import SecurityDemo.Dto.PostResponse;
import SecurityDemo.Service.EmployeeService;

@RestController
@RequestMapping(value="/api/employeeDetails")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	 @PostMapping
	    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
	        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
	        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	    }

	    @GetMapping("/allEmployee")
	    public ResponseEntity<PostResponse> getAllEmployees(
	    		@RequestParam(value="pageNo",defaultValue="0",required=false)int pageNo,
	    		@RequestParam(value="pageSize",defaultValue="5",required=false)int pageSize) {
	    	PostResponse employees = employeeService.getAllEmployees(pageNo,pageSize);
	        return new ResponseEntity<>(employees, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id) {
	        EmployeeDto employee = employeeService.getEmployee(id);
	        if (employee != null) {
	            return new ResponseEntity<>(employee, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
	        EmployeeDto updatedEmployee = employeeService.updateEmployee(id, employeeDto);
	        if (updatedEmployee != null) {
	            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
	        String result = employeeService.deleteEmployee(id);
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    }
	   @GetMapping("/home")
	   public String home() {
	        return "WELCOME";
	    }

}
