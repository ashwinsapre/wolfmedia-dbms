import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Op48 {
	public int exec(Connection conn, String ARTISTID){
		ResultSet rs = null;
		try {
			Statement s = conn.createStatement();
			rs = s.executeQuery("SELECT TRACKID FROM SINGS WHERE ARTISTID="+ARTISTID+";");
			if (rs.next() == false) {
				System.out.println("0 rows returned");
				// block of code to be executed if the condition is true
			}
			rs.beforeFirst();
			while (rs.next()) {
				System.out.println(rs.getString(1));
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
