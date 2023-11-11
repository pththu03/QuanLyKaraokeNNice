package test;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class Test {
	public static void main(String[] args) {
		LocalTime gio1 = LocalTime.now();
		LocalTime gio2 = LocalTime.of(11, 6);

		System.out.println(gio1);
		System.out.println(gio2);
		System.out.println(tinhSoPhut(gio1, gio2));
		System.out.println(tinhSoGio(gio1, gio2));
		System.out.println(tinhSoPhut(gio1, gio2)/60.0);
		System.out.println((tinhSoPhut(gio1, gio2)/60.0)*45000);
	}

	public static int tinhSoPhut(LocalTime gio1, LocalTime gio2) {
		return (int) gio1.until(gio2, ChronoUnit.MINUTES);
	}

	public static int tinhSoGio(LocalTime gio1, LocalTime gio2) {
		return (int) gio1.until(gio2, ChronoUnit.HOURS);
	}
}
