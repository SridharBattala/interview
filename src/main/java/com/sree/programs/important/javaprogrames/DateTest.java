package com.sree.programs.important.javaprogrames;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTest {
public static void main(String args[]) {
	Date transactionDate = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy'T'HH:mm:ssZ");
	System.out.println("DATE1=" + sdf.format(transactionDate));
	sdf.setTimeZone(TimeZone.getTimeZone("US/Eastern"));
	System.out.println("DATE2=" + sdf.format(transactionDate));
}
}
