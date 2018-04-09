import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
	  Connection c = null;
  
	  Statement stmt = null;
		private static final String DB_DRIVER = "org.postgresql.Driver";
		private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/inventory";
		private static final String DB_USER = "postgres";
		private static final String DB_PASSWORD = "123456";
      public Conn() 
      {	
      }
      
      public Connection getC() {
  		return c;
  	}
  	public void setC(Connection c) {
  		this.c = c;
  	}
  	public Statement getStmt() {
  		return stmt;
  	}
  	public void setStmt(Statement stmt) {
  		this.stmt = stmt;
  	}
  	public Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(
                            DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		
			 

	
		return dbConnection;

	}
  	

}
