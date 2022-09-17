import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;


public class Add extends JFrame{

	JButton btOne;
	JComboBox userType, specialtyType;
	private JPanel upperPanel;
	private JPanel lowerPanel;
	private JLabel lblOne, lblTwo, lblThree, lblFour;
	private JTextField tfOne,tfTwo,tfThree,tfFour;


	public Add(){
		super("Enter Employee Info");
		this.setLocation(450, 550);
		this.setSize(550, 250);
		
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.gray);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


		lowerPanel = new JPanel(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.insets = new Insets(5,5,5,5);
		this.add(lowerPanel, gbc);
		gbc.gridwidth = 1;

		lblOne = new JLabel("ID");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0,0,0,0);
		lowerPanel.add(lblOne, gbc);
		
		tfOne = new JTextField(10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(5,5,5,5);
		lowerPanel.add(tfOne,gbc);
		

		lblTwo = new JLabel("Username");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0,0,0,0);
		lowerPanel.add(lblTwo, gbc);
		

		tfTwo = new JTextField(10);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(5,5,5,5);
		lowerPanel.add(tfTwo,gbc);

		lblThree = new JLabel("Passowrd");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(0,0,0,0);
		lowerPanel.add(lblThree, gbc);
		

		tfThree = new JTextField(10);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.insets = new Insets(5,5,5,5);
		lowerPanel.add(tfThree,gbc);

		lblFour = new JLabel("Designation");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(0,0,0,0);
		lowerPanel.add(lblFour, gbc);

		

		String stUserType[]={"empty", "doctor", "receptionist"};
		userType = new JComboBox(stUserType);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.insets = new Insets(5,5,5,5);
		
		lowerPanel.add(userType,gbc);


		String specialtySt[]={"empty", "cardiologist", "neurologist"};
		specialtyType = new JComboBox(specialtySt);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.insets = new Insets(5,5,5,5);
		
		lowerPanel.add(specialtyType,gbc);



		btOne = new JButton("Insert data");
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.insets = new Insets(5,5,5,5);
		lowerPanel.add(btOne, gbc);

		btOne.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0){
				String stUserTypeData = (String) userType.getItemAt(userType.getSelectedIndex());
				String stSpecialtyData = (String) specialtyType.getItemAt(userType.getSelectedIndex());
				String sql = "INSERT INTO user VALUES ('"+tfOne.getText()+"','"+tfTwo.getText()+"','"+tfThree.getText()+"','"+stUserTypeData+"','"+stSpecialtyData+"')";
				
				d.insert(sql);

				

				if(stUserTypeData.equals("doctor")) {
					String sqlLocal = "CREATE TABLE `user`.`doctor#"+tfOne.getText()+"` ( `name` VARCHAR(25) NOT NULL , `age` VARCHAR(5) NOT NULL , " +
										"`contact no` VARCHAR(15) NOT NULL , `gender` VARCHAR(10) NOT NULL , PRIMARY KEY (`name`)) ENGINE = InnoDB;";

					d.newDocDb(sqlLocal);
				}

				if(LoginGui.typeLogIn.equals("admin")) {
					AdminHome.populateTable();
				}
				else if(LoginGui.typeLogIn.equals("receptionist")) {
					ReceptionistsHome.populateTable();

				}

				dispose();
				
			}


		});

		add(btOne);

	}

	private void AddUpperComponent() {

		/*
		t1 = new JTextField(10);
		add(t1);
		t2 = new JTextField(10);
		add(t2);
		t3 = new JTextField(10);
		add(t3);

		 */

		/*
		lblOne = new JLabel("ID");
		this.upperPanel.add(lblOne);

		tfOne = new JTextField(10);
		this.upperPanel.add(tfOne);
		 */


		/*
		t4 = new JTextField(10);
		add(t4);
		 */

		/*
		userType = new JComboBox();
		DefaultComboBoxModel userModel = new DefaultComboBoxModel();
		userModel.addElement("doctor");
		userModel.addElement("receptionist");
		// userModel.addElement("patient");
		userType.setModel(userModel);
		 */

		/*
		String userType[]={"doctor", "receptionist"};
		cbUserType = new JComboBox(userType);
		// cbUserType.setBounds(50, 50 , 90, 20);
		this.add(cbUserType);

		b = new JButton("insert");


		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0){
				String cbUserTypeData = (String) userType.getItemAt(userType.getSelectedIndex());
				String sql = "INSERT INTO user VALUES ("+t1.getText()+",'"+t2.getText()+"','"+t3.getText()+"','"+cbUserTypeData+"')";
				// cb.getItemAt(cb.getSelectedIndex())
				// String sql = "INSERT INTO user VALUES ("+t1.getText()+",'"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"')";
				DataAccess d = new DataAccess();
				d.insert(sql);
				// AdminHome.populateTable();
				// Home.populateTable();

				if(LoginGui.typeLogIn.equals("admin")) {
					AdminHome.populateTable();
				}
				else if(LoginGui.typeLogIn.equals("receptionist")) {
					Home.populateTable();
				}
			}
		});
		add(b);

		 */

	}

	public void AddLowerComponent() {

	}

}
