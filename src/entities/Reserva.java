package entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Reserva {
	
	public static Calendar cal = Calendar.getInstance();
	
	private Integer numeroQuarto;
	private Date entrada;
	private Date saida;
	
	
	public SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public Reserva() {
	}

	public Reserva(Integer numeroQuarto, Date entrada, Date saida) {
		this.numeroQuarto = numeroQuarto;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getEntrada() {
		return entrada;
	}

	/*public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}*/

	public Date getSaida() {
		return saida;
	}

	/*public void setSaida(Date saida) {
		this.saida = saida;
	}*/

	public int duracao() {
		cal.setTime(entrada);
		int diasEntrada = cal.get(Calendar.DAY_OF_YEAR);
		cal.setTime(saida);
		int diasSaida = cal.get(Calendar.DAY_OF_YEAR);
		return diasSaida - diasEntrada;
	}
	
	public void updateDates(Date entrada, Date saida) {
		int duracao = 0;
		cal.setTime(entrada);
		int diasEntrada = cal.get(Calendar.DAY_OF_YEAR);
		cal.setTime(saida);
		int diasSaida = cal.get(Calendar.DAY_OF_YEAR);
		duracao = diasSaida - diasEntrada;
		System.out.println(duracao);
	}
	
	/*public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Reservation: Room ");
		sb.append(this.getNumeroQuarto());
		sb.append(", check-in: ");
		sb.append(sdf.format(this.getEntrada()));
		sb.append(", check-out: ");
		sb.append(sdf.format(this.getSaida()));
		sb.append(", ");
		sb.append(duracao()+" nights");
		return sb.toString();
	}*/
}
