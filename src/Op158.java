import java.sql.*;

public class Op158 {
	public int exec(Connection conn, String TRACKID , String PODCASTID) {
		try {
			Statement s = conn.createStatement();
			String SUBSCRIPTIONSTATUS = "Active";
			int rowsAffected = s.executeUpdate("UPDATE PODCASTEPISODE SET PODCASTID="+Integer.parseInt(PODCASTID)+ " WHERE TRACKID  = " + Integer.parseInt(TRACKID) + " ;");
			System.out.println(rowsAffected + " rows affected");
		}
		catch(Exception e) {
			System.out.println("An error occurred while executing the query.");
			System.out.println(e.getMessage());
			return 0;
		}
		return 1;
	}
}
