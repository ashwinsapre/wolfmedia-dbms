import java.sql.*;
import java.util.Scanner;

public class Op153 {
	public int exec(Connection conn, Scanner paramscanner, String USERID ) {
		try {
			String paramlist[] = {"MONTHLYFEE"};
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
			String updateString = "UPDATE USER SET ";
			
			for(int i=0;i<paramlist.length;i++) {
				if (paramboollist[i]==true){
					updateString = updateString + paramlist[i] + " = " + paramstrlist[i];
				}
				if (paramboollist[i]==true && i<paramlist.length-1) {
					updateString = updateString + ", ";
				}
			}
			updateString = updateString + " WHERE USERID="+Integer.parseInt(USERID)+" ;";
			Statement s = conn.createStatement();
			String SUBSCRIPTIONSTATUS = "Active";
			int rowsAffected = s.executeUpdate(updateString);
			System.out.println(rowsAffected + " rows affected");
		}
		catch(Exception e) {
			System.out.println("An error occurred while executing the query.");
			System.out.println(e.getMessage());
			return 0;
		}
		return 1;
	}
}
