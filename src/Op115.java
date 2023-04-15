import java.sql.*;

public class Op115 {
	public int exec(Connection conn, String TITLE, String DURATION, String RELEASEDATE, String PODCASTID, String FLATFEE, String BONUSRATE, String SPECIALGUESTS, String ADVCOUNT) {
		ResultSet rs=null;
		try {
			conn.setAutoCommit(false);
			Statement s = conn.createStatement();
			
			String query1 = " INSERT INTO TRACK(title,duration,releaseDate) VALUES ( '"+TITLE+"' ,"+Integer.parseInt(DURATION)+",'"+RELEASEDATE+"') ;";
			String selectQuery = " SELECT TRACKID FROM TRACK WHERE TITLE= '"+TITLE+"' ;";
			int u1 = s.executeUpdate(query1);
			rs=s.executeQuery(selectQuery);
			String id="";
			while(rs.next()) {
				id=rs.getString(1);
			}
			String query2 = " INSERT INTO PODCASTEPISODE VALUES("+Integer.parseInt(id)+","+Integer.parseInt(PODCASTID)+","+Integer.parseInt(FLATFEE)+","+Double.parseDouble(BONUSRATE)+", '"+SPECIALGUESTS+"',"+Integer.parseInt(ADVCOUNT)+") ;";

			int u2 = s.executeUpdate(query2);

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
