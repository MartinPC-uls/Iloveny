package mongodb;

public class Administrador {

	//private ObjectId _id;
	private String username;
	private String password;
	
	public Administrador(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	// getters
	public String get_username() {
		return username;
	}
	public String get_password() {
		return password;
	}
	
	// setters
	public void set_username(String username) {
		this.username = username;
	}
	public void set_password(String password) {
		this.password = password;
	}
	
}
