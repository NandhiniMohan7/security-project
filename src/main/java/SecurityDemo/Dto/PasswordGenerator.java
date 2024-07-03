package SecurityDemo.Dto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordGenerator {
	public static void main(String[] args) {
		PasswordEncoder encoder=new BCryptPasswordEncoder();
		System.out.println(encoder.encode("12345"));
		System.out.println(encoder.encode("123456"));
		
	}

}
