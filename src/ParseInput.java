//class to parse input submitted by the user

public class ParseInput {
	public String[] parse(String input) {
		//we ask the user to submitted all parameters separated by a backslash
		//this functions returns an array containing all parameters
		
		String[] arr = input.split("/");
		return arr;
	}
}
