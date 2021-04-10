package ui;
import model.*;

public class Main {
	public static void main(String[] args){
		EntryManager em = new EntryManager();
		Menu menu = new Menu(em);
		menu.startProgram();
	}//End main
}
