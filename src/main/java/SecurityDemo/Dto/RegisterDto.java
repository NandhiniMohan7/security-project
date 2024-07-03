package SecurityDemo.Dto;

public class RegisterDto {
	
	private String email;
	private String userName;
	private String password;
	public RegisterDto() {
		super();
	}
	public RegisterDto(String email, String userName, String password) {
		super();
		this.email = email;
		this.userName = userName;
		this.password = password;
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

	
}