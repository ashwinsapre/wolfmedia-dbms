import java.sql.*;

public class Op123 {
	public int exec(Connection conn,  String  FIRSTNAME, String LASTNAME, String PHONE, String EMAIL, String CITY){
		ResultSet rs = null;
		try {
			Statement s = conn.createStatement();

			int rowsAffected = s.executeUpdate(" INSERT INTO HOST(firstName,lastName,phone,email,city) VALUES ('"+FIRSTNAME+"' ,'"+LASTNAME+"',"+Integer.parseInt(PHONE)+", '"+EMAIL+"' , '"+CITY+"') ;");
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

