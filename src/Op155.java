import java.sql.*;

public class Op155 {
	public int exec(Connection conn, String TRACKID, String ALBUMID ) {
		try {
			Statement s = conn.createStatement();
			String SUBSCRIPTIONSTATUS = "Active";
			int rowsAffected = s.executeUpdate("UPDATE SONG SET ALBUMID="+Integer.parseInt(ALBUMID)+ " WHERE TRACKID  = " + Integer.parseInt(TRACKID) + " ;");
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
