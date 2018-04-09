import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class EmployeeGUI extends JFrame {

	private JPanel contentPane;
	private JTextField type;
	private JTextField amount;
	Employee emp = new Employee( "Mustafa" , "1234" , "Employee" , 1);
	private JTextField goodName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeGUI frame = new EmployeeGUI();
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
	public EmployeeGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 53, 714, 397);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Add Good", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Good Type");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(126, 80, 98, 25);
		panel.add(lblNewLabel);
		
		type = new JTextField();
		type.setBounds(125, 118, 182, 30);
		panel.add(type);
		type.setColumns(10);
		
		amount = new JTextField();
		amount.setColumns(10);
		amount.setBounds(125, 210, 182, 30);
		panel.add(amount);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAmount.setBounds(126, 172, 98, 25);
		panel.add(lblAmount);
		
		JButton btnAddGood = new JButton("Add Good");
		btnAddGood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(type.getText().length()==0 || amount.getText().length()==0)
					JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				else{
					try {
					    int x = Integer.parseInt(amount.getText());
					    try {
							boolean control = emp.addGood(type.getText() , Integer.parseInt(amount.getText()));
							if(control)
							{	
								JOptionPane.showMessageDialog(null, "Completing add Good !");
								String t=null;
								type.setText(t);
								amount.setText(t);
								
							}
							else
								JOptionPane.showMessageDialog(null, "You don't add Good !");
						} catch (NumberFormatException | SQLException e1) {
							
							e1.printStackTrace();
						}
					  
					}
					catch(NumberFormatException nFE) {
						JOptionPane.showMessageDialog(null, "Amount must be integers ! ");
					}
					
					
				}
				
				
			}
		});
		btnAddGood.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnAddGood.setBounds(378, 137, 181, 86);
		panel.add(btnAddGood);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Add Report", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Good Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(34, 53, 148, 30);
		panel_1.add(lblNewLabel_1);
		
		goodName = new JTextField();
		goodName.setBounds(34, 94, 148, 30);
		panel_1.add(goodName);
		goodName.setColumns(10);
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblInfo.setBounds(265, 53, 148, 30);
		panel_1.add(lblInfo);
		
		JTextArea info = new JTextArea();
		info.setBounds(265, 94, 270, 185);
		panel_1.add(info);
		
		JButton btnNewButton = new JButton("Add Report");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(goodName.getText().length()==0 || info.getText().length()==0)
					JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				else {
				try {
					boolean control = emp.addReport(goodName.getText(),info.getText());
					if(control)
					{	
						JOptionPane.showMessageDialog(null, "Completing add Report !");
						String t=null;
						goodName.setText(t);
						info.setText(t);
						
					}
					else
						JOptionPane.showMessageDialog(null, "You don't add Report !");
				} catch (NumberFormatException | SQLException e1) {
					
					e1.printStackTrace();
				}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(34, 216, 148, 63);
		panel_1.add(btnNewButton);
		
		JLabel lblWelcomeEmployeePanel = new JLabel("Welcome Employee Panel");
		lblWelcomeEmployeePanel.setBounds(10, 11, 161, 14);
		contentPane.add(lblWelcomeEmployeePanel);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				log.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(181, 7, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
