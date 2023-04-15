import java.sql.*;

public class Op127 {
	public int exec(Connection conn, String NAME) {
		//do not make new connection object
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("INSERT INTO RECORDLABEL (name) VALUES('" + NAME + "');");
		}
		catch(Exception e) {

			System.out.println("An error occurred while executing the query.");
			System.out.println(e.getMessage());
			return 0;
		}
		return 1;
	}
}
