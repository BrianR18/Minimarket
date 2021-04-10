package model;

public class Person {
	private int idNumber;
	private Id idType;
	public Person(){
		idType = Id.CC;
		idNumber = 0;
	}//End constructor1
	public Person(String idType, int idNumber){
		this.idType = Id.valueOf(idType.toUpperCase());
		this.idNumber = idNumber;
	}//End constructor2
	public void setIdType(String idType){
		this.idType = Id.valueOf(idType.toUpperCase());
	}//End setIdType
	public String getIdType(){
		return idType.toString();
	}//End getIdType
	public void setIdNumber(int idNumber){
		this.idNumber = idNumber;
	}//End setIdType
	public int getIdNumber(){
		return idNumber;
	}//End getIdType
}//End Person
