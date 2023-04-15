import java.sql.*;

public class Op119 {
	public int exec(Connection conn, String NAME, String LANGUAGE, String COUNTRY, String GENRES, String SPONSORS, String HOSTID) {
		
		try {
			ResultSet rs=null;
			conn.setAutoCommit(false);
			Statement s = conn.createStatement();
			String query1 = " INSERT INTO PODCAST(name,language,country,genres,sponsors) VALUES ('"+NAME+"','"+LANGUAGE+"','"+COUNTRY+"','"+GENRES+"','"+SPONSORS+"') ;";
			String selectQuery = " SELECT PODCASTID FROM PODCAST WHERE NAME= '"+NAME+"' ;";
			int u1 = s.executeUpdate(query1);
			rs=s.executeQuery(selectQuery);
			String id="";
			while(rs.next()) {
				id=rs.getString(1);
			}
			String query2 = " INSERT INTO HOSTS VALUES ("+Integer.parseInt(id)+" , "+Integer.parseInt(HOSTID)+") ;";

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
