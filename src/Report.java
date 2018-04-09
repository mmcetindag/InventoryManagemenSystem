import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Report {
	
	public String goodName,info;
	Conn conn=new Conn();
	
	public Report() {
		
	}
	
	public Report(String goodName,String info) {
		this.goodName=goodName;
		this.info=info;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	public  ArrayList<Report> getReport() throws SQLException{
        
        ArrayList<Report> report = new ArrayList<Report>();
        
        Connection con = conn.getDBConnection();
        
        Statement st = null;
        
        ResultSet rs=null;
        
        Report r;
        
        try {
            
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM reports");
            
            while(rs.next()){
                
                r = new Report(
                        rs.getString("goodname"),
                        rs.getString("info")
                   
                );
                	
                report.add(r);
            }
             
        } catch (SQLException ex) {
            
        }
        finally{
        	st.close();
        	rs.close();
        	con.close();
        	
        }

        return report;
    }

}
