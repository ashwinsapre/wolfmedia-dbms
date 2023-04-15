import java.sql.*;

public class Op22 {
	public int exec(Connection conn, String SEARCHSTRING){
		ResultSet rs = null;
		try {
			Statement s = conn.createStatement();
			rs = s.executeQuery("SELECT TRACKID, 'SONG' AS TYPE FROM TRACK NATURAL JOIN SONG WHERE TITLE LIKE '%"+SEARCHSTRING+"%' UNION SELECT TRACKID, 'PODCAST EPISODE'  AS TYPE FROM TRACK NATURAL JOIN PODCASTEPISODE WHERE TITLE LIKE '%"+SEARCHSTRING+"%' UNION SELECT PODCASTID, 'PODCAST' AS TYPE FROM PODCAST  WHERE NAME LIKE '%"+SEARCHSTRING+"%' UNION SELECT ALBUMID, 'ALBUM' AS TYPE FROM ALBUM WHERE NAME LIKE '%"+SEARCHSTRING+"%' UNION SELECT ARTISTID, 'ARTIST' AS TYPE FROM ARTIST  WHERE NAME LIKE '%"+SEARCHSTRING+"%' UNION SELECT HOSTID, 'HOST' AS TYPE FROM HOST WHERE FIRSTNAME LIKE '%"+SEARCHSTRING+"%' ;");
	
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