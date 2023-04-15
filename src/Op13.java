import java.sql.*;

public class Op13 {
	public int exec(Connection conn, String TITLE, String DURATION, String GENRES, String ROYALTYRATE, String RELEASEDATE, String RELEASECOUNTRY, String LANGUAGE, String TRACKNUMBER, String ALBUMID, String ARTISTTYPE, String ARTISTID) {

        ResultSet rs=null;
		//do not make new connection object
		try {
			conn.setAutoCommit(false);
			Statement s = conn.createStatement();
			
			String query1 = "INSERT INTO TRACK (title,duration,releaseDate) VALUES ( '"+TITLE+"' ,"+Integer.parseInt(DURATION)+",'"+RELEASEDATE+"')"; 
			String selectQuery = "SELECT TRACKID FROM TRACK WHERE TITLE='"+TITLE+"';";
			s.executeUpdate(query1);
			rs = s.executeQuery(selectQuery);
			String id="";
			while (rs.next()) {
				id = rs.getString(1);
			}
			
			String query2 = "INSERT INTO SONG VALUES("+Integer.parseInt(id)+", "+Integer.parseInt(ALBUMID)+", '"+GENRES+"', "+Double.parseDouble(ROYALTYRATE)+", '"+RELEASECOUNTRY+"', '"+LANGUAGE+"', "+Integer.parseInt(TRACKNUMBER)+")";
			String query3 = "INSERT INTO SINGS (artistID, trackID, artistType )  VALUES("+Integer.parseInt(ARTISTID)+", "+Integer.parseInt(id)+", '"+ARTISTTYPE+"')";

			
			s.executeUpdate(query2);
            s.executeUpdate(query3);

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
