import java.sql.*;

public class Op159 {
	public int exec(Connection conn, String PODCASTID, String HOSTID) {
		try {
			Statement s = conn.createStatement();
			String SUBSCRIPTIONSTATUS = "Active";
			int rowsAffected = s.executeUpdate(" UPDATE HOSTS SET HOSTID="+Integer.parseInt(HOSTID)+" WHERE PODCASTID="+PODCASTID+" ;");
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
