import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdminGUI extends JFrame {

	private JPanel contentPane;
	
	public String name,userType;
	private JTable table;
	private JTextField id;
	private JTextField userName;
	private JPasswordField password;
	private JTable listUsers;
	private JTextField deleteID;
	private JTable listReport;
	private JTextField searchField;
	Admin admin = new Admin("Mustafa" , "1234", "Admin" , 5);
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGUI frame = new AdminGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	
	public AdminGUI() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 55, 700, 387);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("List of Goods", null, panel, null);
		panel.setLayout(null);

		Good g =new Good();
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		 Object[] columsName = new Object[2];
	        
	        columsName[0] = "Good Name";
	        columsName[1] = "Amounts";
		        
	        model.setColumnIdentifiers(columsName);
	        Object[] rowData = new Object[2];
	        
	        for(int i = 0; i < g.getGood().size(); i++){
	            
	            rowData[0] = g.getGood().get(i).getType();
	             rowData[1] = g.getGood().get(i).getAmounts();
	            
	               
	               model.addRow(rowData);
	            
	        }
			table.setModel(model);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 699, 410);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane);
		


		table.setEnabled(false);
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Add User", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(248, 41, 69, 23);
		panel_1.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(248, 75, 101, 27);
		panel_1.add(id);
		id.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(364, 41, 69, 23);
		panel_1.add(lblName);
		
		userName = new JTextField();
		userName.setColumns(10);
		userName.setBounds(364, 75, 118, 29);
		panel_1.add(userName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(248, 132, 93, 23);
		panel_1.add(lblPassword);
		
		JLabel lblUserType = new JLabel("User Type");
		lblUserType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserType.setBounds(364, 132, 99, 23);
		panel_1.add(lblUserType);
		
		password = new JPasswordField();
		password.setBounds(248, 166, 109, 28);
		panel_1.add(password);
		String[] userType = { "Admin" , "Employee" , "Section Head" };
		JComboBox usertypes = new JComboBox(userType);
		usertypes.setBounds(364, 169, 122, 22);
		panel_1.add(usertypes);
		
		
		

		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Delete Users", null, panel_2, null);
		panel_2.setLayout(null);
		Users u=new Users();
		DefaultTableModel userSmodel = new DefaultTableModel();
		 Object[] columnName = new Object[4];
	        	columnName[0]="ID";
	        	columnName[1]="Name";
	        	columnName[2]="Password";
	        	columnName[3]="User Type";
	        	
		        
	        userSmodel.setColumnIdentifiers(columnName);
	        Object[] usersData = new Object[4];
	        
	        for(int i = 0; i < u.getUsers().size(); i++){
	            
	            usersData[0] = u.getUsers().get(i).getId();
	             usersData[1] = u.getUsers().get(i).getName();
	             	usersData[2]= u.getUsers().get(i).getPassword();
	             		usersData[3] = u.getUsers().get(i).getUserType();
	            
	               
	               userSmodel.addRow(usersData);
	            
	        }
	        
		listUsers = new JTable();
		listUsers.setBounds(10, 11, 562, 84);
		listUsers.setModel(userSmodel);
        

		 JScrollPane scrollPanel = new JScrollPane(listUsers);
		 scrollPanel.setBounds(0, 0, 695, 256);
		 scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		panel_2.add(scrollPanel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(190, 328, 46, 14);
		panel_2.add(lblId);
		
		deleteID = new JTextField();
		deleteID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deleteID.setBounds(233, 323, 104, 27);
		panel_2.add(deleteID);
		deleteID.setColumns(10);
		
		JButton deleteUser = new JButton("Delete User");
		deleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean controlDelete =admin.deleteUser(Integer.parseInt(deleteID.getText()));
				if(controlDelete){
					JOptionPane.showMessageDialog(null, "Completing delete User !");
					DefaultTableModel clearModel = (DefaultTableModel) listUsers.getModel();
					clearModel.setRowCount(0);
					 for(int i = 0; i < u.getUsers().size(); i++){
				            
				            usersData[0] = u.getUsers().get(i).getId();
				             usersData[1] = u.getUsers().get(i).getName();
				             	usersData[2]= u.getUsers().get(i).getPassword();
				             		usersData[3] = u.getUsers().get(i).getUserType();
				            
				               
				               userSmodel.addRow(usersData);
				            
				        }
						listUsers.setModel(userSmodel);
							deleteID.setText("");
					}
				else
					JOptionPane.showMessageDialog(null, "Error");
				
			}
		});
		deleteUser.setBounds(363, 323, 115, 27);
		panel_2.add(deleteUser);
		
		JButton addUser = new JButton("Add User");
		addUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id.getText().length()==0 && userName.getText().length()==0 && password.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				}else{
				try {
					boolean control = admin.addUser(Integer.parseInt(id.getText()), userName.getText(), password.getText(), String.valueOf(usertypes.getSelectedItem()));
					if(control)
					{

						JOptionPane.showMessageDialog(null, "Completing add Users !");
						String t=null;
						id.setText(t);
						userName.setText(t);
						password.setText(t);
						DefaultTableModel clearModel = (DefaultTableModel) listUsers.getModel();
						clearModel.setRowCount(0);
							for(int i = 0; i < u.getUsers().size(); i++){
				            
				            usersData[0] = u.getUsers().get(i).getId();
				             usersData[1] = u.getUsers().get(i).getName();
				             	usersData[2]= u.getUsers().get(i).getPassword();
				             		usersData[3] = u.getUsers().get(i).getUserType();
				            
				               
				               userSmodel.addRow(usersData);
				            
				        }
						listUsers.setModel(userSmodel);
						
					}
				} catch (NumberFormatException | SQLException e1) {
					
					e1.printStackTrace();
				}
			} }
		});
		addUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addUser.setBounds(283, 252, 181, 46);
		panel_1.add(addUser);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("List/Search Report", null, panel_3, null);
		panel_3.setLayout(null);
		listReport = new JTable();
		
		Report r = new Report();
		
			
		
		DefaultTableModel reportModel = new DefaultTableModel();
		 Object[] reportCol = new Object[2];
		 	reportCol[0]="Good Name";
		 	reportCol[1]="Info";
	
		 
		        
	        reportModel.setColumnIdentifiers(reportCol);
	        Object[] reportData = new Object[2];
	        
	        for(int i = 0; i < r.getReport().size(); i++){
	            
	        	reportData[0] = r.getReport().get(i).getGoodName();
	        	reportData[1] = r.getReport().get(i).getInfo();
	        	
	            
	               
	               reportModel.addRow(reportData);
	            
	        }

	        listReport.setModel(reportModel);
	        TableColumnModel columnModel=listReport.getColumnModel();
	        columnModel.getColumn(0).setPreferredWidth(20);
	        columnModel.getColumn(1).setPreferredWidth(300);
	        listReport.setRowHeight(100);
	        listReport.getColumnModel().getColumn(1).setCellRenderer(new WordWrapCellRenderer());
	        

	        JScrollPane scrollReport = new JScrollPane(listReport);
			scrollReport.setBounds(0, 61, 695, 342);
			scrollReport.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

			panel_3.add(scrollReport);
			
			searchField = new JTextField();
			searchField.setText("enter a keyword");
			searchField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					DefaultTableModel search=(DefaultTableModel) listReport.getModel();
					String searchKey = searchField.getText().toLowerCase();
					TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(search);
					listReport.setRowSorter(tr);
					tr.setRowFilter(RowFilter.regexFilter(searchKey));
				}
			});
			searchField.setBounds(171, 11, 117, 27);
			panel_3.add(searchField);
			searchField.setColumns(10);
			
			JLabel lblSearchReport = new JLabel("Search Report");
			lblSearchReport.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblSearchReport.setBounds(10, 11, 151, 27);
			panel_3.add(lblSearchReport);
			
			JLabel lblNewLabel_1 = new JLabel("Welcome Admin Panel");
			lblNewLabel_1.setBounds(10, 11, 131, 33);
			contentPane.add(lblNewLabel_1);
			
			JButton btnNewButton = new JButton("Logout");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Login log = new Login();
					log.setVisible(true);
					dispose();
				}
			});
			btnNewButton.setBounds(157, 16, 89, 23);
			contentPane.add(btnNewButton);
	
	}
}

class WordWrapCellRenderer extends JTextArea implements TableCellRenderer {
  
	private static final long serialVersionUID = 1L;

	WordWrapCellRenderer() {
        setLineWrap(true);
        setWrapStyleWord(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        setSize(table.getColumnModel().getColumn(column).getWidth(), getPreferredSize().height);
        if (table.getRowHeight(row) != getPreferredSize().height) {
            table.setRowHeight(row, getPreferredSize().height);
        }
        return this;
    }
}
