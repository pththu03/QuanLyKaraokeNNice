package test;

import javax.swing.*;

import com.toedter.calendar.JCalendar;

import util.DateFormatter;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class WeekCalendarApp {
	
	private static LocalDate ngayHT;
	private static LocalDate ngayThu2;
	private static LocalDate ngayThu3;
	private static LocalDate ngayThu4;
	
    public static void main(String[] args) {
    	ngayHT = LocalDate.now();
    	tuan();
    }
    
    private static void tuan() {
    	int ngayHTGT = ngayHT.getDayOfWeek().getValue();
    	System.out.println(ngayHTGT);
    }
    	
}
