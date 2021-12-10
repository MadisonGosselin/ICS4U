/*****************************************************************
**  Name: Madison Gosselin                        		        **
**  Class Name: HardRecursive.java                       	    **
**  Creation Date: 12-09-2021                     		        **
**  Description: This is a program that uses a method  	        **
**               to find if it is possible to get a specific    **
**				 sum using elements in an array that are not   **
**				 adjacent using recursion 						**
*****************************************************************/

import java.io.*;			//import java libraries
import java.util.Arrays;	//import libraries to print arrays

public class HardRecursive{
	public static void main(String[] args) throws IOException {
		
		int[] input = new int[] {5, 10, 0, 1, 3};	//create a variable to hold the input array
		int start = 0;								//create a variable that holds the start pos
		int sum = 0;								//create a variable that holds the sum to reach
        printReportTitle("Recursive Problem #4");  	//send the title to the printReportTitle method
		
		System.out.print("Array to Test: " + Arrays.toString(input) + "  Target: " + sum + "   Result: " + adjTest(start, input, sum));			//print out a report of the inputs and output of the method
		
	} //end main method
	
	/**********************************************************
	**  Method Name: adjTest()                    			 **
	**  Inputs: an array of integers      					 **
	**  Returns: boolean if successful					     **
	**  Description: Takes in an array and find if a sum can **
	**               be made without using adjacent nums and ** 
	**				 using recursion						 **
	**********************************************************/
	
	public static boolean adjTest(int start, int[] nums, int target) {
		
		if(start >= nums.length) return (target == 0);		//check if your start is greater then length, if so return if target is == 0 or not (base case)
		return adjTest(start + 1, nums, target) || adjTest(start + 2, nums, target - nums[start]);		//use recursion to return either a subset of start + 1 of the array OR test if start+2 and target-nums[start] makes the method true
		
	} //end adjTest()
	
	/**********************************************************
	**  Method Name: printReportTitle()                      **
	**  Inputs: a String variable that will be printed       **
	**  Returns: a boolean that tells if it was successful   **
	**  Description: Takes in a title variable and prints it **
	**               if the title is 40 or less characters   ** 
	**********************************************************/

	public static boolean printReportTitle(String title) {

		int length = 40;                                        //create int variable that represents the number of dashes before and after the title
        boolean successful = false;                             //create boolean variable that represents if title was printed successfully
        
        if(title.length() <= 40){
        
            successful = true;                                  //sets successful to true
        
            for(int i = 0; i < length; i++){

                if((length - i) == 1){
            
                    System.out.println("-");                    //print 1 dash and add a line after the print
                    break;                                      //break from the for loop
                
                } //end if statement that adds extra line after print if on the last dash
            
                System.out.print("-");                          //print 1 dash with no line underneath
        
            } //end for loop that prints all 40 dashes
            int center = (length / 2) - (title.length() /2);    //create int variable that calculates the amount of space needed to center title
        
            for(int i = 0; i < center; i++){
            
            	System.out.print(" ");                      	//prints spaces 
                
            } //end for loop that prints the appropriate amount of spacing to make the title centered
            
            System.out.println(title);                     		//prints the title sent into the method 
     
            for(int i = 0; i < length; i++){
            	
	        	if((length - i) == 1){
	    	            
	        		System.out.println("-" + "\n");             //print 1 dash and add a line after the print
	        		break;                                      //break from the for loop
	                
	        	} //end if statement that adds extra line after print if on the last dash
	            	
	        	System.out.print("-");                          //prints 1 dash with no line underneath
	            
	        }//end for loop that prints all 40 dashes   
            
        //end if that sets successful to true if title is <= 40 characters
        }else{
        
            successful = false;                                 //sets successful to false

        } //end else that sets successful to false if title is over 40 characters long
        
        return successful;										//return if successful or not 
        
	}//end of printReportTitle
} //end HardRecursive