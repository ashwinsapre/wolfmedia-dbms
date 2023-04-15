import java.sql.*;

public class Op134 {
	public int exec(Connection conn, String ARTISTID) {
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery( "SELECT TRACKID, ARTISTTYPE FROM SINGS WHERE ARTISTID= "+Integer.parseInt(ARTISTID)+" ;");
			if (rs.next() == false) {
				System.out.println("0 rows returned");
			}
			rs.beforeFirst();
			while (rs.next()) {
				System.out.println(rs.getString(1)+"--"+rs.getString(2));
			}
		}
		catch(Exception e) {
			System.out.println("An error occurred while executing the query.");
			System.out.println(e.getMessage());
			return 0;
		}

		return 1;
	}
}
