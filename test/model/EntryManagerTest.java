package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exceptions.*;

class EntryManagerTest {
	
	private EntryManager entryManager;
	
	public void SetScenary1(){
		entryManager = new EntryManager();
		try {
			entryManager.registerEntry("CC",124576);
			entryManager.registerEntry("CC",124576);
		}catch(IncorrectIdNumberException | InvalidIdTypeException e){}
	}//End SetScenary1
	
}//End EntryManagerTest
