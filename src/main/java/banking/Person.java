package banking;

public class Person extends AccountHolder {
	private String firstName;
	private String lastName;

	public Person(String firstName, String lastName, int idNumber) {
		super(idNumber);
		this.firstName = firstName;
		this.lastName = lastName;
		// complete the function
	}

	public String getFirstName() {

		return firstName;
	}

	public String getLastName() {

		return lastName;
	}
}
