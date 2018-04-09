import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SectionHeadGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField goodName;
	private JTable listGoods;
	private JTextField updateAmounts;
	private JTextField updateGood;
	private JTable listReport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SectionHeadGUI frame = new SectionHeadGUI();
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
	public SectionHeadGUI() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		SectionHead sectionHead = new SectionHead();
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 60, 714, 390);
		contentPane.add(tabbedPane);
		
		Good g =new Good();
		
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
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Depot", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 97, 709, 314);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			


			table.setEnabled(false);
			
			JLabel lblNewLabel = new JLabel("Good Name");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblNewLabel.setBounds(106, 33, 117, 33);
			panel.add(lblNewLabel);
			
			goodName = new JTextField();
			goodName.setBounds(240, 42, 134, 20);
			panel.add(goodName);
			goodName.setColumns(10);
			
			JButton btnNewButton = new JButton("Get Good");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				if(goodName.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
				}
					else{
					boolean control = sectionHead.getGood(goodName.getText());
					if(control)
					{
						JOptionPane.showMessageDialog(null, "Completing get good !");
						DefaultTableModel clearModel = (DefaultTableModel) table.getModel();
						clearModel.setRowCount(0);
						 try {
							for(int i = 0; i < g.getGood().size(); i++){
							        
							        rowData[0] = g.getGood().get(i).getType();
							         rowData[1] = g.getGood().get(i).getAmounts();
							        
							           
							           model.addRow(rowData);
							        
							    }
						} catch (SQLException e1) {
							
							e1.printStackTrace();
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Don't Completing get good try again!");
					}
				}
				}
			});
			btnNewButton.setBounds(400, 43, 89, 23);
			panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Update Good", null, panel_1, null);
		panel_1.setLayout(null);
		
		listGoods = new JTable();
		listGoods.setModel(model);
		
	
	
		
		updateAmounts = new JTextField();
		updateAmounts.setBounds(195, 43, 110, 35);
		panel_1.add(updateAmounts);
		updateAmounts.setColumns(10);
		
		updateGood = new JTextField();
		updateGood.setFont(new Font("Tahoma", Font.PLAIN, 15));
		updateGood.setBounds(44, 43, 132, 35);
		panel_1.add(updateGood);
		updateGood.setColumns(10);
		
		JLabel lblGoodName = new JLabel("Good Name");
		lblGoodName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGoodName.setBounds(44, 18, 91, 14);
		panel_1.add(lblGoodName);
		
		JLabel lblAmounts = new JLabel("Amounts");
		lblAmounts.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAmounts.setBounds(195, 18, 91, 14);
		panel_1.add(lblAmounts);
		JScrollPane scrollPane_1 = new JScrollPane(listGoods);
		listGoods.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = listGoods.getSelectedRow();
				TableModel model=listGoods.getModel();
				
				updateAmounts.setText(model.getValueAt(i, 1).toString());
				updateGood.setText(model.getValueAt(i, 0).toString());
				
			}
		});
		scrollPane_1.setBounds(0, 92, 709, 319);
		panel_1.add(scrollPane_1);
		scrollPane_1.setViewportView(listGoods);
		
		JButton btnNewButton_1 = new JButton("Update Good");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data =model.getValueAt(listGoods.getSelectedRow(), 0).toString();
				boolean  control = sectionHead.setGood(data, Integer.parseInt(updateAmounts.getText()),updateGood.getText());
				if(control)
				{
					JOptionPane.showMessageDialog(null, "Completing update good !");
					DefaultTableModel clearModel = (DefaultTableModel) table.getModel();
					clearModel.setRowCount(0);
					updateAmounts.setText("");
					updateGood.setText("");
					 try {
						for(int i = 0; i < g.getGood().size(); i++){
						        
						        rowData[0] = g.getGood().get(i).getType();
						         rowData[1] = g.getGood().get(i).getAmounts();
						        
						           
						           model.addRow(rowData);
						           
						        
						    }
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Don't Completing update good try again!");
				}
			}
		});
		btnNewButton_1.setBounds(335, 43, 125, 35);
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("List Reports", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 709, 362);
		panel_2.add(scrollPane_2);
		
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
	        

	        JScrollPane scrollReport = new JScrollPane();
			scrollReport.setBounds(0, 61, 695, 342);
			scrollReport.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		scrollPane_2.setViewportView(listReport);

		JLabel lblWelcomeSectionHead = new JLabel("Welcome Section Head Panel");
		lblWelcomeSectionHead.setBounds(10, 11, 192, 14);
		contentPane.add(lblWelcomeSectionHead);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				log.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(189, 7, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
