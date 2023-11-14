package util;

import java.text.DecimalFormat;

public class MoneyFormatter {
	public static String format(double tien) {
		return new String(new DecimalFormat("#,###.0 VND").format(tien));
	}
	
	public static String format1(double tien) {
		return new String(new DecimalFormat("#,###").format(tien));
	}
}
