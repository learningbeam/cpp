public class Solution {
     Hashtable<Integer,Integer> results = new Hashtable<Integer,Integer>();
    	
	 public  int climbStairs(int n) {
	        if(n<0)
	           return 0;
	         
	        if(n<=1){
	           results.put(n,1);
	           return 1;
              }
	        
	        Integer tmp=results.get(n);
	        if( tmp== null){
	           tmp = climbStairs(n-1)+climbStairs(n-2);
	           results.put(n,tmp);
	        }
	        return tmp;
	    }
	
}
