import java.sql.*;

public class Op145 {
	public int exec(Connection conn, String TRACKID) {
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT PODCASTID FROM PODCASTEPISODE WHERE TRACKID="+Integer.parseInt(TRACKID)+" ;");
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
