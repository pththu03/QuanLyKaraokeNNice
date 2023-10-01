package util;

import java.time.LocalTime;

public class TimeFormatter {
	public static String format(LocalTime time) {
		String gioHienTai = String.valueOf(time.getHour());
		String phutHienTai = String.valueOf(time.getMinute());

		if (time.getHour() < 10) {
			gioHienTai = "0" + gioHienTai;
		}
		
		if (time.getMinute() < 10) {
			phutHienTai = "0" + phutHienTai;
		}
		
		return gioHienTai + ":" + phutHienTai;
	}

}
