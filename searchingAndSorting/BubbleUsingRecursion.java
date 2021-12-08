/************************************************************
**  Name: Madison Gosselin                        		   **
**  Class Name: BubbleUsingRecursion.java				   **
**  Creation Date: 12-08-2021                     		   **
**  Description: This is a program that uses a method  	   **
**               to bubble sort an array using recurssion  **
************************************************************/

import java.io.*;		//import java libraries

public class BubbleUsingRecursion{
	public static void main(String[] args) throws IOException {
		
		printReportTitle("Recursive Bubble");						//send title to printReportTitle method
			
		int[] unsortedData = new int[] {2, 10, 4, 2000, 8, 1, 0};	//create an unsorted array
		System.out.print("Original Array: ");						//print the title for the following print
		
		for(int x = 0; x < unsortedData.length; x++) {
			System.out.print(unsortedData[x] + " ");				//print the unsorted data
		} //end for loop that prints the original array
		
			int[] sortedData = RecursiveBubble(unsortedData, unsortedData.length); 		//create a sorted array that calls the sorting method
			System.out.print("\nSorted Array: ");					//print the title for the following print
		
		for(int x = 0; x < sortedData.length; x++) {
			System.out.print(sortedData[x] + " ");					//print the sorted data
		} //end for loop that prints the sorted array
	} //end main method
	
	/**********************************************************
	**  Method Name: RecursiveBubble()                       **
	**  Inputs: an Array to be sorted				         **
	**  Returns: a sorted Array							     **
	**  Description: Takes in an int array and bubble sorts  **
	**               it using recursion					     ** 
	**********************************************************/
	
	public static int[] RecursiveBubble(int[] array, int arrayLen) {

		if(arrayLen == 1) return array;		//check if the array length is 1, if so return the array, the sort is done
		for(int x = 0; x < array.length - 1; x++) {
			if(array[x]>array[x+1]) {
				
				int temp = array[x];		//put the value to be swapped in a temp variable
				array[x] = array[x+1];		//swap the two values
				array[x+1] = temp;			//place the larger value in the latter pos
				
			} //end if that swaps the values if they are out of order
		} //end for that sorts the array
		
		return RecursiveBubble(array, arrayLen-1);	//return the array back to the method to do a second pass 
		
	} //end RecursiveBubble()
	
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
} //end BubbleUsingRecursion