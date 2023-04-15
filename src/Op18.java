import java.sql.*;

public class Op18 {
	public int exec(Connection conn, String ARTISTID){
		ResultSet rs = null;
		try {
			Statement s = conn.createStatement();

			int rowsAffected = s.executeUpdate(" DELETE FROM ARTIST WHERE ARTISTID="+Integer.parseInt(ARTISTID)+" ;");
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

