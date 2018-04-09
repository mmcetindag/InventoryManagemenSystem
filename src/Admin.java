import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Admin extends Users {
	Good good =new Good();
	Conn conn=new Conn();
	PreparedStatement preparedStatement = null;
	public Admin() {
		
	}
	

	public Admin(String name, String password, String userType, int id) {
		super(id, password, userType, name);
		
	}
	
	
	public boolean addUser(int id,String name , String password, String userType) throws SQLException
	{
		PreparedStatement preparedStatement = null;
		Connection dbConnection = null;
		String SQL = "INSERT INTO users" + "(id,name,password,usertype) VALUES" + "(?,?,?,?)";
		try{
			
			dbConnection = conn.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(SQL);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, password);
			preparedStatement.setString(4, userType);
			preparedStatement.executeUpdate();
		
			return true;

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			return false;

		} finally {
			dbConnection.close();
			preparedStatement.close();
		}
	}
	
	public boolean deleteUser(int id)  {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM USERS WHERE id = ?";

		try {
			dbConnection = conn.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);

			
			preparedStatement.executeUpdate();

			return true;

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			return false;

		} finally {

			try {
				dbConnection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}

	}
	
}
