import java.sql.*;
import java.util.Scanner;

public class Op114 {
	public int exec(Connection conn, Scanner paramscanner,String TRACKID) {

		try {
			String paramlist[] = {"TITLE", "ADVCOUNT", "SPECIALGUESTS"};
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
			String updateString2 = "UPDATE PODCASTEPISODE SET ";
			boolean us1 = false;
			boolean us2 = false;
			for (int i=0;i<paramlist.length;i++) {
				if (i<1) {
					if (paramboollist[i]==true){
						us1=true;
						updateString1 = updateString1 + paramlist[i] + " = " + paramstrlist[i];
					}
				}
				else {
					if (paramboollist[i]==true){
						us2=true;
						updateString2 = updateString2 + paramlist[i] + " = " + paramstrlist[i]+ ",";
					}
				}
			}
			updateString1 = updateString1 + " WHERE TRACKID="+Integer.parseInt(TRACKID)+" ;";
			updateString2 = updateString2.substring(0,updateString2.length()-1) + " WHERE TRACKID="+Integer.parseInt(TRACKID)+" ;";
			
			Statement s = conn.createStatement();
			
			conn.setAutoCommit(false);
			
			//make query string using parameters
			//do not forget semicolon at the end
			if (us1==true) {
				int u1 = s.executeUpdate(updateString1);
			}
			if (us2==true) {
				int u2 = s.executeUpdate(updateString2);
			}
			
			//Check if needed
            conn.commit();
            conn.setAutoCommit(true);
		}
		catch(Exception e) {
			//copy the same catch block, easier for debugging
			//return 0 when there's an error

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
        
        
		//return 1 when query runs successfully
		//no need to return ResultSet, we will verify the contents of database on terminal
		//MIGHT NEED TO RETURN RESULTSET FOR REPORTS
		return 1;
	}
}
