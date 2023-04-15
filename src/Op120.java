import java.sql.*;

public class Op120 {
	public int exec(Connection conn, String PODCASTID){
		ResultSet rs = null;
		try {
			conn.setAutoCommit(false);
			Statement s = conn.createStatement();

			s.executeUpdate(" DELETE FROM HOSTS WHERE PODCASTID="+Integer.parseInt(PODCASTID)+" ;");
			s.executeUpdate(" DELETE FROM PODCAST WHERE PODCASTID="+Integer.parseInt(PODCASTID)+" ;");
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

