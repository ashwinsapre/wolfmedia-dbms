import java.sql.*;

public class Op128 {
	public int exec(Connection conn, String LABELID) {
		//do not make new connection object
		try {
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery("DELETE FROM RECORDLABEL WHERE LABELID="+Integer.parseInt(LABELID)+"; ");
		}
		catch(Exception e) {
			System.out.println("An error occurred while executing the query.");
			System.out.println(e.getMessage());
			return 0;
		}
		return 1;
	}
}
