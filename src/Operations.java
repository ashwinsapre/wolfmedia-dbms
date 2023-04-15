import java.sql.*;
import java.util.Scanner;
import java.lang.*;
import java.util.Collections;
import java.util.*;


public class Operations {
	
	//database connection details
	static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/ssingh57";
	static final String userid = "ssingh57";
	static final String password = "200477942";


	public static Connection openConnection(String userid, String password) {
		//function to create connection object
		//this object is pass to each operation
		
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcURL, userid, password);
	    }
	    catch(Exception e) {
	    	System.out.println("An error occurred while establishing a connection.");
	    }
	    return conn;
	}
	
	public static void closeConnection(Connection conn, Statement s, ResultSet rs) {
		//function to close connection
		//called when user exits from the main menu
		
		if(conn != null) {
	         try { conn.close(); System.out.println("Connection closed");} catch(Throwable whatever) {}
	     }
		if(s != null) {
	         try { s.close(); System.out.println("Statement closed");} catch(Throwable whatever) {}
	     }
		if(rs != null) {
	         try { rs.close(); System.out.println("ResultSet closed");} catch(Throwable whatever) {}
	     }
	}


	public static void main(String args[]) {
		
		//create connection
		Connection conn = openConnection(userid, password);
		Statement s = null;
		ResultSet rs = null;
		
		String category = "";

	    int reprint = 1;
		while(true) {
			//prompt user to select category
			
			Scanner myObj = new Scanner(System.in);
			System.out.println("Choose category");
			System.out.println("1. Information Processing");
		    System.out.println("2. Maintaining Metadata and Records");
		    System.out.println("3. Maintaining Payments");
		    System.out.println("4. Reports");
		    System.out.println("To exit, type exit");

		    category = myObj.nextLine();
		    
		    if (category.compareToIgnoreCase("exit")==0) {
		    	System.out.println("Exit!");
		    	break;
		    }
		    int cat=0;
		    
		    //check for invalid input types
		    try {
		    	cat = Integer.parseInt(category);
		    }
		    catch(Exception e) {
		    	System.out.println("Invalid input. Please try again.");
		    	continue;
		    }
		    String operation = "";
		    switch(cat) {
		    
		    //CATEGORY 1: INFORMATION PROCESSING ===================================================
		    
		    case 1:{
		    	while(true) {
		    		System.out.println("Choose operation");
		    		System.out.println("To go back to the main menu, type exit");
		    		if (reprint==1) {
		    			//print all possible operations within this category
		    			System.out.println("1. Get song info");
						System.out.println("2. Update song info");
						System.out.println("3. Insert song info");
						System.out.println("4. Delete song info");
						System.out.println("5. Get artist info");
						System.out.println("6. Update artist info");
						System.out.println("7. Insert artist info");
						System.out.println("8. Delete artist info");
						System.out.println("9. Get album info");
						System.out.println("10. Update album info");
						System.out.println("11. Insert album info");
						System.out.println("12. Delete album info");
						System.out.println("13. Get podcast episode info");
						System.out.println("14. Update podcast episode info");
						System.out.println("15. Insert podcast episode info");
						System.out.println("16. Delete podcast episode info");
						System.out.println("17. Get podcast info");
						System.out.println("18. Update podcast info");
						System.out.println("19. Insert podcast info");
						System.out.println("20. Delete podcast info");
						System.out.println("21. Get podcast host info");
						System.out.println("22. Update podcast host info");
						System.out.println("23. Insert podcast host info");
						System.out.println("24. Delete podcast host info");
						System.out.println("25. Get record label info");
						System.out.println("26. Update record label info");
						System.out.println("27. Insert record label info");
						System.out.println("28. Delete record label info");
						System.out.println("29. Get user info");
						System.out.println("30. Update user info");
						System.out.println("31. Insert user info");
						System.out.println("32. Delete user info");
						System.out.println("33. Get all artists for a song");
						System.out.println("34. Get all songs by an artist");
						System.out.println("35. Get all collaborators for an artist");
						System.out.println("36. Get the record label for an artist");
						System.out.println("37. Get all artist associated with a record label");
						System.out.println("38. Get album ID and track number of a song");
						System.out.println("39. Get all songs of an album and their track numbers");
						System.out.println("40. Get album release date");
						System.out.println("41. Get all albums by an artist");
						System.out.println("42. Get all artists that made an album");
						System.out.println("43. Get number of people subscribed to an artist");
						System.out.println("44. Get listening statistics of a song for all time periods");
						System.out.println("45. Get the podcast that a podcast episode belongs to");
						System.out.println("46. Get all episodes of a podcast");
						System.out.println("47. Get all hosts of a podcast");
						System.out.println("48. Get all podcasts hosted by a host");
						System.out.println("49. Get number of people subscribed to a podcast");
						System.out.println("50. Get listening statistics of a podcast");
						System.out.println("51. Get number of episodes in a podcast");
						System.out.println("52. Get podcast rating");
						System.out.println("53. Update user subscription plan");
						System.out.println("54. Get all subscriptions of a given user");
						System.out.println("55. Assign Song to Album");
						System.out.println("56. Assign Artist to Song");
						System.out.println("57. Assign Artist to label");
						System.out.println("58. Assign Podcast Episode to Podcast");
						System.out.println("59. Assign Podcast to Host");
						reprint=0;
		    		}
					
					//prompt user to select an operation within category 1
					
					operation = myObj.nextLine();
					if (operation.compareToIgnoreCase("exit")==0) {
				    	System.out.println("Going back to main menu...");
				    	reprint=1;
				    	break;
				    }
				    int op=0;
				    try {
				    	op = Integer.parseInt(operation);
				    }
				    catch(Exception e) {
				    	System.out.println("Invalid input. Please try again.");
				    	continue;
				    }
				    switch(op) {
				    
					    case 1:{
					    	//create a new class of specified operation
				    		Op11 o = new Op11();
				    		
				    		//receive input and parse it
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter trackID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		
				    		//pass parameters and connection object to exec function of class
				    		int code = o.exec(conn, params[0]);
				    		
				    		//if status code is 1, operation was successful
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		//if not, return an error message
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
					    
					    case 2:{
				    		Op12 o = new Op12();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter trackID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, myObj,params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	
					    case 3:{
					    	Op13 o = new Op13();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0], params[1], params[2], params[3], params[4], params[5], params[6], params[7], params[8], params[9], params[10]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
					    }
					    case 4:{
				    		Op14 o = new Op14();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter trackID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
					    case 5:{
				    		Op15 o = new Op15();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter artistID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
					    
					    case 6:{
				    		Op16 o = new Op16();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter artistID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, myObj, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
					    case 7:{
				    		Op17 o = new Op17();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0],params[1],params[2],params[3],params[4],params[5]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
					    
					    case 8:{
				    		Op18 o = new Op18();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter artistID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
					    case 9:{
				    		Op19 o = new Op19();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter albumID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 10:{
				    		Op110 o = new Op110();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter albumID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn,myObj, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 11:{
				    		Op111 o = new Op111();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0],params[1]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 12:{
				    		Op112 o = new Op112();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter albumID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 13:{
				    		Op113 o = new Op113();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter podcast episode ID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	
				    	case 14:{
				    		Op114 o = new Op114();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter podcast episode ID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, myObj, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	
				    	case 15:{
				    		Op115 o = new Op115();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0], params[1], params[2], params[3], params[4], params[5], params[6], params[7]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 16:{
				    		Op116 o = new Op116();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter podcast episode ID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	
				    	case 17:{
				    		Op117 o = new Op117();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter podcastID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 18:{
				    		Op118 o = new Op118();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter podcastID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, myObj, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 19:{
				    		Op119 o = new Op119();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0], params[1], params[2], params[3], params[4], params[5]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 20:{
				    		Op120 o = new Op120();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter podcastID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		System.out.println(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 21:{
				    		Op121 o = new Op121();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter hostID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	
				    	case 22:{
				    		Op122 o = new Op122();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter hostID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, myObj, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 23:{
				    		Op123 o = new Op123();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0],params[1],params[2],params[3],params[4]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 24:{
				    		Op124 o = new Op124();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter hostID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 25:{
				    		Op125 o = new Op125();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter labelID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 26:{
				    		Op126 o = new Op126();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter labelID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0], myObj);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 27:{
				    		Op127 o = new Op127();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 28:{
				    		Op128 o = new Op128();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter labelID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 29:{
				    		Op129 o = new Op129();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter userID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 30:{
				    		Op130 o = new Op130();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter userID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, myObj, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 31:{
				    		Op131 o = new Op131();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0],params[1],params[2],params[3],params[4],params[5],params[6]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 32:{
				    		Op132 o = new Op132();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter userID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 33:{
				    		Op133 o = new Op133();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter trackID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 34:{
				    		Op134 o = new Op134();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter artistID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 35:{
				    		Op135 o = new Op135();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter artistID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 36:{
				    		Op136 o = new Op136();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter artistID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 37:{
				    		Op137 o = new Op137();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter labelID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 38:{
				    		Op138 o = new Op138();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter trackID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 39:{
				    		Op139 o = new Op139();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter albumID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 40:{
				    		Op140 o = new Op140();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter albumID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 41:{
				    		Op141 o = new Op141();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter artistID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 42:{
				    		Op142 o = new Op142();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter albumID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 43:{
				    		Op143 o = new Op143();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter artistID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 44:{
				    		Op144 o = new Op144();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter trackID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 45:{
				    		Op145 o = new Op145();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter podcast episode ID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 46:{
				    		Op146 o = new Op146();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter podcastID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 47:{
				    		Op147 o = new Op147();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter podcastID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 48:{
				    		Op148 o = new Op148();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter hostID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 49:{
				    		Op149 o = new Op149();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter podcastID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 50:{
				    		Op150 o = new Op150();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter podcastID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 51:{
				    		Op151 o = new Op151();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter podcastID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 52:{
				    		Op152 o = new Op152();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter podcastID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 53:{
				    		Op153 o = new Op153();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter userID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, myObj,params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 54:{
				    		Op154 o = new Op154();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter userID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
						case 55:{
				    		Op155 o = new Op155();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0],params[1]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 56:{
				    		Op156 o = new Op156();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0],params[1],params[2]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
						case 57:{
				    		Op157 o = new Op157();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0],params[1]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
						case 58:{
				    		Op158 o = new Op158();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0],params[1]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
						case 59:{
				    		Op159 o = new Op159();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0],params[1]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	default:
				    		System.out.println("Invalid input. Please try again.");
				    }
		    	}
		    	break;
		    }
		    //CATEGORY 2: MAINTAINING METADATA AND RECORDS ===================================================
		    
		    case 2:{
		    	while(true) {
		    		System.out.println("Choose operation");
					System.out.println("To go back to the main menu, type exit");
		    		if (reprint==1) {

						System.out.println("1. Increment song play count");
						System.out.println("2. Search");
						System.out.println("3. Insert active listener");
						System.out.println("4. Insert podcast rating");
						
						reprint=0;
		    		}
					//prompt user to select an operation within category 2
					
					operation = myObj.nextLine();
					if (operation.compareToIgnoreCase("exit")==0) {
				    	System.out.println("Going back to main menu...");
				    	reprint=1;
				    	break;
				    }
				    int op=0;
				    try {
				    	op = Integer.parseInt(operation);
				    }
				    catch(Exception e) {
				    	System.out.println("Invalid input. Please try again.");
				    	continue;
				    }
				    switch(op) {
				    	
				    	case 1:{
				    		Op21 o = new Op21();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter trackID");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	
				    	}
				    	
				    	case 2:{
				    		Op22 o = new Op22();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 3:{
				    		Op23 o = new Op23();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0], params[1], params[2]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 4:{
				    		Op24 o = new Op24();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0], params[1], params[2]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	default:
				    		System.out.println("Invalid input. Please try again.");
				    }
		    	}
		    	break;
		    }
		    //CATEGORY 3: MAINTAINING PAYMENTS ===================================================
		   
		    case 3:{
		    	
		    	while(true) {
		    		System.out.println("Choose operation");
					System.out.println("To go back to the main menu, type exit");
					if (reprint==1) {
						System.out.println("1. Generate Song royalties");
						System.out.println("2. Generate Podcast royalties");
						System.out.println("3. Generate User payments");
						
						reprint=0;
					}
					
					//prompt user to select an operation within category 3
					
					operation = myObj.nextLine();
					if (operation.compareToIgnoreCase("exit")==0) {
				    	System.out.println("Going back to main menu...");
				    	reprint=1;
				    	break;
				    }
				    int op=0;
				    try {
				    	op = Integer.parseInt(operation);
				    }
				    catch(Exception e) {
				    	System.out.println("Invalid input. Please try again.");
				    	continue;
				    }
				    switch(op) {
				   
				    case 1:{
			    		Op31 o = new Op31();
			    		ParseInput p = new ParseInput();
			    		System.out.println("Please enter parameters separated by a /");
			    		String parameters = myObj.nextLine();
			    		String[] params = p.parse(parameters);
			    		
			    		int code = o.exec(conn, params[0]);
			    		if (code==1) {
			    			System.out.println("Operation performed successfully.");
			    		}
			    		else {
			    			System.out.println("There was an error.");
			    		}
			    		break;
			    	}
			    	case 2:{
			    		Op32 o = new Op32();
			    		ParseInput p = new ParseInput();
			    		System.out.println("Please enter parameters separated by a /");
			    		String parameters = myObj.nextLine();
			    		String[] params = p.parse(parameters);
			    		
			    		int code = o.exec(conn, params[0]);
			    		if (code==1) {
			    			System.out.println("Operation performed successfully.");
			    		}
			    		else {
			    			System.out.println("There was an error.");
			    		}
			    		break;
			    	}
			    	case 3:{
			    		Op33 o = new Op33();
			    		//ParseInput p = new ParseInput();
			    		System.out.println("Please enter parameters separated by a /");
			    		//String parameters = myObj.nextLine();
			    		//String[] params = p.parse(parameters);
			    		
			    		int code = o.exec(conn);
			    		if (code==1) {
			    			System.out.println("Operation performed successfully.");
			    		}
			    		else {
			    			System.out.println("There was an error.");
			    		}
			    		break;
			    	}
				    	
				    	default:
				    		System.out.println("Invalid input. Please try again.");
				    }
				    
		    	}
		    	break;
		    }
		    
		    //CATEGORY 4: REPORTS =================================================== 
		    
		    case 4:{
		    	System.out.println("Case 4");
		    	while(true) {
					System.out.println("Choose Report");
					System.out.println("To go back to the main menu, type exit");
					
					if (reprint==1) {
						System.out.println("1. Monthly play count per song");
						System.out.println("2. Monthly play count per album");
						System.out.println("3. Monthly play count per artist");
						System.out.println("4. Total payments made out to host per a given time period.");
						System.out.println("5. Total payments made out to artist per a given time period.");
						System.out.println("6. Total payments made out to record label per a given time period.");
						System.out.println("7. Total revenue of the streaming service per month, per year");
						System.out.println("8. All songs of an artist");
						System.out.println("9. All podcast episodes of a host");
						System.out.println("10. All songs of an album");
						System.out.println("11. All podcast episodes of a podcast");
						
						reprint=0;
					}
					//prompt user to select an operation within category 4
					
					operation = myObj.nextLine();
					if (operation.compareToIgnoreCase("exit")==0) {
				    	System.out.println("Going back to main menu...");
				    	reprint=1;
				    	break;
				    }
				    int op=0;
				    try {
				    	op = Integer.parseInt(operation);
				    }
				    catch(Exception e) {
				    	System.out.println("Invalid input. Please try again.");
				    	continue;
				    }
				    switch(op) {
				    
				    	case 1:{
				    		Op41 o = new Op41();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 2:{
				    		Op42 o = new Op42();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 3:{
				    		Op43 o = new Op43();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 4:{
				    		Op44 o = new Op44();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0],params[1],params[2]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 5:{
				    		Op45 o = new Op45();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 6:{
				    		Op46 o = new Op46();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 7:
				    	{
				    		Op47 o = new Op47();
				    		//ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		//String parameters = myObj.nextLine();
				    		//String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
			
				    	case 8:{
				    		Op48 o = new Op48();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 9:{
				    		Op49 o = new Op49();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 10:{
				    		Op410 o = new Op410();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	case 11:{
				    		Op411 o = new Op411();
				    		ParseInput p = new ParseInput();
				    		System.out.println("Please enter parameters separated by a /");
				    		String parameters = myObj.nextLine();
				    		String[] params = p.parse(parameters);
				    		
				    		int code = o.exec(conn, params[0]);
				    		if (code==1) {
				    			System.out.println("Operation performed successfully.");
				    		}
				    		else {
				    			System.out.println("There was an error.");
				    		}
				    		break;
				    	}
				    	
				    	default:
				    		System.out.println("Invalid input. Please try again.");
				    }
		    	}
		    	break;
		    }
		    default:
		    	System.out.println("Invalid input. Please try again");
		    }
		    
		}
		
		//when user exits the main menu, close connection
    	closeConnection(conn, s, rs);
	}
}
