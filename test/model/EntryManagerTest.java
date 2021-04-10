package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exceptions.*;

class EntryManagerTest {
	
	private EntryManager entryManager;
	
	public void SetScenary1(){
		entryManager = new EntryManager();
		try {
			entryManager.registerEntry("CC",124576,7);
			entryManager.registerEntry("CC",9876512,7);
		}catch(IncorrectIdNumberException | InvalidIdTypeException e){}
	}//End SetScenary1
	@Test
	public void testRegisterEntry1(){
		SetScenary1();
		String idType = "CC";
		int idNumber = 105798232;
		int day = 5;
		try{
			entryManager.registerEntry(idType,idNumber,day);
			assertEquals(3,entryManager.getTryEntryAmount());
		}catch(IncorrectIdNumberException | InvalidIdTypeException e){}
	}//End testRegisterEntry1
	@Test
	public void testRegisterEntry2(){
		SetScenary1();
		String idType = "TI";
		int idNumber = 105798232;
		int day = 1;
		try{
			entryManager.registerEntry(idType,idNumber,day);
		}catch(IncorrectIdNumberException | InvalidIdTypeException e){
			assertEquals(3,entryManager.getTryEntryAmount());
		}
	}//End testRegisterEntry2
	@Test
	public void testRegisterEntry3(){
		SetScenary1();
		String idType = "CC";
		int idNumber = 105798292;
		int day = 1;
		try{
			assertTrue(entryManager.registerEntry(idType,idNumber,day));
		}catch(IncorrectIdNumberException | InvalidIdTypeException e){}
	}//End testRegisterEntry3
	@Test
	public void testRegisterEntry4(){
		SetScenary1();
		String idType = "TI";
		int idNumber = 105798232;
		int day = 3;
		try{
			entryManager.registerEntry(idType,idNumber,day);
			fail("Tremendo error");
		}catch(IncorrectIdNumberException e){}
		catch(InvalidIdTypeException e){
			assertEquals("TI",e.getIdType());
		}
	}//End testRegisterEntry4
	@Test
	public void testRegisterEntry5(){
		SetScenary1();
		String idType = "CC";
		int idNumber = 105798242;
		int day = 3;
		try{
			entryManager.registerEntry(idType,idNumber,day);
			fail("Tremendo error");
		}catch(IncorrectIdNumberException e){
			assertEquals((4%2),((e.getIdNumber()%100)/10)%2); //e.getIdNumber() == 105798242; 105798242%100 = 42; 42/10 = 4; expresion resultante 4%2                   
		}
		catch(InvalidIdTypeException e){}
	}//End testRegisterEntry5
}//End EntryManagerTest
