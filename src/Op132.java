import java.sql.*;

public class Op132 {
	public int exec(Connection conn, String USERID) {
		//do not make new connection object
		try {
			conn.setAutoCommit(false);
			Statement s = conn.createStatement();
			String SUBSCRIPTIONSTATUS = "INACTIVE";
			int MONTHLYFEE = 0;
			int rowsAffected = s.executeUpdate("UPDATE USER SET SUBSCRIPTIONSTATUS='"+SUBSCRIPTIONSTATUS+"', MONTHLYFEE="+MONTHLYFEE+" WHERE USERID= "+Integer.parseInt(USERID)+" ;");
			s.executeUpdate("DELETE FROM ACTIVELYLISTENSTO WHERE USERID="+Integer.parseInt(USERID)+";");
			System.out.println(rowsAffected + " rows affected");
			
			conn.commit();
            conn.setAutoCommit(true);
		}
		catch(Exception e) {

			 System.out.println("An error occurred while executing the query.");
			 System.out.println(e.getMessage());

           if (conn!=null){
              try{
                  System.err.println("Transaction is being rolled back");
                  conn.rollback();
              }
              catch(Exception ex){
                  System.out.println("An error occurred while executing the query.");
					System.out.println(ex.getMessage());
              }
           }
			return 0;
		}
		return 1;
	}
}
