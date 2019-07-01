import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PassengerReader {
	
	public static ArrayList<Passenger> readCSV() {
		ArrayList<Passenger> passengers = new ArrayList<Passenger>();
		File titanicFile = new File("titanic.csv");
		try {		
			Scanner fileReader = new Scanner(titanicFile);
			fileReader.nextLine(); // Skip the title row
			while(fileReader.hasNextLine()) {
				String line = fileReader.nextLine();
				String[] lineComponents = line.split(","); //****
				int id = Integer.parseInt(lineComponents[0]);
				boolean survived = (lineComponents[1].equals("1"));
				int fareClass = Integer.parseInt(lineComponents[2]);
				String name = lineComponents[3] + ", " + lineComponents[4];
				String gender = lineComponents[5].toLowerCase();
				int age = -1;
				// class A (main) -depends-> classB
				// in B you throw exception, in A catch
				try {
					age = Integer.parseInt(lineComponents[6]);
				} catch(NumberFormatException e) {
					
				}
				String ticketNumber = lineComponents[9];
				double fare = Double.parseDouble(lineComponents[10]);
				Passenger passenger = new Passenger(id, name, gender, age, fareClass, ticketNumber, fare, survived);
				passengers.add(passenger);
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return passengers;
	}
}