import java.sql.*;

public class Op156 {
	public int exec(Connection conn, String ARTISTID, String TRACKID,  String ARTISTTYPE ) {
		try {
			Statement s = conn.createStatement();
			String SUBSCRIPTIONSTATUS = "Active";
			int rowsAffected = s.executeUpdate(" INSERT INTO SINGS (TRACKID, ARTISTID, ARTISTTYPE) VALUES("+Integer.parseInt(TRACKID)+","+Integer.parseInt(ARTISTID)+",'"+ARTISTTYPE+"') ;");
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
