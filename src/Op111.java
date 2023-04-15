import java.sql.*;

public class Op111 {
	public int exec(Connection conn, String NAME, String EDITION){
		ResultSet rs = null;
		try {
			Statement s = conn.createStatement();


			int rowsAffected = s.executeUpdate(" INSERT INTO ALBUM (name, edition) VALUES('"+NAME+"','"+EDITION+"') ;");
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


