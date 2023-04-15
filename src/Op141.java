import java.sql.*;

public class Op141 {
	public int exec(Connection conn, String ARTISTID) {
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT DISTINCT(ALBUMID) FROM SINGS NATURAL JOIN SONG WHERE ARTISTID="+Integer.parseInt(ARTISTID)+" ;");
			if (rs.next() == false) {
				System.out.println("0 rows returned");
			}
			rs.beforeFirst();
			while (rs.next()) {
				System.out.println(rs.getString(1));
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
