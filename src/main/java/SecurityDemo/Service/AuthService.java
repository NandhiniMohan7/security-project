package SecurityDemo.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import SecurityDemo.Dto.LoginDto;
import SecurityDemo.Dto.RegisterDto;
import SecurityDemo.Entity.RoleEntity;
import SecurityDemo.Entity.UserEntity;
import SecurityDemo.Repository.RoleEntityRepository;
import SecurityDemo.Repository.UserEntityRepository;

@Service
public class AuthService {
	private UserEntityRepository userEntityRepository;
	private RoleEntityRepository roleEntityRepository;
	private AuthenticationManager authenticationManager;
	private PasswordEncoder passwordEncoder;
	public AuthService(UserEntityRepository userEntityRepository, RoleEntityRepository roleEntityRepository,
			AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
		super();
		this.userEntityRepository = userEntityRepository;
		this.roleEntityRepository = roleEntityRepository;
		this.authenticationManager = authenticationManager;
		this.passwordEncoder = passwordEncoder;
	}
	
	public String login(LoginDto loginDto)
	{
		Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUserName(),loginDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return "login successfull";
	}
	
	public String register(RegisterDto registerDto)
	{
		if(userEntityRepository.existsByUserName(registerDto.getUserName()))
		{
			throw new RuntimeException();
		}
		
		UserEntity user=new UserEntity();
		           user.setUserName(registerDto.getUserName());
		           user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
		           user.setEmail(registerDto.getEmail());
		           
		           
		          Set<RoleEntity> roles=new HashSet<RoleEntity>();
		          
		          RoleEntity role=roleEntityRepository.findByRoleName("USER").get();	
		                     roles.add(role);
		                     user.setRoles(roles);
		                     
		                     userEntityRepository.save(user);
		                     return "User Register successfull";
		                     
	}

}
