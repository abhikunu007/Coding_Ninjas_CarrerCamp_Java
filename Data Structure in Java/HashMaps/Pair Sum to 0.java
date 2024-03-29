// Pair Sum to 0
// Send Feedback
// Given a random integer array A of size N. Find and print the count of pair of elements in the array which sum up to 0.
// Note: Array A can contain duplicate elements as well.
// Input format:
// The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
// The following line contains N space separated integers, that denote the value of the elements of the array.
// Output format :
// The first and only line of output contains the count of pair of elements in the array which sum up to 0. 
// Constraints :
// 0 <= N <= 10^4
// Time Limit: 1 sec
// Sample Input 1:
// 5
// 2 1 -2 2 3
// Sample Output 1:
// 2


import java.util.*;

public class Solution {
	public static int PairSum(int[] input, int size) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
        
         HashMap<Integer, Integer> map = new HashMap<>();
        // mapping the all array element and their frequency
        for(int i =0; i< input.length; i++){
            if(map.containsKey(input[i]) ){
                map.put(input[i], map.get(input[i])+1);
            }else{
                map.put(input[i],1);
            }
        }
        
        // counting the pair sum == 0
        // take care of if all elements is {0, 0, 0, 0, 0, 0, 0} like this
        int countPair = 0;
        for(int i =0 ; i<input.length; i++){
           
            if( input[i] != 0){
              if(map.containsKey(-input[i]) && (map.get(-input[i]) > 0)){
                    countPair += map.get(-input[i]);
                    map.remove(input[i]);
              }   
            }else{
                if(map.get(input[i]) > 1){
                    countPair += map.get(input[i]) -1;
                    map.put(input[i], map.get(input[i]) -1); 
                }
            }  
        }	
        return countPair;
	}
}
