import java.sql.*;

public class Op14 {
	public int exec(Connection conn, String TRACKID){
		ResultSet rs = null;
		try {
			conn.setAutoCommit(false);
			Statement s = conn.createStatement();
		

			s.executeUpdate(" DELETE FROM SINGS WHERE TRACKID = "+Integer.parseInt(TRACKID)+" ;");
			s.executeUpdate(" DELETE FROM SONG WHERE TRACKID = "+Integer.parseInt(TRACKID)+" ;");
			s.executeUpdate(" DELETE FROM TRACK WHERE TRACKID = "+Integer.parseInt(TRACKID)+" ;");

			//Check if needed
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

