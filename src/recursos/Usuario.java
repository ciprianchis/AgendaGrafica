package recursos;

public class Usuario {

	private String user;
	private String passwd;
	public Usuario(String user, String passwd) {
		this.user = user;
		this.passwd = passwd;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return  user + "-" + passwd;
	}
	
	
}
