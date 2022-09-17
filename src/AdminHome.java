import javax.swing.JFrame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;



public class AdminHome extends JFrame{
	
	private JPanel upperPanel;
	private JPanel lowerPanel;
	
	private JLabel lblSearch;
	private static JTextField txtSearch;
	private JButton btnSearch, btnAdd, btnEdit, btnDelete, btnBack,btnShowAll, btnLogOut;
	
	private static JTable tblUsers;
	
	public AdminHome(){
		super("Home");
		this.setLocation(250, 350);
		this.setSize(600, 600);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		upperPanel = new JPanel(new FlowLayout());
		this.upperPanel.setBorder(new LineBorder(Color.black, 1));
		this.upperPanel.setBounds(5, 5, 570, 40);
		add(this.upperPanel);
				

		lowerPanel = new JPanel(null);
		this.lowerPanel.setBorder(new TitledBorder(new LineBorder(Color.GREEN, 1),"Data"));
		this.lowerPanel.setBounds(5, 50, 570, 340);
		add(this.lowerPanel);
		
		this.AddUpperComponent();
		this.AddLowerComponent();
	}
	
	private void AddUpperComponent() {
		
		lblSearch = new JLabel("Search");
		this.upperPanel.add(lblSearch);
		
		txtSearch = new JTextField(10);
		this.upperPanel.add(txtSearch);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				populateTable();
			}
		});
		this.upperPanel.add(btnSearch);

		btnShowAll = new JButton("Show all");
		btnShowAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showAllData();
			}
		});
		this.upperPanel.add(btnShowAll);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				Add a = new Add();
				a.setVisible(true);
				
			}
		});
		this.upperPanel.add(btnAdd);

		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int row = tblUsers.getSelectedRow();
				int id = (int) tblUsers.getValueAt(row, 0);		

				Edit editOne = new Edit(id);
				editOne.setVisible(true);
			}
		});
		this.upperPanel.add(btnEdit);

		

		btnDelete = new JButton("Delete");
		this.upperPanel.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = tblUsers.getSelectedRow();	
				int id = (int) tblUsers.getValueAt(row, 0);
				String isDoc = (String) tblUsers.getValueAt(row, 2);	

				String deleteSql = "DELETE FROM `user` WHERE `user`.`id` = "+id+"";

				DataAccess d = new DataAccess();
				d.deleteRow(deleteSql);

				
				if(isDoc.equals("doctor")) {
					String deleteTable = "DROP TABLE `doctor#"+id+"`;";
					d.deleteRow(deleteTable);
				}


				populateTable();
			}
		});
	}
	
	
	private void AddLowerComponent() {
		
		tblUsers = new JTable();
		tblUsers.setBackground(Color.white);
		
		JScrollPane sp = new JScrollPane();
		sp.setBounds(5, 15, 490, 320);
		this.lowerPanel.add(sp);
		sp.setViewportView(tblUsers);

		tblUsers.addMouseListener((new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row = tblUsers.rowAtPoint(e.getPoint());	

				tblUsers.getSelectionModel().setSelectionInterval(row, row);
			}
		}));
		
		this.populateTable();
	}

	public static void populateTable() {
		
		UsersTableModel model = new UsersTableModel(txtSearch.getText());
		tblUsers.setModel(model);
	}

	public static void showAllData() {
		String empty = "";
		UsersTableModel model = new UsersTableModel(empty);
		tblUsers.setModel(model);
	}
	
}









