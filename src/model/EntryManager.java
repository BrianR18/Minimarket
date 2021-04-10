package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Exceptions.*;

public class EntryManager {
	private int tryEntryAmount;
	private List<Person> people;
	
	public EntryManager(){
		tryEntryAmount = 0;
		people = new ArrayList<Person>();
	}//End constructor
	
	@SuppressWarnings("deprecation")
	public void registerEntry(String idType,int idNumber) throws IncorrectIdNumberException, InvalidIdTypeException{
		tryEntryAmount++;
		Date date = new Date();
		if( (idNumber%100)%2 == 0 && date.getDay()%2!=0){
			throw new IncorrectIdNumberException(idNumber);
		}else if((idNumber%100)%2 != 0 && date.getDay()%2==0){
			throw new IncorrectIdNumberException(idNumber);
		}else if(idType.equalsIgnoreCase("TI")){
			throw new InvalidIdTypeException(idType);
		}else
			people.add(new Person(idType,idNumber));
	}//End registerEntry
	public int getTryEntryAmount(){
		return tryEntryAmount;
	}//End getTryEntryAmount
}//End EntryManager
