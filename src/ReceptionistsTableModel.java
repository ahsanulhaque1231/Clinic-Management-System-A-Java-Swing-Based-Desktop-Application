import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ReceptionistsTableModel extends AbstractTableModel {

    private String[] colNames = {"ID","NAME","SPECIALTY"};
    private ArrayList<Doctor> doctors = new ArrayList<Doctor>();

    public ReceptionistsTableModel(String key) {
        String query = "select * from user";
        
            query = query + " WHERE specialty NOT LIKE 'null' && name like '%"+key+"%' OR specialty NOT LIKE 'null' && specialty LIKE '%"+key+"%'";


        DataAccess da = new DataAccess();
        doctors = da.GetDoctors(query);
    }


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
        return doctors.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        // TODO Auto-generated method stub
        if(doctors.size()==0)
            return null;


        try
        {
            Doctor u = doctors.get(row);
            switch(col)
            {
                case 0:
                    return u.id;
                case 1:
                    return u.name;
                case 2:
                    return u.specialty;
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

