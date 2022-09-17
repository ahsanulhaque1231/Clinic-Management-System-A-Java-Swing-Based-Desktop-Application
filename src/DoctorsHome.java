import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.*;



public class DoctorsHome extends JFrame {

    private JPanel upperPanel, lowerPanel, rightPanel, bottomPanel;

    private JLabel lblSearch;
    private static JTextField txtSearch;
    private JButton btnSearch, btnAdd, btnEdit, btnDelete, btnBack, btOne, backToHome, addNewPatient;
    private JLabel lblOne, lblTwo, lblThree, lblFour;
    private JTextField tfOne, tfTwo, tfThree;
    private JComboBox userType;
    private String docId;

    private static JTable tblUsers;

    public DoctorsHome(String vbOne) {
        super("Doctor's Home");
        this.docId = vbOne;
        this.setLocation(150, 150);
        this.setSize(550, 600);
        //this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        lowerPanel = new JPanel(null);
        this.lowerPanel.setBorder(new TitledBorder(new LineBorder(Color.GREEN, 1), "Patient List"));
        this.lowerPanel.setBounds(5, 50, 460, 360);
        add(this.lowerPanel);

        this.AddLowerComponent();

    }


    private void AddLowerComponent() {

        tblUsers = new JTable();
        tblUsers.setBackground(Color.white);

        JScrollPane sp = new JScrollPane();
        sp.setBounds(5, 25, 450, 320);
        this.lowerPanel.add(sp);
        sp.setViewportView(tblUsers);

        this.populateTable();
    }

    // the method was static, populateTable()

    public void populateTable() {

        PatientsTableModel model = new PatientsTableModel(docId);
        tblUsers.setModel(model);
    }

}








