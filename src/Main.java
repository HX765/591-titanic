import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		DataAnalysis analysis = new DataAnalysis(PassengerReader.readCSV());
		ArrayList<Passenger> passengers = analysis.getPassengers();
		ArrayList<Passenger> alivePassengers = analysis.getAlivePassengers();
		ArrayList<Passenger> deceasedPassengers = analysis.getDeceasedPassengers();
		
		double avgAliveAge = DataAnalysis.getAvgAge(alivePassengers);
		double medianAliveAge = DataAnalysis.getMedianAge(alivePassengers);
		System.out.printf("Average age of survivors: %.1f", avgAliveAge);
		System.out.println();
		System.out.println("Median age of survivors: " + medianAliveAge);

		double avgDeceasedAge = DataAnalysis.getAvgAge(deceasedPassengers);
		double medianDeceasedAge = DataAnalysis.getMedianAge(deceasedPassengers);
		System.out.println();
		System.out.printf("Average age of deceased: %.1f", avgDeceasedAge);
		System.out.println();
		System.out.println("Median age of deceased: " + medianDeceasedAge);
		
		double avgFare1stClass = DataAnalysis.getAvgFareByFareClass(passengers, 1);
		double avgFare2ndClass = DataAnalysis.getAvgFareByFareClass(passengers, 2);
		double avgFare3rdClass = DataAnalysis.getAvgFareByFareClass(passengers, 3);
		double avgFare = DataAnalysis.getAvgFareByFareClass(passengers, -1);
		System.out.println();
		System.out.printf("Average fare of 1st class passengers: %.1f", avgFare1stClass);
		System.out.println();
		System.out.printf("Average fare of 2nd class passengers: %.1f", avgFare2ndClass);
		System.out.println();
		System.out.printf("Average fare of 3rd class passengers: %.1f", avgFare3rdClass);
		System.out.println();
		System.out.printf("Average fare of all passengers: %.1f", avgFare);
		
		
		ReportPrinter report = new ReportPrinter(analysis);
		report.createAlivePassengersReport();
		report.createDeceasedPassengersReport();
		report.createFareReport();
	}
}