public class Passenger {
	
	private int id;
	private String name;
	private String gender;
	private int age;
	private int fareClass;
	private String ticketNumber;
	private double fare;
	private boolean survived;
	
	public Passenger(int id, String name, String gender, int age, int fareClass, String ticketNumber, double fare,
			boolean survived) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.fareClass = fareClass;
		this.ticketNumber = ticketNumber;
		this.fare = fare;
		this.survived = survived;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return the fareClass
	 */
	public int getFareClass() {
		return fareClass;
	}

	/**
	 * @return the ticketNumber
	 */
	public String getTicketNumber() {
		return ticketNumber;
	}

	/**
	 * @return the fare
	 */
	public double getFare() {
		return fare;
	}

	/**
	 * @return the survived
	 */
	public boolean survived() {
		return survived;
	}
}