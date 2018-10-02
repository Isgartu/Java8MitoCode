package com.isgartu.java8isgartu;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * Date api
 * 
 * https://www.youtube.com/watch?v=ExDzrB13r-M&index=14&list=PLvimn1Ins-419yVe5iPfiXrg4mZJl5kLS
 *
 */
public class LambdaApp14 {

	public void verificar(int version) {
		if(version == 7) {
			//Las fechas en las versiones de Java 7 y anteriores
			Calendar fecha1 = Calendar.getInstance();
			Calendar fecha2 = Calendar.getInstance();
			fecha1.set(1999, 0, 21);
			System.out.println(fecha1.after(fecha2));
		} else if (version == 8) {
			//En Java 8 es mas sencillo
			//Solo fecha -> anno, mes, dia
			LocalDate fecha1 = LocalDate.of(1991, 01, 21);
			LocalDate fecha2 = LocalDate.now();
			System.out.println(fecha1.isAfter(fecha2));
			System.out.println(fecha1.isBefore(fecha2));
			
			//Solo tiempo -> horas, minutos, segundos
			LocalTime tiempo1 = LocalTime.of(22, 30, 50);
			LocalTime tiempo2 = LocalTime.now();
			System.out.println(tiempo1.isAfter(tiempo2));
			System.out.println(tiempo1.isBefore(tiempo2));
			
			//Fecha y Horas -> anno, mes, dia, horas, minutos, segundos
			LocalDateTime fechaTiempo1 = LocalDateTime.of(1991, 01, 21, 22, 30, 50);
			LocalDateTime fechaTiempo2 = LocalDateTime.now();
			System.out.println(fechaTiempo1.isAfter(fechaTiempo2));
			System.out.println(fechaTiempo1.isBefore(fechaTiempo2));
		}
	}
	
	public void medirTiempo(int version) throws InterruptedException {
		if(version == 7) {
			long ini = System.currentTimeMillis();
			Thread.sleep(1000);
			long fin = System.currentTimeMillis();
			System.out.println(fin - ini);
		} else if (version == 8) {
			Instant ini = Instant.now();
			Thread.sleep(1000);
			Instant fin = Instant.now();
			System.out.println(Duration.between(ini, fin));
			//Podemos convertirlo a dias, segundos....
			System.out.println(Duration.between(ini, fin).toMillis());
		}
	}
	
	public void periodoEntreFechas(int version) {
		if (version == 7) {
			Calendar nacimiento = Calendar.getInstance();
			Calendar actual = Calendar.getInstance();
			
			nacimiento.set(1990, 0, 21);
			actual.set(2018, 10, 02);
			
			int anios = 0;
			
			while(nacimiento.before(actual)) {
				nacimiento.add(Calendar.YEAR, 1);
				if (nacimiento.before(actual)) {
					anios++;
				}
			}
			System.out.println(anios);
		} else if (version == 8){
			LocalDate nacimiento = LocalDate.of(1990, 1, 21);
			LocalDate actual = LocalDate.now();
			
			Period periodo = Period.between(nacimiento, actual);
			System.out.println("Han transcurrido: " + periodo.getYears() + " anios y " + periodo.getMonths() 
			+ " meses y " + periodo.getDays() + " dias, desde " + nacimiento + " hasta " + actual);
		}
	}
	
	public void convertir(int version) throws ParseException {
		if (version == 7) {
			String fecha = "21/01/1990";
			DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
			Date fechaConvertida = formateador.parse(fecha);
			System.out.println(fechaConvertida);
			
			Date fechaActual = Calendar.getInstance().getTime();
			formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
			String fechaCadena = formateador.format(fechaActual);
			System.out.println(fechaCadena);
		} else if (version == 8) {
			String fecha = "21/01/1990";
			DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate fechaLocal = LocalDate.parse(fecha, formateador);
			System.out.println(fechaLocal);
			System.out.println(formateador.format(fechaLocal));
			
			formateador = DateTimeFormatter.ofPattern("ddMMyyyy");
			System.out.println(formateador.format(fechaLocal));
		}
	}

	public static void main(String[] args) {
		LambdaApp14 app = new LambdaApp14();
		
		try {
			//app.verificar(8);
			//app.medirTiempo(8);
			//app.periodoEntreFechas(8);
			app.convertir(8);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
