package com.sree.leave.programs.important;

import java.util.List;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

class EmployeeNode {
	int empId;
    String name;
    int reportToId;
    List<EmployeeNode> subordinates;
    
    public EmployeeNode(String id,  String empName, String rid) {    
    	try {
	        this.empId = Integer.parseInt(id);	        
	        this.name = empName;
	        this.reportToId = Integer.parseInt(rid);
    	}  catch (Exception e) {
			 System.err.println("Exception creating employee:" + e);
		}
    }

    List<EmployeeNode> getSubordinates() {
        return subordinates;
    }
    
    void setSubordinates(List<EmployeeNode> subordinates) {
        this.subordinates = subordinates;
    }
    
    int getId() {
        return empId;
    }

    void setId(int id) {
        this.empId = id;
    }
    
    String getName() {
        return name;
    }

    void setName(String n) {
        name = n;
    }

    int getReportToId() {
        return reportToId;
    }
}

public class ReportToHierarchy {
	static Map<Integer, EmployeeNode> employees;
	static EmployeeNode root;
	    
	 public static void main(String[] args) throws IOException {
		    employees = new HashMap<Integer, EmployeeNode>();
	        readDataAndCreateMap();
	        buildHierarchyTree(root);
	        printHierarchyTree(root, 0);
	 }
	 
	private static void readDataAndCreateMap() throws IOException {
		
		EmployeeNode e1 = new EmployeeNode("1","sridhar","0");
		EmployeeNode e2 = new EmployeeNode("2","balaji","3");
		EmployeeNode e3 = new EmployeeNode("3","ashok","1");
		EmployeeNode e4 = new EmployeeNode("4","krishna","2");
		EmployeeNode e5 = new EmployeeNode("5","ravi","3");
		EmployeeNode e6 = new EmployeeNode("6","sravan","1");
		EmployeeNode e7 = new EmployeeNode("7","rashmi","5");
		EmployeeNode e8 = new EmployeeNode("8","naresh","2");	 
		employees.put(e1.getId(), e1);
		employees.put(e2.getId(), e2);
		employees.put(e3.getId(), e3);
		employees.put(e4.getId(), e4);
		employees.put(e5.getId(), e5);
		employees.put(e6.getId(), e6);
		employees.put(e7.getId(), e7);		
		employees.put(e8.getId(), e8);
		
	    root = e1;
				 
	 }
	//build tree recursively
		 private static void buildHierarchyTree(EmployeeNode localRoot) {
			EmployeeNode employee = localRoot;
			List<EmployeeNode> subordinates = getSubordinatesById(employee.getId());
			employee.setSubordinates(subordinates);
	        if (subordinates.size() == 0) {
	            return;
	        }

	        for (EmployeeNode e : subordinates) {
	        	buildHierarchyTree(e);
	        }
		 }
		 
	 //scan whole employee hashMap to form a list of subordinates for the given id
	 private static List<EmployeeNode> getSubordinatesById(int rid) {
		 List<EmployeeNode> subordinates = new ArrayList<EmployeeNode>();
		 for (EmployeeNode e : employees.values()) {
           if (e.getReportToId() == rid) {
           	subordinates.add(e);
           }
		 }
		 return subordinates;
	 }
	 	 
	 
	 
	 //print tree recursively
	 private static void printHierarchyTree(EmployeeNode localRoot, int level) {
		 for (int i = 0; i < level; i++) {
			 System.out.print("\t");
		 }		 
		 System.out.println(localRoot.getName());
		 
		 List<EmployeeNode> subordinates = localRoot.getSubordinates();
		 System.out.print(" ");
		 for (EmployeeNode e : subordinates) {
			 printHierarchyTree(e, level + 1);
		 }
	 }
}