import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Good {
	public String type;
	public int amounts;
	Conn conn=new Conn();
	
	public Good() {
		
	}

	public Good(String type, int amounts) {
	
		this.type = type;
		this.amounts = amounts;
	}
	

	public  ArrayList<Good> getGood() throws SQLException{
        
        ArrayList<Good> good = new ArrayList<Good>();
        
        Connection con = conn.getDBConnection();
        
        Statement st = null;
        
        ResultSet rs=null;
        
        Good g;
        
        try {
            
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM goods");
            
            while(rs.next()){
                
                g = new Good(
                        rs.getString("type"),
                        rs.getInt("amount")
                   
                );
                	
                good.add(g);
            }
             
        } catch (SQLException ex) {
            
        }
        finally{
        	st.close();
        	rs.close();
        	con.close();
        	
        }

        return good;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAmounts() {
		return amounts;
	}

	public void setAmounts(int amounts) {
		this.amounts = amounts;
	}
	
}
