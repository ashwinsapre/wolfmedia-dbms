import java.sql.*;

public class Op33 {
	public int exec(Connection conn){
		ResultSet rs = null;
		try {
			Statement s = conn.createStatement();

			int rowsAffected = s.executeUpdate(" UPDATE PAYMENTINRECORD SET AMOUNT=AMOUNT+(SELECT SUM(monthlyfee) FROM USER WHERE subscriptionStatus='Active') WHERE CYCLEID=202304;");
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


