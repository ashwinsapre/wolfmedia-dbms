import java.sql.*;

public class Op151 {
	public int exec(Connection conn, String PODCASTID) {
		try {
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery("SELECT COUNT(TRACKID) FROM PODCASTEPISODE WHERE PODCASTID="+Integer.parseInt(PODCASTID)+" ; ");
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
