import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SectionHead extends Users {

	public SectionHead(String name, String password, String userType, int id) {
		super(id, password, userType, name);
		
	}

	public SectionHead() {
		
	}
	
	public boolean getGood(String goodName)  {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM GOODS WHERE type = ?";

		try {
			dbConnection = conn.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, goodName);

			
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
	
	public boolean setGood(String goodName , int amounts , String newName)  {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "update goods set type = ? , amount = ? where type = ?";

		try {
			dbConnection = conn.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(updateSQL);
			preparedStatement.setString(1, newName);
			preparedStatement.setInt(2, amounts);
			preparedStatement.setString(3, goodName);

			
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
