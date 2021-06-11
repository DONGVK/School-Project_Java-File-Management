package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import control.MD5;

/***************
 *             
 * DATABSE      
 * 
***************/
public class DBConnection {
	public static Connection con = null;
	
  public static void main(String[] args) throws ClassNotFoundException {

    String url = "jdbc:mysql://localhost:3306/projetit";
    String username = "root";
    String password = "123";

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(url, username, password);

    } catch (SQLException ex) {
        throw new Error("Error ", ex);
    }
  }
  
 // After finishing using the connection DB
  public static void disconnect() {
		try {
	        if (con != null) {
	            con.close();
	        }
	      } catch (SQLException ex) {
	          System.out.println(ex.getMessage());
	      }
	}
  
/***************
 *             
 * Query
 * 
***************/
  
  //Have the password
  public static String selectPassword(String login) throws ClassNotFoundException{
	  main(null);
	  Statement stmt;
	  String res = null;
	  try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT password FROM Utilisateur WHERE login = \'" + login+"';");
			while (rs.next()) {
				  String r = rs.getString("password");
				  res = r;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  	disconnect();
		return res;
  }
  
  //Have user's informations with login
  public static ArrayList<String> selectUser(String login) throws ClassNotFoundException {
	  main(null);
	  Statement stmt;
	  ArrayList<String> res = new ArrayList<String>();
	try {
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Utilisateur WHERE login = '" + login + "';");
		while (rs.next()) {
			  String r = rs.getString("id_user");
			  res.add(r);
			  r = rs.getString("nom");
			  res.add(r);
			  r = rs.getString("prenom");
			  res.add(r);
			  r = rs.getString("id_role");
			  res.add(r);
			  r = rs.getString("login");
			  res.add(r);
			  r = rs.getString("password");
			  res.add(r);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	disconnect();
	return res;
  }
  
  public static ArrayList<String> selectUser(int id_user) throws ClassNotFoundException {
	  main(null);
	  Statement stmt;
	  ArrayList<String> res = new ArrayList<String>();
	try {
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Utilisateur WHERE id_user = " + id_user + ";");
		while (rs.next()) {
			  String r = rs.getString("id_user");
			  res.add(r);
			  r = rs.getString("nom");
			  res.add(r);
			  r = rs.getString("prenom");
			  res.add(r);
			  r = rs.getString("id_role");
			  res.add(r);
			  r = rs.getString("login");
			  res.add(r);
			  r = rs.getString("password");
			  res.add(r);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	disconnect();
	return res;
  }
  
  //Insert a new User
  public static void insertUser(String nom, String prenom, String login, String password, int id_role) throws ClassNotFoundException{
	  main(null);
	  try {
		  String query = "INSERT INTO Utilisateur (nom, prenom, login, password, id_role) VALUES(?, ?, ?, ?, ?);";
	      PreparedStatement preparedStmt = con.prepareStatement(query);
	      preparedStmt.setString(1, nom);
	      preparedStmt.setString(2, prenom);
	      preparedStmt.setString(3, login);
	      preparedStmt.setString(4, MD5.getMd5(password));
	      preparedStmt.setInt(5, id_role);
	      // execute the java preparedstatement
	      preparedStmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
  }
  
//Delete user
  public static void deleteUser(int id_role) throws ClassNotFoundException{
	  main(null);
	  try {
		  String query = "DELETE FROM Utilisateur WHERE id_user = ?";
	      PreparedStatement preparedStmt = con.prepareStatement(query);
	      preparedStmt.setInt(1, id_role);
	      preparedStmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
  }
  
}