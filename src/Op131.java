import java.sql.*;

public class Op131 {
	public int exec(Connection conn, String FIRSTNAME, String LASTNAME, String PHONE, String EMAIL, String REGISTRATIONDATE, String SUBSCRIPTIONSTATUS,  String MONTHLYFEE ) {
		try {
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery( "INSERT INTO USER(firstName,lastName,phone,email,registrationDate,subscriptionStatus,monthlyFee) VALUES ('"+ FIRSTNAME +"','"+ LASTNAME+"',"+ Integer.parseInt(PHONE) +",'"+ EMAIL +"',"+ REGISTRATIONDATE + ",'" + SUBSCRIPTIONSTATUS + "',"+ MONTHLYFEE + ");");
			
		}
		catch(Exception e) {
			System.out.println("An error occurred while executing the query.");
			System.out.println(e.getMessage());
			return 0;
		}
		return 1;
	}
}
