package com.sree.programs.important.amazonquestions;

import java.util.*;
import java.util.Map.Entry;

public class EmployeeHeirarchy {
	static Map<String, List<String>> managerToEmpMap = new HashMap<>();

	public static void main(String[] args) {
		Map<String, String> dataSet = new HashMap<String, String>();
		dataSet.put("A", "C");
		dataSet.put("B", "C");
		dataSet.put("C", "F");
		dataSet.put("D", "E");
		dataSet.put("E", "F");
		dataSet.put("F", "F");

		populateResult(dataSet);
	}

	private static void populateResult(Map<String, String> dataSet) {
		// create manager to emp list map
		for (Map.Entry<String, String> entry : dataSet.entrySet()) {

			managerToEmpMap.put(entry.getKey(), new LinkedList<>());

		}

		for (Map.Entry<String, String> entry : dataSet.entrySet()) {

			managerToEmpMap.get(entry.getValue()).add(entry.getKey());

		}
		System.out.println("managerToEmpMap=" + managerToEmpMap.toString());
		Map<String, Integer> managerToEmpCountMap = new HashMap<>();

		// loop manager to emp list map
		for (Map.Entry<String, List<String>> entry : managerToEmpMap.entrySet()) {
			int count = getEmpCount(entry.getValue());
			managerToEmpCountMap.put(entry.getKey(), count);
		}
		System.out.println("managerToEmpCountMap=" + managerToEmpCountMap.toString());
	}

	private static int getEmpCount(List<String> empList) {
		int currentCount = 0;
		if (empList != null && !empList.isEmpty()) {
			currentCount = currentCount + empList.size();
			for (String emp : empList) {

				return currentCount + getEmpCount(managerToEmpMap.get(emp));
			}
		}
		return currentCount;

	}
}
