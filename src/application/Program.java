package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// Fazer um programa para ler os dados de uma reserva de hotel

		Scanner sc = new Scanner(System.in);
		int quarto;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataIn = new Date();
		Date dataOut = new Date();
		Date now = new Date();
		System.out.print("Room number: ");
		quarto = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		dataIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		dataOut = sdf.parse(sc.next());
		if (!dataOut.after(dataIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reserva = new Reservation(quarto, dataIn, dataOut);
			System.out.println(reserva);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			dataIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			dataOut = sdf.parse(sc.next());
			
			
			System.out.println(now);
			if (dataIn.before(now) || dataOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} 
			else if (!dataOut.after(dataIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} 
			else {
				reserva.updateDates(dataIn, dataOut);
				System.out.println(reserva);
			}

		}

		sc.close();

	}

}
