package userProfile;

public class Customer extends User {
	
	
	
	
	
public Customer (String userName, char [] password, String name) {
	super(userName, password);
	setName(name);
}
	



public boolean equals (Object customer) {
	
	boolean result = false;
	
	if (!(customer instanceof Customer)) {
		return false;
	}
	
	if (this.getUserName() == ((Customer)customer).getUserName() && this.getPassword() == ((Customer)customer).getPassword()) {
		
		result = true;
	}
	
	return result;
}


public String toString() {
		
		return super.toString() + " for Customer ";
	}
}
