package test;

import java.time.LocalTime;

import util.PasswordHasher;
import util.TimeFormatter;

public class TestPass {
	public static void main(String[] args) {
		LocalTime gioBD = LocalTime.of(4, 6);
		System.out.println(TimeFormatter.format(gioBD));
	}

}
