import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Employee extends Users {
	
	PreparedStatement preparedStatement = null;
	Conn conn=new Conn();
	public Employee() {
	
	}

	public Employee(String name, String password, String userType, int id) {
		super(id, password, userType, name);
		
	}
	
	
	public boolean addGood(String type,int amount) throws SQLException
	{
		PreparedStatement preparedStatement = null;
		Connection dbConnection = null;
		String SQL = "INSERT INTO goods" + "(type,amount) VALUES" + "(?,?)";
		int key=0;
		try{
			
			dbConnection = conn.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(SQL);
			preparedStatement.setString(1, type);
			preparedStatement.setInt(2, amount);
			preparedStatement.executeUpdate();
			key=1;
			

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			key=2;
		

		} finally {
			dbConnection.close();
			preparedStatement.close();
			

		}
		if(key==1)
			return true;
		else
			return false;
	}
	
	public boolean addReport(String goodName,String info) throws SQLException
	{
	
		String SQL = "INSERT INTO reports" + "(goodname,info) VALUES" + "(?,?)";
		try{
			PreparedStatement preparedStatement = null;
			Connection dbConnection = null;
			dbConnection = conn.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(SQL);
			preparedStatement.setString(1, goodName);
			preparedStatement.setString(2, info);
			preparedStatement.executeUpdate();
			return true;

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			return false;

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

		}
	}
	
	

	
}
