package com.sree.leave.programs.sample;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentTest {
public static void main(String args[]) {
	Student s1=new Student(1,"A");
	Student s2=new Student(1,"A");
	Student s3=new Student(3,"C"); 
	Set <Student> studentList1=new HashSet<Student>();
	studentList1.add(s1);
	if(!studentList1.contains(s2)) {
		studentList1.add(s2);
	}
	System.out.println(studentList1);
}
public static void nonRepeatChar(String s) {
	char[] strArr=s.toCharArray();
	for(int i=0;i<strArr.length;i++) {
		boolean charRepeated=false;;
		for(int j=i+1;j<strArr.length;j++) {
			if(strArr[i]==strArr[j]) {
				charRepeated=true;
				break;
			}
		}
		if(!charRepeated) {
			System.out.println(strArr[i]);
			break;
		}
	}
	
}
}
