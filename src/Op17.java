import java.sql.*;

public class Op17 {
	public int exec(Connection conn, String LABELID, String NAME, String STATUS, String TYPE, String COUNTRY, String PRIMARYGENRE){
		ResultSet rs = null;
		try {
			Statement s = conn.createStatement();
			int rowsAffected = s.executeUpdate(" INSERT INTO ARTIST (labelID,name,status,type,country,primaryGenre) VALUES("+Integer.parseInt(LABELID)+",'"+NAME+"','"+STATUS+"','"+TYPE+"','"+COUNTRY+"','"+PRIMARYGENRE+"') ; ");
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

