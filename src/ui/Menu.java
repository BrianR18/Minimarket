package ui;

import java.util.Scanner;
import model.*;
import Exceptions.*;
public class Menu {

	private final int REGISTERENTRY = 1;
	private final int SEEAMOUNTTOTRYENTRY = 2;
	private final int EXIT = 3;
	private Scanner sc;
	private EntryManager em;
	
	public Menu(EntryManager em){
		this.em = em;
		sc = new Scanner(System.in);
	}//End Constructor
	
	public void showMenu(){
		System.out.println("\n[1]Registrar ingreso");
		System.out.println("[2]Cantidad de personas que intentaron ingresar");
		System.out.println("[3]Salir\n");
	}//End showMenu
	
	public void registerEntry(){
		int idNumber = 0;
		int day = 0;
		String idType = new String();
		boolean correct;
		do{
			System.out.println("Ingrese el dia actual: ");
			day = sc.nextInt();
			sc.nextLine();
			correct = day < 1 || day > 31;
			if(correct)
				System.out.println("Dia incorrecto.");
		}while(correct);
		do{
			System.out.println("Ingrese El tipo de documento: ");
			idType = sc.nextLine();
			correct = em.validateId(idType);
			if(!correct)
				System.out.println("El documento " + idType + " no es valido.");
		}while(!correct);
		System.out.print("Ingrese el numero de su documento: ");
		idNumber = sc.nextInt();
		sc.nextLine();
		try{
			em.registerEntry(idType, idNumber, day);
			System.out.println("Su documento es correcto, puede ingresar al establecimiento.");
		}catch(IncorrectIdNumberException e){
			System.out.println("Su numero de documento no es valido el dia de hoy.");
		}catch(InvalidIdTypeException e){
			System.out.println("No es posible atender a menores en este establecimiento.");
		}
	}//End registerEntry.
	public void showAmountToTryEntry(){
		System.out.println("El numero total de personas que han intentado ingresar es de " + em.getTryEntryAmount());
	}//End showAmountToTryEntry
	public void proccessOption(int opt){
		switch(opt){
		case REGISTERENTRY: registerEntry(); break;
		case SEEAMOUNTTOTRYENTRY: showAmountToTryEntry(); break;
		case EXIT: System.out.println("Vuelva pronto!!"); break;
		default: System.out.println("Opcion incorrecta.");
		}//End switch
	}//End proccessOption
	
	public void startProgram(){
		int opt = 0;
		do{
			showMenu();
			System.out.print("Ingrese la opcion: ");
			opt = sc.nextInt();
			sc.nextLine();
			proccessOption(opt);
		}while(opt != EXIT);
	}//End startProgram
}//End menu
