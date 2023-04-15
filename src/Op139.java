import java.sql.*;

public class Op139 {
	public int exec(Connection conn, String ALBUMID) {
		try {
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery("SELECT TRACKID, TRACKNUMBER FROM SONG WHERE ALBUMID="+Integer.parseInt(ALBUMID)+" ;");
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
