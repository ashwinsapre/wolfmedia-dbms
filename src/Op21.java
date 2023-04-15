import java.sql.*;

public class Op21 {
	public int exec(Connection conn,  String TRACKID){
		ResultSet rs = null;
		try {
			Statement s = conn.createStatement();

			int rowsAffected = s.executeUpdate(" UPDATE PLAYRECORD SET PLAYLISTENCOUNT=PLAYLISTENCOUNT+1 WHERE TRACKID="+Integer.parseInt(TRACKID)+" AND CYCLEID=202304;");
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

