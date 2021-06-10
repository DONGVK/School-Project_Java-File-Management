package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Connection
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
  
 // OTHER
  public static void disconnect() {
		try {
	        if (con != null) {
	            con.close();
	        }
	      } catch (SQLException ex) {
	          System.out.println(ex.getMessage());
	      }
	}
  
}