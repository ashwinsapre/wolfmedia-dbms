import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Op42 {
	public int exec(Connection conn, String ALBUMID){
		ResultSet rs = null;
		try {
			Statement s = conn.createStatement();
			rs = s.executeQuery("SELECT MONTH, YEAR, SUM(PLAYLISTENCOUNT) FROM CYCLE NATURAL JOIN PLAYRECORD NATURAL JOIN SONG WHERE ALBUMID="+ALBUMID+" GROUP BY MONTH, YEAR;");
			if (rs.next() == false) {
				System.out.println("0 rows returned");
				// block of code to be executed if the condition is true
			}
			rs.beforeFirst();
			while (rs.next()) {
				System.out.println(rs.getString(1)+"--"+rs.getString(2)+"--"+rs.getString(3));
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
