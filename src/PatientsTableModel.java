import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class PatientsTableModel extends AbstractTableModel {

    private String[] colNames = {"NAME","AGE","CONTACT NO", "GENDER"};
    private ArrayList<Patient> patients = new ArrayList<Patient>();

    public PatientsTableModel(String key) {
        String query = "select * from `doctor#"+key+"`";
       

        DataAccess da = new DataAccess();
        patients = da.GetPatients(query);

    }

    // ^ modify for type not null && make search work

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return colNames.length;
    }

    public String getColumnName(int col) {
        // TODO Auto-generated method stub
        return colNames[col];
    }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return patients.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        // TODO Auto-generated method stub
        if(patients.size()==0)
            return null;


        try
        {
            Patient p = patients.get(row);
            switch(col)
            {
                case 0:
                    return p.name;
                case 1:
                    return p.age;
                case 2:
                    return p.contactNo;
                case 3:
                    return p.gender;
                default:
                    return null;
            }

        }
        catch(Exception ex)
        {
            return null;
        }
    }



}

