import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//START AND ENDDATE IN QUERY?
public class Op47 {
	public int exec(Connection conn){
		ResultSet rs = null;
		try {
			Statement s = conn.createStatement();
			rs = s.executeQuery("SELECT INP.CYCLEID, INP.AMOUNT - POUT.AMOUNT AS REVENUE FROM (SELECT AMOUNT, CYCLEID FROM PAYMENTINRECORD) INP INNER JOIN (SELECT SUM(AMOUNTCALCULATED) AS AMOUNT, CYCLEID FROM PAYMENTOUTRECORD GROUP BY CYCLEID) POUT ON INP.CYCLEID=POUT.CYCLEID;");
			while (rs.next()) {
				String val = rs.getString(2);
				double roundOffVal = Math.round(Double.parseDouble(val) * 100.0) / 100.0;
				System.out.println(rs.getString(1)+"---"+roundOffVal);
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
