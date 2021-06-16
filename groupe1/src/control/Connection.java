package control;
import java.util.ArrayList;

import db.*;

public class Connection{
	private String login;
	private String password;
	private Boolean connect = false;

	public Connection(String l, String p) {
		this.login = l;
		this.password = MD5.getMd5(p);
		this.connect = this.testConnection();
	}
	
	/* 
	 * Getters & Setters
	 */
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getConnect() {
		return connect;
	}

	public void setConnect(Boolean connect) {
		this.connect = connect;
	}
	
	/*
	 * 
	 * Methods
	 * 
	 */
	
	//Compare if the password provided by the user is the same from the db
    public boolean testConnection(){
		String passDB = "";
		
		try {
			passDB = DBConnection.selectPassword(this.login);
		} catch (ClassNotFoundException e) {
			return false;
		}
		return MD5.matching(this.password, passDB);
	}
	
    //Create the user depends on the role
    public User createSession() {
    	User user = new User();
    	ArrayList<String> ar = new ArrayList<String>();
    	try {
			 ar = DBConnection.selectUser(this.login);
			 if(Integer.parseInt(ar.get(3)) == 1) {
				 user = new Admin(ar.get(4), ar.get(5));
			 }else {
				 user = new User(ar.get(4), ar.get(5));
			 }
		} catch (ClassNotFoundException e) {
			return user;
		}
    	return user;
    }
	
}