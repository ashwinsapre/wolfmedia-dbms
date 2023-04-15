import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Op49 {
	public int exec(Connection conn, String HOSTID){
		ResultSet rs = null;
		try {
			Statement s = conn.createStatement();
			rs = s.executeQuery("SELECT TRACKID, TITLE, DURATION, RELEASEDATE, PODCASTID, NAME FROM TRACK NATURAL JOIN PODCASTEPISODE NATURAL JOIN PODCAST NATURAL JOIN HOSTS WHERE HOSTID="+HOSTID+";");
			while (rs.next()) {
				System.out.println(rs.getString(1)+"--"+rs.getString(2)+"--"+rs.getString(3)+"--"+rs.getString(4)+"--"+rs.getString(5)+"--"+rs.getString(6));
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
