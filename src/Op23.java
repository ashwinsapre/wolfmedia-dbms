import java.sql.*;

public class Op23 {
	public int exec(Connection conn,  String USERID, String TYPE, String TYPEID){
		ResultSet rs = null;
		try {
			Statement s = conn.createStatement();

			int rowsAffected = s.executeUpdate(" INSERT INTO ACTIVELYLISTENSTO(targetID,type,userID) VALUES("+Integer.parseInt(TYPEID)+",'"+TYPE+"',"+Integer.parseInt(USERID)+") ;");
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

