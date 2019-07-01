import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReportPrinter {

	private DataAnalysis analysis;
	
	public ReportPrinter(DataAnalysis analysis) {
		this.analysis = analysis;
	}
	
	public void createAlivePassengersReport() {
		try {
			FileWriter fileWriter = new FileWriter("passengersAlive.txt");
			PrintWriter out = new PrintWriter(fileWriter);
			for (Passenger passenger : analysis.getAlivePassengers()) {
				out.write(passenger.getName() + "\n");
			}
			out.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createDeceasedPassengersReport() {
		try {
			FileWriter fileWriter = new FileWriter("passengersDeceased.txt");
			PrintWriter out = new PrintWriter(fileWriter); // PrintWriter -based on-> FileWriter
			for (Passenger passenger : analysis.getDeceasedPassengers()) {
				out.write(passenger.getName() + "\n");
			}
			out.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createFareReport() {
		try {
			FileWriter fileWriter = new FileWriter("fareReport.txt");
			PrintWriter out = new PrintWriter(fileWriter);
			double min = Double.MAX_VALUE; // 2^32 very large + number
			for (Passenger passenger : analysis.getPassengers()) {
				out.printf("%.2f\n", passenger.getFare());
				if (passenger.getFare() < min) // 200 < 3000 // min= 200
					min = passenger.getFare();
			}
			out.printf("Min: %.2f", min);
			out.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}