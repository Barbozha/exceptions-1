package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program01 {

	public static void main(String[] args) {
		// Fazer um programa para ler os dados de uma reserva de hotel

		Scanner sc = new Scanner(System.in);
		int quarto;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataIn = new Date();
		Date dataOut = new Date();

		try {
			System.out.print("Room number: ");
			quarto = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			dataIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			dataOut = sdf.parse(sc.next());
	
			Reservation reserva = new Reservation(quarto, dataIn, dataOut);
			System.out.println(reserva);
	
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			dataIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			dataOut = sdf.parse(sc.next());
	
			reserva.updateDates(dataIn, dataOut);
			System.out.println(reserva);
		}
		catch(ParseException e) {
			System.out.println("Invalid date format");
		}
		catch(DomainException e) {
			System.out.println("Error in Reservatuion " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro Inesperado!");
		}
		sc.close();

	}

}
