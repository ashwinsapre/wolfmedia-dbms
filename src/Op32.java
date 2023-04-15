import java.sql.*;

public class Op32 {
	public int exec(Connection conn,  String TRACKID){
		ResultSet rs = null;
		try {
			Statement s = conn.createStatement();

			int rowsAffected = s.executeUpdate(" INSERT INTO PAYMENTOUTRECORD SELECT 202304  AS CYCLEID, "+Integer.parseInt(TRACKID)+" AS TRACKID, 'Episode' AS Tracktype, H.HostID, 'Host' as Payeetype,(E.flatfee + (E.advCount*E.bonusRate)), (E.flatfee + (E.advCount*E.bonusRate))"
+"FROM PODCASTEPISODE E INNER JOIN HOSTS H ON E.PODCASTID=H.PODCASTID WHERE E.TRACKID = "+Integer.parseInt(TRACKID)+" ;");
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


