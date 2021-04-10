package model;

public class Person {
	private String idType;
	private int idNumber;
	
	public Person(){
		idType = new String();
		idNumber = 0;
	}//End constructor1
	public Person(String idType, int idNumber){
		this.idType = idType;
		this.idNumber = idNumber;
	}//End constructor2
	public void setIdType(String idType){
		this.idType = idType;
	}//End setIdType
	public String getIdType(){
		return idType;
	}//End getIdType
	public void setIdNumber(int idNumber){
		this.idNumber = idNumber;
	}//End setIdType
	public int getIdNumber(){
		return idNumber;
	}//End getIdType
}//End Person
