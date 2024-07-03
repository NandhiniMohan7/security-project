package SecurityDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SecurityDemo.Dto.LoginDto;
import SecurityDemo.Dto.RegisterDto;
import SecurityDemo.Service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthoController {
	@Autowired
	private AuthService authService;
	
	
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDto loginDto)
	{
		return ResponseEntity.ok(authService.login(loginDto));
	}
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterDto registerDto)
	{
		String response=authService.register(registerDto);
	return new ResponseEntity<>(response,HttpStatus.CREATED);	
	}

}
