package com.sree.programs.important.askedininterviews;

import java.io.*;
import java.util.*;

// You are in charge of a display advertising program. Your ads are displayed on websites all over the internet. You have some CSV input data that counts how many times that users have clicked on an ad on each individual domain. Every line consists of a click count and a domain name, like this:

// counts = [ "900,google.com",
//      "60,mail.yahoo.com",
//      "10,mobile.sports.yahoo.com",
//      "40,sports.yahoo.com",
//      "300,yahoo.com",
//      "10,stackoverflow.com",
//      "20,overflow.com",
//      "2,en.wikipedia.org",
//      "1,m.wikipedia.org",
//      "1,mobile.sports",
//      "1,google.co.uk"]

// Write a function that takes this input as a parameter and returns a data structure containing the number of clicks that were recorded on each domain AND each subdomain under it. For example, a click on "mail.yahoo.com" counts toward the totals for "mail.yahoo.com", "yahoo.com", and "com". (Subdomains are added to the left of their parent domain. So "mail" and "mail.yahoo" are not valid domains. Note that "mobile.sports" appears as a separate domain near the bottom of the input.)

// Sample output (in any order/format):

// calculateClicksByDomain(counts) =>
// com:                     1340
// google.com:              900
// stackoverflow.com:       10
// overflow.com:            20
// yahoo.com:               410
// mail.yahoo.com:          60
// mobile.sports.yahoo.com: 10
// sports.yahoo.com:        50
// org:                     3
// wikipedia.org:           3
// en.wikipedia.org:        2
// m.wikipedia.org:         1
// mobile.sports:           1
// sports:                  1
// uk:                      1
// co.uk:                   1
// google.co.uk:            1

// n: number of domains in the input
// (individual domains and subdomains have a constant upper length)

//n - number of input
//k= worst case each string conats k subdomains
//Time --> O(n*k)
//Space --> 0(n*k)

// String[] counts = {

//       "900,google.com",
//       "60,mail.yahoo.com"}

import java.util.*;

public class RoboloxDomainsCount {
	public static void main(String[] argv) {
		String[] counts = { "900,google.com", "60,mail.yahoo.com", "10,mobile.sports.yahoo.com", "40,sports.yahoo.com",
				"300,yahoo.com", "10,stackoverflow.com", "20,overflow.com", "2,en.wikipedia.org", "1,m.wikipedia.org",
				"1,mobile.sports", "1,google.co.uk" };
		String[] counts1 = { "1,google.com", "2,mail.yahoo.com", "3,mobile.sports.yahoo.com", "4,sports.yahoo.com" };
		Map<String, Integer> countMap = getDomainCount(counts1);
		System.out.println("countMap=" + countMap.toString());
	}

	// google.com= 900
	// com=960
	// mail.yahoo.com=60
	// yahoo.com=60
	private static Map<String, Integer> getDomainCount(String[] counts) {
		Map<String, Integer> countMap = new HashMap<>();
		for (int index = 0; index < counts.length; index++) {
			String[] strArr = counts[index].split(",");
			int currentCount = Integer.valueOf(strArr[0]).intValue();
			String domain = strArr[1];

			List<String> subDomains = new LinkedList<>();
			getSubDomains(domain, subDomains);
			for (int i = 0; i < subDomains.size(); i++) {
				String currentDomain = subDomains.get(i);
				if (countMap.containsKey(currentDomain)) {
					countMap.put(currentDomain, countMap.get(currentDomain) + currentCount);
				} else {
					countMap.put(currentDomain, currentCount);
				}
			}
		}
		return countMap;
	}

	// "mail.yahoo.com",
	// "yahoo.com",
	// and "com"
	private static void getSubDomains(String domain, List<String> subDomains) {
		subDomains.add(domain);
		if (domain.contains(".")) {

			int dotIndex = domain.indexOf(".");
			// System.out.println("domain=" + domain);
			// System.out.println("dotIndex=" + dotIndex);
			String subString = domain.substring(dotIndex + 1, domain.length());
			// System.out.println("subString=" + subString);
			getSubDomains(subString, subDomains);
		}

	}

}
