import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//START DATE AND END DATE IN QUERY?
public class Op44 {
	public int exec(Connection conn, String HOSTID, String STARTDATE, String ENDDATE){
		ResultSet rs = null;
		try {
			Statement s = conn.createStatement();
			rs = s.executeQuery("SELECT SUM(amountCalculated) FROM PAYMENTOUTRECORD P,(SELECT CYCLEID FROM CYCLE WHERE MONTH=MONTH('"+STARTDATE+"') AND YEAR=YEAR('"+STARTDATE+"')) STARTCYCLE, (SELECT CYCLEID FROM CYCLE WHERE "
					+ "MONTH=MONTH('"+ENDDATE+"') AND YEAR=YEAR('"+ENDDATE+"')) ENDCYCLE WHERE P.CYCLEID>=STARTCYCLE.CYCLEID AND P.CYCLEID<=ENDCYCLE.CYCLEID AND PAYEETYPE='Host' and PAYEEID="+HOSTID+";");
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
