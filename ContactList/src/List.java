
/**
 * An Object of this class represents an array of People Objects.
 */
import java.io.*;
import java.util.*;
public class List {
	private People[] people;
	private boolean quit=false;
	private static int count = 0;
/**
 * Constructs an array of 100 People objects.	
 */
	public List () {
	people = new People[99];
	}

/**
 * Presents a user with various choices that manipulate a contact list.	
 */
	public void userChoices(int num) {
		switch (num) {
		case 1:		saveContact();
					break;
		case 2: 	System.out.println(toString());
					break;
		case 3: 	System.out.println(findContact());
					break;
		case 4: 	saveAndquit();
					break;
		case 5: 	restartAndLoad();
					break;
		default: 	System.out.println("Please choose a valid number choice.");
					break;
		}
	}

/**
 * Save a contact's information.	
 */
	public void saveContact() {
		people[count] = new People ();
		people[count].saveContact();
		if (people[count].getLastName().equalsIgnoreCase("")) {
			people[count] = new People ();
		}
		else {
			count++;
		}
	}

/**
 * Prints out the whole contact list.
 */
	public String toString(){
		String output = "";
		/*Arrays.sort(people);/*, new Comparator<People>() {
			@Override
		    public int compare(People o1, People o2) {
		        return o1.getLastName().compareTo(o2.getLastName());
		    }
		});*/
		for (int i =0; i< count;i++) {
			output = output + people[i];
		}
		return output;
	}
/**
 * Allows a user to look up a contact's information based on last name.
 */
	public String findContact() {
		Scanner scanner;
		scanner = new Scanner (System.in);
		String searchString;
		String printOut = "";
		System.out.print("Last name? ");
		searchString=scanner.next();
		for (int j=0; j<count;j++) {
			if (people[j].getLastName().equals(searchString)){
				printOut = printOut + "\n" + people[j].toString();
			}
		}
		if (printOut==""){
			printOut= "Search returned 0 result.";
		}
		return printOut;
	}
/**
 * Check to see if program needs to quit.	
 */
	public boolean checkQuit(){
		return quit;
	}
/**
 * Save the contact and quit the program.	
 */
	public void saveAndquit() {
		 FileOutputStream outFile;

	     ObjectOutputStream outObject;

	     try  {

	         outFile = new FileOutputStream ("data.ser");     

	         outObject = new ObjectOutputStream(outFile);
	         //for (int j = 0; j<count; j++){
	         outObject.writeObject(people);
	         //}
	         outFile.close();
	         outObject.close(); 
    
	      } catch (IOException ioe)  {
	         System.out.println ("Error writing objects to the file: "+ ioe.getMessage());
	      }
		quit=true;
	}
/**
 * Restart the program and loads saved contacts.	
 */
	public void restartAndLoad() {
		FileInputStream inFile;
		ObjectInputStream inObject;

	      try  {

	         inFile = new FileInputStream("data.ser");     

	         inObject = new ObjectInputStream(inFile);
	         //for (int k = 0; k<count;k++){
	         people= (People[])inObject.readObject();
	         //}

	         inFile.close();

	         inObject.close();     

	      } catch(IOException ioe)  {

	         System.out.println ("Error reading from the file: " + ioe.getMessage());

	      } catch (ClassNotFoundException cnfe)  {

	         System.out.println ("Error in casting to People: " + cnfe);

	      }
	}
}
