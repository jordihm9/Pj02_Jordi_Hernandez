package exceptions;

public class RequiredException extends Exception {
	public RequiredException(String s) {
		super(s + " is required!");
	}
}
