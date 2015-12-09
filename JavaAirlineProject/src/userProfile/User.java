package userProfile;

 abstract public class User {
	
	private String userName;
	private char [] password;
	private String name;
	private String address;
	private String phoneNumber;

	public User (String userName, char [] password) {
		
		setUserName(userName);
		setPassword(password);
		
	}
	
	
	
	public String getUserName() {
		return userName;
		
		
	}
	public void setUserName(String username) {
		this.userName = username;
	
	}
	public char [] getPassword() {
		return password;
	
	}
	public void setPassword(char [] password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	
	public String toString () {
		
		return "This is a general user class that includes records" ;
	}

}
