package com.sree.leave.programs.important;

public class SmallSquare {
    public void solve(int n) {
      int options = (int) Math.sqrt(n);
      //solve using recursion
      System.out.println("Minimum Numbers are Required Whose Square Sum is Equal To a "+n+": " + solveRecursively(n, options));
    }

    public int solveRecursively(int n, int options) {
    	System.out.println("n="+n+"options="+options);
      if (n <= 0) {
        return 0;
      }
      int min = solveRecursively(n - 1 * 1, options);
      for (int i = 2; i <= options; i++) {
        if (n >= i * i) {
          min = Math.min(min, solveRecursively(n - i * i, options));
        }
      }
      return min + 1;
    }
    	public static void main(String[] args) {
		int N = 12;
		SmallSquare s = new SmallSquare();
		s.solve(N);
	}

}
