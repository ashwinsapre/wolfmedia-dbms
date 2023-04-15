import java.sql.*;

public class Op31 {
	public int exec(Connection conn,  String TRACKID){
		ResultSet rs = null;
		try {

			conn.setAutoCommit(false);
			Statement s = conn.createStatement();


			s.executeUpdate(" INSERT INTO PAYMENTOUTRECORD SELECT B.CYCLEID, A.TRACKID, 'Song' AS TRACKTYPE, D.LABELID AS PAYEEID, 'Label' AS PAYEETYPE,(A.ROYALTYRATE * B.PLAYLISTENCOUNT)  AS AMOUNTPAID, (0.3 * A.ROYALTYRATE * B.PLAYLISTENCOUNT) AS AMOUNTPAID FROM SONG A INNER JOIN PLAYRECORD B ON A.TRACKID=B.TRACKID AND B.CYCLEID=202304 "+
"INNER JOIN SINGS C ON C.TRACKID=A.TRACKID AND C.ARTISTTYPE ='Main' INNER JOIN ARTIST D ON D.ARTISTID=C.ARTISTID WHERE A.TRACKID="+Integer.parseInt(TRACKID)+" ;");
			
			s.executeUpdate("INSERT INTO PAYMENTOUTRECORD SELECT B.CYCLEID, A.TRACKID, 'Song' AS TRACKTYPE, D.ARTISTID AS PAYEEID, 'Artist' AS PAYEETYPE, 0 AS AMOUNTPAID,((0.7 * A.ROYALTYRATE * B.PLAYLISTENCOUNT)/NOOFARTIST) AS AMOUNTPAID FROM SONG A INNER JOIN PLAYRECORD B ON A.TRACKID=B.TRACKID AND B.CYCLEID=202304 INNER JOIN (SELECT COUNT(ARTISTID) AS NOOFARTIST, TRACKID FROM SINGS GROUP BY TRACKID) C ON C.TRACKID=A.TRACKID "+
"INNER JOIN SINGS D ON D.TRACKID=A.TRACKID WHERE A.TRACKID="+Integer.parseInt(TRACKID)+" ;");


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