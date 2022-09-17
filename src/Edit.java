import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;


public class Edit extends JFrame{

    JButton btOne;
    JComboBox userType;
    private JPanel upperPanel;
    private JPanel lowerPanel;
    private JLabel lblOne, lblTwo, lblThree, lblFour;
    private JTextField tfOne,tfTwo,tfThree,tfFour;


    public Edit(int intOne){
        super("Update Employee Info");
        this.setLocation(450, 550);
        this.setSize(550, 250);
        // this.setVisible(true);
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.gray);
        // this.setLayout(new FlowLayout());
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        // this.lowerPanel.add(lblOne);

        tfOne = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5,5,5,5);
        lowerPanel.add(tfOne,gbc);
        // that code,
        // tfOne.requestFocusInWindow();

        lblTwo = new JLabel("Username");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0,0,0,0);
        lowerPanel.add(lblTwo, gbc);
        // this.lowerPanel.add(lblTwo);

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
        // this.lowerPanel.add(lblTwo);

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
        // cbUserType.setBounds(50, 50 , 90, 20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets = new Insets(5,5,5,5);
        // this.add(userType);
        lowerPanel.add(userType,gbc);



        btOne = new JButton("Update data");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(5,5,5,5);
        lowerPanel.add(btOne, gbc);

        btOne.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0){
                String stUserTypeData = (String) userType.getItemAt(userType.getSelectedIndex());
                String sql = "UPDATE `user` SET `id`='"+tfOne.getText()+"',`name`='"+tfTwo.getText()+"',`password`='"+tfThree.getText()+"',`type`='"+stUserTypeData+"' WHERE `id` = '"+intOne+"'";

                DataAccess d = new DataAccess();
                d.update(sql);

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
