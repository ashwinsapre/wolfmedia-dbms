import java.sql.*;

public class Op149 {
	public int exec(Connection conn, String PODCASTID) {
		try {
			Statement s = conn.createStatement();
			String TYPE = "Podcast";
			ResultSet rs = s.executeQuery( "SELECT COUNT(*) FROM ACTIVELYLISTENSTO WHERE TARGETID="+Integer.parseInt(PODCASTID)+" AND TYPE = '" + TYPE + "' ;");
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
