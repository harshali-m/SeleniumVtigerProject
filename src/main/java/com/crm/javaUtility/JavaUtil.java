package com.crm.javaUtility;

import java.time.LocalDate;
import java.util.Random;

public class JavaUtil  {
	public static int generateRandomNumber(int limit)
	{
		Random r=new Random();
		return r.nextInt(limit);
	}
	public static String startDate()
	{
		LocalDate sdate=LocalDate.now();
		return sdate.toString();
	}
	public static String endDate()
	{
		LocalDate edate=LocalDate.now().plusDays(20);
		return edate.toString();
	}
	public static void main(String[] args) {
		System.out.println(startDate());
		System.out.println(endDate());
	}
}
