package Exceptions;

public class InvalidIdTypeException extends Exception {
	private static final long serialVersionUID = 1L;
	private String incorrectIdType;
	
	public InvalidIdTypeException(String incorrectIdType){
		super("You must be of legal age to enter");
		this.incorrectIdType =  incorrectIdType;
	}//End IncorrectIdNumberException
	public String getIdType(){
		return incorrectIdType;
	}//End getIdNumber
}
