import java.util.ArrayList;
import java.util.Collections;

public class DataAnalysis {
	
	private ArrayList<Passenger> passengers;
	
	public DataAnalysis(ArrayList<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	/**
	 * @return the passengers
	 */
	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}
	
	public ArrayList<Passenger> getAlivePassengers() {
		ArrayList<Passenger> results = new ArrayList<Passenger>();
		for (Passenger passenger : passengers) {
			if (passenger.survived()) {
				results.add(passenger);
			}
		}
		return results;
	}
	
	public ArrayList<Passenger> getDeceasedPassengers() {
		ArrayList<Passenger> results = new ArrayList<Passenger>();
		for (Passenger passenger : passengers) {
			if (!passenger.survived()) {
				results.add(passenger);
			}
		}
		return results;
	}
	
	public static double getAvgAge(ArrayList<Passenger> passengers) {
		double sum = 0;
		int count = 0;
		for (Passenger passenger : passengers) {
			if (passenger.getAge() >= 0) { // Passengers without age info have it set to -1
				sum += passenger.getAge();
				count++;
			}
		}
		return sum / count;
	}
	
	public static double getMedianAge(ArrayList<Passenger> passengers) {
		ArrayList<Integer> ages = new ArrayList<Integer>();
		for (Passenger passenger : passengers) {
			if (passenger.getAge() >= 0) // natural age
				ages.add(passenger.getAge());
		}
		// arraylist of valid ages
		Collections.sort(ages);
		// 0 1 2 // len = 3
		// 3 / 2 = 1 middle
		// 0 1 2 3 // len = 4
		// 4 / 2 = 2 right middle
		if (ages.size() % 2 == 1) // odd
			return ages.get(ages.size() / 2);
		else { // even
			if (ages.size() == 0)
				return 0;
			else
				return (ages.get(ages.size() / 2) + ages.get((ages.size() / 2) - 1)) / 2.0;
		}
	}
	
	public static double getAvgFareByFareClass(ArrayList<Passenger> passengers, int fareClass) {
		double sum = 0;
		int count = 0;
		for (Passenger passenger : passengers) {
			if (fareClass == -1) {
				sum += passenger.getFare();
				count++;
			} else {
				if (passenger.getFareClass() == fareClass) {
					sum += passenger.getFare();
					count++;
				}
			}
		}
		return sum / count;
	}
}