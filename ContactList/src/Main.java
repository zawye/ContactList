
/**
 * This class presents user with a list of options that allow him/her to
 * use a Contact List.
 */
import java.util.*;
public class Main {
	public static void main(String[] args)  {
	List list;
	list = new List();
	Scanner scanner;
	scanner = new Scanner (System.in);
	System.out.println("Welcome to Contact list.\n");
	while (list.checkQuit()==false){
		System.out.println("\n1.\tEnter a new person into the contact list.");
		System.out.println("2.\tPrint the contact list.");
		System.out.println("3.\tRetrieve a person's information by last name.");
		System.out.println("4.\tQuit the program and save to disk.");
		System.out.println("5.\tStart the program and open the existing data file on disk.\n");
		System.out.println("Please make a selection. ");
		list.userChoices(scanner.nextInt());
	}
	scanner.close();
	}
}
