package Exceptions;

public class IncorrectIdNumberException extends Exception{

	private static final long serialVersionUID = 1L;
	private int incorrectIdNumber;
	
	public IncorrectIdNumberException(int idNumber){
		super("The id number is not correct for the current date.");
		incorrectIdNumber =  idNumber;
	}//End IncorrectIdNumberException
	public int getIdNumber(){
		return incorrectIdNumber;
	}//End getIdNumber
}
