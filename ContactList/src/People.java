/**
 * An object of this class represents a person's contact information.
 */
import java.util.*;
public class People implements Comparable<People>{

	private String firstName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	private String email;
	private String phone;
	private String notes;

	
	public int compareTo(People o1) {
        return this.lastName.compareTo(((People) o1).getLastName()) ; // or whatever property you want to sort
    }
	/**
	 * This constructors initializes all private member String variables to "".
	 */
	public People() {
		firstName = "";
		lastName = "";
		streetAddress = "";
		city = "";
		state = "";
		zipCode = "";
		email = "";
		phone = "";
		notes = "";
	}
	
	/**
	 * Saves a contact's information.
	 */
	public void saveContact() {
		Scanner scanner;
		scanner = new Scanner (System.in);
		//Scanner scanner2 = new Scanner (System.in);
		System.out.print("First name:");
		firstName=scanner.nextLine();
		System.out.print("Last name (required):");
		lastName=scanner.nextLine();
		//String buffer=scanner.nextLine();
		if (lastName.equalsIgnoreCase("")) {
			System.out.println("Contact not saved.");
		}
		else {
			System.out.print("Street Address:");
			streetAddress=scanner.nextLine();
			System.out.print("City:");
			city=scanner.nextLine();
			System.out.print("State:");
			state=scanner.nextLine();
			System.out.print("Zip Code:");
			zipCode=scanner.nextLine();
			System.out.print("Email:");
			email=scanner.nextLine();
			System.out.print("Phone Number:");
			phone=scanner.nextLine();
			System.out.print("Notes:");
			notes=scanner.nextLine();
		}
	}
	
	/**
	 * Returns the contact's last name.
	 */
		public String getLastName() {
			return lastName;
		}	
	
/**
 * Returns a String of a person's contact information.	
 */
	public String toString() {
		return "\n" + "First Name: " + firstName + "\n" + "Last Name: " + lastName + "\n" + "Street Address: " + streetAddress +"\n" + "City: " + city + "\n" + "State: " + state + "\n"
				+ "Zip Code: " + zipCode + "\n" + "Email: " + email + "\n" + "Phone number: " + phone + "\n" + "Notes: " + notes + "\n";
	}
}
