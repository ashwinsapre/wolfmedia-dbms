import java.sql.*;

public class Op121 {
	public int exec(Connection conn, String HOSTID){
		ResultSet rs = null;
		try {
			Statement s = conn.createStatement();
			rs = s.executeQuery("SELECT * FROM HOST WHERE HOSTID="+Integer.parseInt(HOSTID)+" ;");
			
			if (rs.next() == false) {
				System.out.println("0 rows returned");
			}
			rs.beforeFirst();
			while (rs.next()) {
				System.out.println(rs.getString(1)+"---"+rs.getString(2)+"---"+rs.getString(3)+"---"+rs.getString(4)+"---"+rs.getString(5));
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
