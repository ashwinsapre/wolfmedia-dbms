import java.sql.*;

public class Op157 {
	public int exec(Connection conn, String ARTISTID , String LABELID  ) {
		try {
			Statement s = conn.createStatement();
			String SUBSCRIPTIONSTATUS = "Active";
			int rowsAffected = s.executeUpdate("UPDATE ARTIST SET LABELID="+Integer.parseInt(LABELID)+ " WHERE ARTISTID  = " + Integer.parseInt(ARTISTID) + " ;");
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
