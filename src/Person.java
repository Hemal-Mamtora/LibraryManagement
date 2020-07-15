
public class Person {
	String name;
	String username;
	String pwd;
	boolean isLibrarian;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean isLibrarian() {
		return isLibrarian;
	}

	public void setLibrarian(boolean isLibrarian) {
		this.isLibrarian = isLibrarian;
	}

	Person(String name, String username, String pwd, boolean isLibrarian){
		this.name = name;
		this.username = username;
		this.pwd = pwd;
		this.isLibrarian = isLibrarian;
	}
}
