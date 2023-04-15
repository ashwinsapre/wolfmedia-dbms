import java.sql.*;

public class Op24 {
	public int exec(Connection conn,  String USERID, String PODCASTID, String RATING){
		ResultSet rs = null;
		try {
			Statement s = conn.createStatement();

			int rowsAffected = s.executeUpdate("INSERT INTO RATES(userID,podcastID,rating) VALUES("+Integer.parseInt(USERID)+","+Integer.parseInt(PODCASTID)+","+Integer.parseInt(RATING)+") ;");
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

