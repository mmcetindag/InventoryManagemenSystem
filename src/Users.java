import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Users {
	Conn conn=new Conn();
	public String name,password,userType;
	public int id;
	
	public Users() {
		
	}

	public Users(int id ,String name, String password, String userType) {
		
		this.name = name;
		this.password = password;
		this.userType = userType;
		this.id = id;
	}
	public  ArrayList<Users> getUsers(){
        
        ArrayList<Users> users = new ArrayList<Users>();
        
        Connection con = conn.getDBConnection();
        
        Statement st=null;
        
        ResultSet rs=null;
        
        Users u;
        
        try {
            
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM users");
            
            while(rs.next()){
                
                u = new Users(
                		 rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("usertype")
                       
                        
                   
                );
                	
                users.add(u);
            }
             
        } catch (SQLException ex) {
            
        }
        finally{
        
        	try {
				st.close();
				con.close();
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
        
        }
        return users;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
