package model;

import java.util.ArrayList;
import java.util.List;
import Exceptions.*;

public class EntryManager {
	private int tryEntryAmount;
	private List<Person> people;
	
	public EntryManager(){
		tryEntryAmount = 0;
		people = new ArrayList<Person>();
	}//End constructor
	
	public boolean registerEntry(String idType,int idNumber,int day) throws IncorrectIdNumberException, InvalidIdTypeException{
		increaseTryEntryAmount();
		boolean registered = false;
		if( ((idNumber%100)/10)%2 == 0 && day%2!=0){
			throw new IncorrectIdNumberException(idNumber);
		}else if(((idNumber%100)/10)%2 != 0 && day%2==0){
			throw new IncorrectIdNumberException(idNumber);
		}else if(idType.equalsIgnoreCase("ti")){
			throw new InvalidIdTypeException(idType);
		}else{
			people.add(new Person(idType,idNumber));
			registered = true;
		}//End else
		return registered;
	}//End registerEntry
	private void increaseTryEntryAmount(){
		++tryEntryAmount;
	}//End increaseTryEntryAmount
	public int getTryEntryAmount(){
		return tryEntryAmount;
	}//End getTryEntryAmount
	public boolean validateId(String id){
		boolean exist = false;
		Id[] ids = Id.values();
		for(Id i:ids){
			String sId = i.toString();
			if(sId.equalsIgnoreCase(id))
				exist = true;
		}//End for each
		return exist;
	}//End validateId
}//End EntryManager
