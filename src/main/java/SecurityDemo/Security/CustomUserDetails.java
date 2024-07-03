package SecurityDemo.Security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import SecurityDemo.Entity.UserEntity;
import SecurityDemo.Exception.UsernameNotFoundException;
import SecurityDemo.Repository.UserEntityRepository;

@Service
public class CustomUserDetails implements UserDetailsService {
	@Autowired
	private UserEntityRepository userEntityRepository;
	public  UserDetails loadUserByUsername(String username)
	{
		UserEntity user=userEntityRepository.findByUserName(username).
				        orElseThrow(()->new UsernameNotFoundException(username));
		
		Set<GrantedAuthority> authority=user.getRoles()
				                         .stream()
				                         .map((role)->new SimpleGrantedAuthority(role.getRoleName()))
				                         .collect(Collectors.toSet());
		return new User(user.getUserName(),user.getPassword(),authority);
	}

}
