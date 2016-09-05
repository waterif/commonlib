package src.database;

public class User {					
	
	public long id;
	public Integer age;
	public String username;
	public String password;
	
	public Order t_order;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Order getT_order() {
		return t_order;
	}

	public void setT_order(Order t_order) {
		this.t_order = t_order;
	}	
}