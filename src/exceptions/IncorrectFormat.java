package exceptions;

public class IncorrectFormat extends Exception {
	public IncorrectFormat(String s, String format) {
		super(s + " is incorrect.\n"
				+ "Correct format is: " + format);
	}
}
