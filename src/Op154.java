import java.sql.*;

public class Op154 {
	public int exec(Connection conn, String USERID) {
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT TARGETID, TYPE FROM ACTIVELYLISTENSTO WHERE USERID = "+Integer.parseInt(USERID)+" ;");
			if (rs.next() == false) {
				System.out.println("0 rows returned");
			}
			rs.beforeFirst();
			while (rs.next()) {
				System.out.println(rs.getString(1)+"--"+rs.getString(2));
			}
		}
		catch(Exception e) {
			//copy the same catch block, easier for debugging
			//return 0 when there's an error

			System.out.println("An error occurred while executing the query.");
			System.out.println(e.getMessage());
			return 0;
		}
		return 1;
	}
}
