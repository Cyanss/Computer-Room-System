package com;
import java.text.SimpleDateFormat;
import java.util.Date;
public class SetTime {
	private static String date;
	private static String data;
	public SetTime(){
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
    	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy Äê MM ÔÂ dd ÈÕ");  
    	 setDate(sdf1.format(d));
    	 setData(sdf.format(d));
	}
	public String getData() {
		return data;
	}
	public static void setData(String data) {
		SetTime.data = data;
	}
	public String getDate() {
		return date;
	}
	public static void setDate(String date) {
		SetTime.date = date;
	}
}
