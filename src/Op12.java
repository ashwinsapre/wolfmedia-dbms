import java.sql.*;
import java.util.Scanner;

public class Op12 {
	public int exec(Connection conn, Scanner paramscanner, String TRACKID) {
        
		//do not make new connection object
		try {
			conn.setAutoCommit(false);
			String paramlist[] = {"TITLE", "DURATION", "RELEASEDATE", "GENRES", "ROYALTYRATE"};
			Boolean paramboollist[] = new Boolean[paramlist.length+1];
			String paramstrlist[] = new String[paramlist.length+1];
			for(int i=0;i<paramlist.length;i++) {
				paramboollist[i]=false;
				paramstrlist[i]="";
			}
			for(int i=0;i<paramlist.length;i++) {
				System.out.println("If you want to update parameter "+paramlist[i]+" enter new value else enter a backslash(/)");
				System.out.println("Please enter strings enclosed in single quotes ( ' ' )");
				String val = paramscanner.nextLine();
				if (val.compareToIgnoreCase("/")!=0) {
				    	paramboollist[i]=true;
				    	paramstrlist[i]=val;
				    }
			}
			String updateString1 = "UPDATE TRACK SET ";
			boolean u1flag=false;
			String updateString2 = "UPDATE SONG SET ";
			boolean u2flag=false;
			for (int i=0;i<paramlist.length;i++) {
				if (i<3) {
					if (paramboollist[i]==true){
						u1flag=true;
						updateString1 = updateString1 + paramlist[i] + " = " + paramstrlist[i] + ",";
					}
				}
				else {
					if (paramboollist[i]==true){
						u2flag=true;
						updateString2 = updateString2 + paramlist[i] + " = " + paramstrlist[i] + ",";
					}
				}
			}
			Statement s = conn.createStatement();
			if (u1flag==true) {
				updateString1 = updateString1.substring(0, updateString1.length()-1) + " WHERE TRACKID="+Integer.parseInt(TRACKID)+" ;";
				s.executeUpdate(updateString1);
			}
			if (u2flag==true) {
				updateString2 = updateString2.substring(0, updateString2.length()-1) + " WHERE TRACKID="+Integer.parseInt(TRACKID)+" ;";
				s.executeUpdate(updateString2);
			}
			
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
