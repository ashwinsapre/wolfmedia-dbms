import java.sql.*;

public class Op150 {
	public int exec(Connection conn, String PODCASTID) {
		try {
			Statement s = conn.createStatement();
			String TYPE = "Podcast";
			
			ResultSet rs = s.executeQuery("SELECT CYCLEID, SUM(PLAYLISTENCOUNT) FROM PLAYRECORD JOIN PODCASTEPISODE ON PLAYRECORD.TRACKID=PODCASTEPISODE.TRACKID WHERE PODCASTID="+Integer.parseInt(PODCASTID)+" GROUP BY CYCLEID, PODCASTID;");
			if (rs.next() == false) {
				System.out.println("0 rows returned");
			}
			rs.beforeFirst();
			while (rs.next()) {
				System.out.println(rs.getString(1)+"--"+rs.getString(2));
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
