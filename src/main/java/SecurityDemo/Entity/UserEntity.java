package SecurityDemo.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="userdetails")
public class UserEntity {
	
	 @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
	    private String email;
	    private String userName;
	    private String password;
	    
	    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
		@JoinTable(name="user_role",
		           joinColumns=@JoinColumn(name="user_id" ,referencedColumnName="id"),
		           inverseJoinColumns=@JoinColumn(name="role_id", referencedColumnName="id"))
		private Set<RoleEntity> roles=new HashSet<RoleEntity>();

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Set<RoleEntity> getRoles() {
			return roles;
		}

		public void setRoles(Set<RoleEntity> roles) {
			this.roles = roles;
		}
	    
	    
	    

}
