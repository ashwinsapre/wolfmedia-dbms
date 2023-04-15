import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//START AND ENDDATE IN QUERY?

public class Op46 {
	public int exec(Connection conn, String LABELID){
		ResultSet rs = null;
		try {
			Statement s = conn.createStatement();
			rs = s.executeQuery("SELECT SUM(amountCalculated) FROM PAYMENTOUTRECORD\r\n"
					+ "P,(SELECT CYCLEID FROM CYCLE WHERE\r\n"
					+ "MONTH=MONTH('2023-03-01') AND YEAR=YEAR('2023-03-01'))\r\n"
					+ "STARTCYCLE, (SELECT CYCLEID FROM CYCLE WHERE\r\n"
					+ "MONTH=MONTH('2023-03-01') AND YEAR=YEAR('2023-03-01'))\r\n"
					+ "ENDCYCLE WHERE P.CYCLEID>=STARTCYCLE.CYCLEID AND\r\n"
					+ "P.CYCLEID<=ENDCYCLE.CYCLEID AND PAYEETYPE='LABEL' and\r\n"
					+ "PAYEEID="+LABELID+";");
			while (rs.next()) {
				String val = rs.getString(1);
				double roundOffVal = Math.round(Double.parseDouble(val) * 100.0) / 100.0;
				System.out.println(roundOffVal);
				// System.out.println(rs.getString(1)+"--"+rs.getString(2)+"--"+rs.getString(3));
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
