package com.sree.leave.programs.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeastCommonManagerAE {

  // O(n) time | O(d) space - where n is the number of people
  // in the org and d is the depth (height) of the org chart
  public static OrgChart getLowestCommonManager(
      OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
    return getOrgInfo(topManager, reportOne, reportTwo).lowestCommonManager;
  }

  public static OrgInfo getOrgInfo(OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {
    int numImportantReports = 0;
    for (OrgChart directReport : manager.directReports) {
      OrgInfo orgInfo = getOrgInfo(directReport, reportOne, reportTwo);
      if (orgInfo.lowestCommonManager != null) {
    	  return orgInfo;
      }
      numImportantReports += orgInfo.numImportantReports;
    }
    if (manager == reportOne || manager == reportTwo) numImportantReports++;
    OrgChart lowestCommonManager = numImportantReports == 2 ? manager : null;
    OrgInfo newOrgInfo = new OrgInfo(lowestCommonManager, numImportantReports);
    return newOrgInfo;
  }

  static class OrgChart {
    public char name;
    public List<OrgChart> directReports;

    OrgChart(char name) {
      this.name = name;
      this.directReports = new ArrayList<OrgChart>();
    }

    // This method is for testing only.
    public void addDirectReports(OrgChart[] directReports) {
      for (OrgChart directReport : directReports) {
        this.directReports.add(directReport);
      }
    }
  }

  static class OrgInfo {
    public OrgChart lowestCommonManager;
    int numImportantReports;

    OrgInfo(OrgChart lowestCommonManager, int numImportantReports) {
      this.lowestCommonManager = lowestCommonManager;
      this.numImportantReports = numImportantReports;
    }
  }
  public static void main(String args[]) {
	  OrgChart a=new OrgChart('a');
	  OrgChart b=new OrgChart('b');
	  OrgChart c=new OrgChart('c');
	  OrgChart d=new OrgChart('d');
	  OrgChart e=new OrgChart('e');
	  OrgChart f=new OrgChart('f');
	  OrgChart g=new OrgChart('g');
	  a.addDirectReports(new OrgChart[]{b,c});
	  b.addDirectReports(new OrgChart[]{d,e,f});
	  c.addDirectReports(new OrgChart[]{g});
	  System.out.println(getLowestCommonManager(a,e,f).name);
  }
}



