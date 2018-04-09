import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	Conn conn = new Conn();
	private JPanel contentPane;
	private JTextField userName;
	private JTextField password;
	private JButton login;
	private JLabel test;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userName = new JTextField();
		userName.setBounds(106, 216, 175, 45);
		contentPane.add(userName);
		userName.setColumns(10);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(106, 315, 175, 45);
		contentPane.add(password);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUserName.setBounds(106, 176, 175, 26);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPassword.setBounds(106, 278, 175, 26);
		contentPane.add(lblPassword);
		
		login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(userName.getText().length()==0 && password.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				}
				else
				{
					try {
						Connection con = conn.getDBConnection();
						Statement  stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery( "SELECT * FROM users;" );
						int key=0;
						
						
					
				         while ( rs.next() ) {
				        		
				        	 if(userName.getText().equals(rs.getString("name")) && password.getText().equals(rs.getString("password")) )
				             {
				            	
				            	 key=1;
				            	 if(rs.getString("usertype").equals("Employee")){
					            	 EmployeeGUI emp = new EmployeeGUI();
					            	 emp.setVisible(true);
					            	 dispose();
					            	}
				            	 else if(rs.getString("usertype").equals("Admin"))
				            	 {
				            		 AdminGUI emp = new AdminGUI();
					            	 emp.setVisible(true);
					            	 dispose();
				            	 }
				            	 else
				            	 { SectionHeadGUI emp = new SectionHeadGUI();
				            	 emp.setVisible(true);
				            	 dispose();}
				            	 	
				            	 
				             } 
				        	
				         }
				         if(key!=1)
				        	 JOptionPane.showMessageDialog(null, "Error! No such user found! Try Again");
						}
						catch (SQLException e1) {
							 
						}
				}
				
			}
		});
		login.setFont(new Font("Tahoma", Font.PLAIN, 26));
		login.setBounds(372, 216, 214, 144);
		contentPane.add(login);
		
		test = new JLabel("INVENTORY MANAGEMENT SYSTEM");
		test.setFont(new Font("Tahoma", Font.PLAIN, 23));
		test.setBounds(163, 95, 378, 39);
		contentPane.add(test);
	}
}
