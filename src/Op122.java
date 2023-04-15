import java.sql.*;
import java.util.Scanner;

public class Op122 {
	public int exec(Connection conn, Scanner paramscanner, String HOSTID){
		ResultSet rs = null;
		try {
			String paramlist[] = {"FIRSTNAME", "LASTNAME", "CITY", "EMAIL", "PHONE"};
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
			String updateString = "UPDATE HOST SET ";
			
			for(int i=0;i<paramlist.length;i++) {
				if (paramboollist[i]==true){
					updateString = updateString + paramlist[i] + " = " + paramstrlist[i]+ ",";
				}
			}
			updateString = updateString.substring(0,updateString.length()-1) + " WHERE HOSTID="+Integer.parseInt(HOSTID)+" ;";
			Statement s = conn.createStatement();

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

