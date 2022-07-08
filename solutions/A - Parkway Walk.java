import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


// https://codeforces.com/problemset/problem/1697/A

public class ParkwayWalk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyScanner sc = new MyScanner();
	      out = new PrintWriter(new BufferedOutputStream(System.out));
	      int tests = sc.nextInt();
	      for (int t = 0; t < tests; t++) {
	    	  int n = sc.nextInt();
	    	  int m = sc.nextInt();
	    	  int arr[] = new int[n];
	    	  int sum = 0, minRestore = 0;
	    	  
	    	  for (int i = 0; i < n; i++) {
	    		  arr[i] = sc.nextInt();
	    		  sum += arr[i];
	    	  }
	    	  if (m > sum) {
	    		  out.println(minRestore);
	    	  } else {
	    		  boolean flag = true;
	    		  for (int i = 0; i < n && flag; i++) {
	    			  if (m > arr[i]) {
	    				  m -= arr[i];
	    				  sum -= arr[i];
	    			  } else {
	    				  minRestore = sum - m;
	    				  flag = false;
	    			  }
	    		  }
	    		  out.println(minRestore);
	    	  }
	    	  
	      }
	      
	      out.close();
	}
	
	
	 // The following code was taken from: https://codeforces.com/blog/entry/7018
	   //-----------PrintWriter for faster output---------------------------------
	   public static PrintWriter out;
	      
	   //-----------MyScanner class for faster input----------
	   public static class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	 
	      public MyScanner() {
	         br = new BufferedReader(new InputStreamReader(System.in));
	      }
	 
	      String next() {
	          while (st == null || !st.hasMoreElements()) {
	              try {
	                  st = new StringTokenizer(br.readLine());
	              } catch (IOException e) {
	                  e.printStackTrace();
	              }
	          }
	          return st.nextToken();
	      }
	 
	      int nextInt() {
	          return Integer.parseInt(next());
	      }
	 
	      long nextLong() {
	          return Long.parseLong(next());
	      }
	 
	      double nextDouble() {
	          return Double.parseDouble(next());
	      }
	 
	      String nextLine(){
	          String str = "";
		  try {
		     str = br.readLine();
		  } catch (IOException e) {
		     e.printStackTrace();
		  }
		  return str;
	      }

	   }
	   //--------------------------------------------------------
}


