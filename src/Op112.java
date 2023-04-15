import java.sql.*;

public class Op112 {
	public int exec(Connection conn, String ALBUMID){
		ResultSet rs = null;
		try {
			Statement s = conn.createStatement();


			int rowsAffected = s.executeUpdate(" DELETE FROM ALBUM WHERE ALBUMID="+Integer.parseInt(ALBUMID)+" ;");
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


